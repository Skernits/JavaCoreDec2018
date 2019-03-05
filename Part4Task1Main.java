package org.epamtasks.part4;

import java.io.*;
import java.util.HashMap;

public class Part4Task1Main {

    private static final String PATH = "test-file.txt";
    private static final String PATHOUT1 = "test-fileOut1.txt";

    public static void main(String[] args) {

        byte[] bytesFromFile = new byte[0];

        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            bytesFromFile = new byte[fileInputStream.available()];
            fileInputStream.read(bytesFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String strFromFile = "";
        try {
            strFromFile = new String(bytesFromFile, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> keyWordsInFile = KeyWords.keyWordsCounter(strFromFile);

        try (FileOutputStream fileOutputStream = new FileOutputStream(PATHOUT1)) {
            for (String word : keyWordsInFile.keySet()) {
                String wordCount = word + " = " + keyWordsInFile.get(word) + "\n";
                byte[] wordStreamOut = wordCount.getBytes("UTF-8");
                fileOutputStream.write(wordStreamOut);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}