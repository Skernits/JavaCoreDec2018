package org.epamtasks.part4;

import java.io.*;
import java.util.HashMap;

public class Part4Task2Main {
    private static final String PATH = "test-file.txt";
    private static final String PATHOUT2 = "test-fileOut2.txt";


    public static void main(String[] args) {

        StringBuilder stringBuffer = new StringBuilder();

        try (FileReader fr = new FileReader(PATH)){
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                stringBuffer.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> keyWordsInFile = KeyWords.keyWordsCounter(stringBuffer.toString());

        try (FileWriter fileOutputStream = new FileWriter(PATHOUT2)) {
            for (String word : keyWordsInFile.keySet()) {
                String wordCount = word + " = " + keyWordsInFile.get(word) + "\n";
                char[] wordStreamOut = wordCount.toCharArray();
                fileOutputStream.write(wordStreamOut);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
