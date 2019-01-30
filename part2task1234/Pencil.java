package org.test.epamtasks.part2task1234;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pencil extends Stationery {

    public Pencil(String itemName, double price) {
        super("Pencil", itemName, price);
    }

    static Pencil getFromArr(String[] pencilInfo) {
        return new Pencil(
                pencilInfo[1].substring(9),
                Double.valueOf(pencilInfo[2].substring(6))
        );
    }

    static Pencil getFromTerminal() {

        System.out.print("Insert itemName: ");
        Scanner scItemName = new Scanner(System.in);
        String name = scItemName.nextLine();

        double price;
        while (true) {
            System.out.print("Insert price: ");
            Scanner scIPrice = new Scanner(System.in);
            try {
                price = scIPrice.nextDouble();
                break;
            } catch (InputMismatchException iE) {
                System.out.println("incorrect value");
            }
        }
        return new Pencil(name, price);
    }
}
