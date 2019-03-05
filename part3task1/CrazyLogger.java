package org.epamtasks.part3task1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CrazyLogger {
    private StringBuilder log;
    private final static String regex = "\n";

    public CrazyLogger() {
        this.log = new StringBuilder();
        log.append(regex);
    }

    void addMassage (String message, LocalDateTime dateTime) {
        log.append(dateTime.format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"))).append(" - ").append(message);
        log.append(regex);
    }


    String findMessages(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < log.length() - str.length(); i++) {
            if (log.substring(i).startsWith(str)) {
                int messageStart = log.lastIndexOf(regex, i) + regex.length();
                int messageEnd = log.indexOf(regex, i);
                result.append(log.substring(messageStart, messageEnd));
                i = messageEnd + regex.length() - 1;
            }
        }
        return result.toString();
    }

    String showLog() {
        return log.toString();
    }

   OutputStream outputStreamSearch(InputStream searchStr) throws IOException {
       Scanner sc = new Scanner(searchStr);
       String str = sc.nextLine();
       String result = findMessages(str);
       byte[] bytesOut = result.getBytes("UTF-8");
       OutputStream outputStream = new ByteArrayOutputStream();
       outputStream.write(bytesOut);

       return outputStream;
   }



}
