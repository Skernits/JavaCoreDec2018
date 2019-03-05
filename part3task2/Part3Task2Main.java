package org.epamtasks.part3task2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part3Task2Main {
    public static void main(String[] args) {
        String language = "";
        String country = "";
        System.out.println("Usage:\n " +
                "1 - Русский \n " +
                "default - English");
        char i = 0;
        try {
            i = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (i) {
            case '1':
                language = "ru";
                country = "RU";
                break;
            default:
                language = "en";
                country = "US";
                break;
        }

        Locale locale = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("resource/p3t2text", locale);

        for (String key : rb.keySet()) {
            if (key.startsWith("q")) {
                System.out.println(rb.getString(key));
            }
        }
        System.out.println(rb.getString("str"));

        int questionIdx = 0;
        Scanner sc = new Scanner(System.in);
        try {
            questionIdx = sc.nextInt();
            System.out.println(rb.getString("a"+ questionIdx));
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

    }
}

