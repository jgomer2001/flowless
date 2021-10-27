package org.gluu.flowless.playground;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.regex.Pattern;

public class Utils {

    private static final Pattern qualifiedJavaClassName = Pattern.compile("^\\w+(\\.\\w+)*$");
    
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
    
    public static String guessQualifiedPackageName(String javaSource) {
        
        String fqdn;
        String pack = "package";
        int from = 0;
        
        do {
            fqdn = null;
            int i = javaSource.indexOf(pack, from);
            if (i >= 0) {
                int j = javaSource.indexOf(";", i + 1);
                
                if (j > 0) {
                    fqdn = javaSource.substring(i + pack.length() + 1, j).strip();

                    //System.out.println("Candidate fqdn " + fqdn);
                    if (qualifiedJavaClassName.matcher(fqdn).matches()) {
                        break;
                    } else {
                        fqdn = null;
                        from = i + pack.length();
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        } while (from < javaSource.length());
        
        return fqdn;
        
    }
    
    public static void main(String ...args) throws Exception {
    
        //aaaaab
        //package co
        //package co; + variants
        //package pa.co;
        //wtf in the package of sin;
        //package blah ; package boo; + variants
        String q = guessQualifiedPackageName("package pa.co;");
        System.out.println(q);
        
    }

}
