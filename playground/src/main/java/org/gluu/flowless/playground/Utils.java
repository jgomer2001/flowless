package org.gluu.flowless.playground;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public static String filenameExtension(String fileName) {
        int dotAt = fileName.indexOf(".");
        return dotAt > 0 ? fileName.substring(dotAt + 1) : null;
    }

    public static String fileContents(Path path) throws IOException {
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }

    public static void contentsToFile(Path path, String contents) throws IOException {
        Files.write(path, contents.getBytes());
    }

}
