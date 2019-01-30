package org.test.epamtasks.part2task1234;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Pen extends Stationery {
    private String inkColor;
    private boolean branded;

    public Pen(String itemName, double price, String inkColor, boolean branded) {
        super("Pen", itemName, price);
        this.inkColor = inkColor;
        this.branded = branded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pen pen = (Pen) o;
        return branded == pen.branded &&
                Objects.equals(inkColor, pen.inkColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inkColor, branded);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "inkColor='" + inkColor + '\'' +
                ", branded=" + branded +
                ", type='" + type + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public String getFullInfo() {
        return String.format(
                "type:%s, itemName:%s, price:%.2f, inkColor:%s, branded:%s",
                type,
                super.itemName,
                super.price,
                inkColor,
                branded);
    }

    public static Pen getFromArr(String[] penInfo) {
        return new Pen(
                penInfo[1].substring(9),
                Double.valueOf(penInfo[2].substring(6)),
                penInfo[3].substring(9),
                penInfo[4].substring(8).equals("true")
        );
    }

    public static Pen getFromTerminal() {

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

        System.out.print("Insert ink color: ");
        Scanner scInk = new Scanner(System.in);
        String ink = scInk.nextLine();


        boolean branded = false;
        boolean flag = true;
        while (flag) {
            System.out.print("Is pen branded (yes / no ?): ");
            Scanner scBrand = new Scanner(System.in);
            String s = scBrand.nextLine();
            switch (s) {
                case "yes":
                    branded = true;
                    flag = false;
                    break;
                case "no":
                    flag = false;
                    break;
                default:
                    System.out.println("incorrect value");
                    break;
            }
        }

        return new Pen(name, price, ink, branded);
    }


}
