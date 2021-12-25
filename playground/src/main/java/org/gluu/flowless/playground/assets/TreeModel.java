package org.gluu.flowless.playground.assets;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gluu.flowless.playground.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeNode;

public class TreeModel {
    
    private static final String[] EXTENSIONS = new String[]{"css", "woff2", "js"
    , "jpg", "png", "svg", "gif", "ico", "webp", "txt", "xml", "html", "htm", "xhtml"
    , "ftl", "ftlh", "pdf"};

    public static SortedSet<String> ALLOWED_EXTENSIONS = Stream.of(EXTENSIONS)
            .collect(Collectors.toCollection(TreeSet::new));
            
    private static Set<String> MARKUP_EXTENSIONS = Stream.of("html", "htm", "xhtml",
            "ftl", "ftlh")
            .collect(Collectors.toCollection(HashSet::new));
    
    private static final Logger logger = LoggerFactory.getLogger(TreeModel.class);

    public static DefaultTreeModel<String> get(String basePath, boolean markupOnly) throws IOException {
        List<TreeNode<String>> nodes = new ArrayList<>();
        
        Files.walkFileTree(Paths.get(basePath), new SimpleFileVisitor<Path>() {
            
            TreeNode<String> parent = null;
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
         
                String ext = Utils.filenameExtension(file.getFileName().toString());
                if (ALLOWED_EXTENSIONS.contains(ext.toLowerCase())) {
                    if (!markupOnly || MARKUP_EXTENSIONS.contains(ext.toLowerCase())) {
                        parent.getChildren().add(new DefaultTreeNode<>(name(file)));
                    }
                } else {
                    logger.warn("Rejecting {}. File extension '{}' not recognized", file, ext);
                }
                return FileVisitResult.CONTINUE;
                
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                
                if (e == null) {
                    TreeNode<String> tmp = parent.getParent();
                    boolean empty = parent.getChildren().isEmpty();
                    
                    if (empty && tmp != null) {
                        logger.debug("Directory {} is empty. Removing from final representation", dir);
                        tmp.getChildren().remove(parent);
                    }
                    
                    if (tmp == null) {
                        nodes.add(parent);
                        //Traversal finishes here
                    } else {
                        parent = tmp;
                    }
                    
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
                
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                
                TreeNode<String> childrenLess = zeroChildrenNode(dir);
                if (parent == null) {
                    parent = childrenLess;
                } else {
                    parent.getChildren().add(childrenLess);
                    parent = childrenLess;
                }
                return FileVisitResult.CONTINUE;
                
            }
            
        });
        
        return new DefaultTreeModel<String>(nodes.get(0));

    }
    
    private static String name(Path path) {
        return path.getFileName().toString();
    }
    
    private static TreeNode<String> zeroChildrenNode(Path path) {
        return new DefaultTreeNode<>(name(path), new ArrayList<DefaultTreeNode<String>>());        
    }

}
