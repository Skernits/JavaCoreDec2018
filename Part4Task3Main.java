package org.epamtasks.part4;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Part4Task3Main {
    private static final String PATH = "test-file.txt";
    private static final String PATHOUT3 = "test-fileOut3.txt";

    public static void main(String[] args) {

        byte[] bytesFromFile = new byte[0];

        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            bytesFromFile = new byte[fileInputStream.available()];
            fileInputStream.read(bytesFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String strFromFile = new String(bytesFromFile, StandardCharsets.UTF_8);

        try (FileOutputStream fileOutputStream = new FileOutputStream(PATHOUT3)) {
                byte[] streamOut = strFromFile.getBytes(StandardCharsets.UTF_16);
                fileOutputStream.write(streamOut);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
