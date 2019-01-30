package org.test.epamtasks.part2task1234;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stapler extends Stationery {
    private int stapleSize;

    public Stapler(String itemName, double price, int stapleSize) {
        super("Stapler", itemName, price);
        this.stapleSize = stapleSize;
    }
    @Override
    public String getFullInfo() {
        return String.format(
                "type:%s, itemName:%s, price:%.2f, stapleSize:%d",
                type,
                itemName,
                price,
                stapleSize);
    }

    static Stapler getFromArr(String[] staplerInfo) {
        return new Stapler(
                staplerInfo[1].substring(9),
                Double.valueOf(staplerInfo[2].substring(6)),
                Integer.valueOf(staplerInfo[3].substring(11))
        );
    }

    static Stapler getFromTerminal() {
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

        int stapleSize;
        while (true) {
            System.out.print("Insert length: ");
            Scanner scLength = new Scanner(System.in);
            try {
                stapleSize = scLength.nextInt();
                break;
            } catch (InputMismatchException iE) {
                System.out.println("incorrect value");
            }
        }
        return new Stapler(name, price, stapleSize);
    }
}
