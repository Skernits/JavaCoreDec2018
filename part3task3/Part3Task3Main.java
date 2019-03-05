package org.epamtasks.part3task3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.io.FileUtils.readFileToString;


public class Part3Task3Main {
    private static final Pattern patternPic = Pattern.compile("(\\([рР]ис\\.\\s?\\d+.*?\\))|([нН]а рисунке \\d+)|(рисунка \\d+)");
    private static final Pattern sentenсeSeparator = Pattern.compile("((\\s)(.*?)(?<![Рр]ис)[.?!])");
    private static final Pattern digit = Pattern.compile("\\d+");

    public static void main(String[] args) {
        String stringForParse = "";

        try {
            File article = new File("/Users/sveta/Documents/epam/Java.SE.03.attachment.html");
            stringForParse = readFileToString(article, "Cp1251");

        } catch (IOException e) {
            e.printStackTrace();
        }

        int pictureIdx = 0;
        Matcher picMatcher = patternPic.matcher(stringForParse);
        StringBuffer textWithMarker = new StringBuffer();

        while (picMatcher.find()) {
            String sample = picMatcher.group();
            System.out.println(sample);
            picMatcher.appendReplacement(textWithMarker, "<b>" + picMatcher.group() + "</b>");

            Matcher matcherDgt = digit.matcher(sample);
            while (matcherDgt.find()) {
                int idx = Integer.valueOf(matcherDgt.group());
                if (idx - pictureIdx == 1) {
                    pictureIdx = idx;
                }
                if (idx - pictureIdx > 1) {
                    System.out.println("Mistake in sequence of pictures links");
                }
            }
        }
        picMatcher.appendTail(textWithMarker);
        saveToFile(textWithMarker.toString());

    }

    private static void saveToFile(String strForSave) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("/Users/sveta/Documents/epam/articleresult.html")) {
            byte[] streamOut = strForSave.getBytes("Cp1251");
            fileOutputStream.write(streamOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

