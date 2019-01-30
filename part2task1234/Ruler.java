package org.test.epamtasks.part2task1234;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ruler extends Stationery {
    private int length;

    public Ruler(String itemName, double price, int length) {
        super("Ruler", itemName, price);
        this.length = length;
    }

    @Override
    public String getFullInfo() {
        return String.format(
                "type:%s, itemName:%s, price:%.2f, length:%d",
                type,
                itemName,
                price,
                length);
    }

    static Ruler getFromArr(String[] rulerInfo) {
        return new Ruler(
                rulerInfo[1].substring(9),
                Double.valueOf(rulerInfo[2].substring(6)),
                Integer.valueOf(rulerInfo[3].substring(7))
        );
    }

    static Ruler getFromTerminal() {

        System.out.print("Insert itemName: ");
        Scanner scItemName = new Scanner(System.in);
        String name = scItemName.nextLine();

        double price;
        while (true) {
            System.out.print("Insert price: ");
            Scanner scPrice = new Scanner(System.in);
            try {
                price = scPrice.nextDouble();
                break;
            } catch (InputMismatchException iE) {
                System.out.println("incorrect value");
            }
        }
        int length;
        while (true) {
            System.out.print("Insert length: ");
            Scanner scLength = new Scanner(System.in);
            try {
                length = scLength.nextInt();
                break;
            } catch (InputMismatchException iE) {
                System.out.println("incorrect value");
            }
        }
        return new Ruler(name, price, length);
    }
}
