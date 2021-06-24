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
/*
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
    
    public static void main(String ...args) throws Exception {
Twilio.init("ACda98f9f158a7dfb51e4bb687de0fd13e", "bb3c25fba009e748e815c209870c7722");
String number ="+5511948839174";
String body="Hi gluuer, this is a Jose casa test";
String fromNumber="15122714951";
Message message = Message.creator(new PhoneNumber(number), new PhoneNumber(fromNumber), body).create();
Message.Status statusMsg = message.getStatus();
System.out.println("Message delivery status was "+ statusMsg.toString());
    }
*/ 
}
