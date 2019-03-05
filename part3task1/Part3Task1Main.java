package org.epamtasks.part3task1;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Part3Task1Main {
    public static void main(String[] args) {
        CrazyLogger logTest = new CrazyLogger();
        logTest.addMassage("Test1", LocalDateTime.now());
        logTest.addMassage("Test2", LocalDateTime.now());

        System.out.println("Usage:\n " +
                "0 - exit App \n " +
                "1 - search in CrazyLog \n " +
                "2 - show all messages in CrazyLog \n " +
                "3 - search using In/Out streams \n " +
                "default - message for save in log \n " +
                ".........");

        boolean flafForExit = true;
        while (flafForExit) {
            System.out.print("Insert command number or type message: ");
            Scanner sc = new Scanner(System.in);

            try {
                String command = sc.nextLine();
                switch (command) {
                    case "0":
                        flafForExit = false;
                        break;
                    case "1":
                        System.out.print("Insert string for search: ");
                        Scanner str = new Scanner(System.in);
                        String strForSearch = str.nextLine();
                        String searchResult = logTest.findMessages(strForSearch);
                        if (searchResult.isEmpty()) {
                            System.out.println("can't find anything");
                        } else {
                                System.out.println(searchResult);
                        }
                        break;
                    case "2":
                        System.out.println(logTest.showLog());
                        break;
                    case "3":
                        System.out.print("Insert string for search: ");
                        try {
                            OutputStream result = logTest.outputStreamSearch(System.in);
                            System.out.println(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        logTest.addMassage(command, LocalDateTime.now());
                        System.out.println("added to CrazyLog: " + command);
                        break;

                }
            } catch (InputMismatchException iE) {
                System.out.println("Incorrect value");
            }
        }
    }
}