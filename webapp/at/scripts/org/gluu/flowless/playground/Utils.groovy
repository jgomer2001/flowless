package org.gluu.flowless.playground;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.*;

public class Utils {
/*
    public static String filenameExtension(String fileName) {
        int dotAt = fileName.lastIndexOf(".");
        return dotAt > 0 ? fileName.substring(dotAt + 1) : null;
    }

    public static String fileContents(Path path) throws IOException {
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }

    public static void contentsToFile(Path path, String contents) throws IOException {
        Files.write(path, contents.getBytes());
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }
    
    public static void test2(int a, Boolean b, Map<String,Integer> c, String d, List<Integer> e) {
        System.out.println("@test1");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
    public static int test1(Integer a) throws Exception {
        System.out.println(a);
        System.out.println(a.getClass());
        
        //throw new java.io.IOException("sup");
        //return a.getClass().getName().length();
        return 1;
    }
*/
    public static int myMethod(List<Integer> elements) {
        return elements.stream().mapToInt(x -> x).sum();
    }
    
}
