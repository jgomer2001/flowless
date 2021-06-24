package org.gluu.flowless.playground.assets;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.gluu.flowless.playground.Utils;
import org.gluu.flowless.playground.ZKInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Immutable;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treeitem;

public class AssetsVM {

    private static final String[] TXT_EXTENSIONS = new String[]{"css", "js", "txt",
        "xml", "html", "htm", "xhtml"};
    private static final String ASSETS_DIR = "assets";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String basePath;
    private String contents;
    private String allowedExtensions;
    private DefaultTreeModel<String> treeModel;
    private Set<String> textFileExtensions;

    @Immutable
    public String getAllowedExtensions() {
        return allowedExtensions;
    }

    public DefaultTreeModel<String> getTreeModel() {
        return treeModel;
    }

    public String getContents() {
        return contents;
    }

    @Init
    public void init() {

        basePath = ZKInitializer.getBasePath() + File.separator + ASSETS_DIR;

        textFileExtensions = Stream.of(TXT_EXTENSIONS).collect(Collectors.toSet());
        allowedExtensions = TreeModel.ALLOWED_EXTENSIONS.toString();
        allowedExtensions = allowedExtensions.substring(1, allowedExtensions.length() - 1);

        reload();

    }

    private void reload() {
        
        try {
            logger.info("Computing tree model");
            contents = "";
            treeModel = TreeModel.get(basePath);
    
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        
    }
    
    @NotifyChange("contents")
    public void selected(Collection<Treeitem> items) throws IOException {

        //treeModel.getSelection() gives the selection but it will only retrieve
        // the string of the leaf, not the whole path
        Treeitem item = items.stream().filter(Treeitem::isSelected).findFirst().get();
        if (item.getTreechildren() == null) {   //A terminal node (no children)

            String ext = Utils.filenameExtension(item.getLabel());
            if (textFileExtensions.contains(ext)) {

                List<String> path = new ArrayList();
                path.add(0, item.getLabel());

                while (item.getParentItem() != null) {
                    item = item.getParentItem();
                    path.add(0, item.getLabel());
                }

                Path filePath = Paths.get(basePath, path.toArray(new String[0]));
                logger.debug("File '{}' selected", filePath);

                contents = Utils.fileContents(filePath);

                contents = contents.length() == 0 ? "empty file!" : contents;
            } else {
                contents = "Binary file";
            }
        } else {
            contents = "Directory";
        }
    }

    @NotifyChange({"contents", "treeModel"})
    public void uploaded(Media media) {

        byte[] blob = media.getByteData();
        logger.debug("Size of blob received: {} bytes. Extracting...", blob.length);
        int extracted = 0;
        int skipped = 0;

        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(blob))) {

            for (ZipEntry entry = zis.getNextEntry(); entry != null; entry = zis.getNextEntry()) {
                String entryName = entry.getName();
                logger.trace("Extracting {}", entryName);

                Path path = Paths.get(basePath, entryName.split(File.separator));

                if (entry.isDirectory()) {
                    path.toFile().mkdirs();
                } else {                    
                    String ext = Utils.filenameExtension(entryName);
                    
                    if (TreeModel.ALLOWED_EXTENSIONS.contains(ext)) {
                        try (OutputStream outStream = new FileOutputStream(path.toString())) {

                            byte[] buffer = new byte[4096];

                            int read = zis.read(buffer, 0, buffer.length);
                            while (read > 0) {
                                outStream.write(buffer, 0, read);
                                read = zis.read(buffer, 0, buffer.length);
                            }
                        }
                        extracted++;
                    } else {
                        logger.warn("Skipping {}", path);
                        skipped++;
                    }
                }
            }
            Messagebox.show(String.format("Finished: %d files extracted, %d skipped", extracted, skipped), 
                    null, Messagebox.OK, Messagebox.INFORMATION);
            reload();

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            Messagebox.show(e.getMessage(), null, Messagebox.OK, Messagebox.ERROR);
        }
    }

}
