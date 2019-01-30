package org.test.epamtasks.part2task1234;

import java.util.Objects;
import java.util.Scanner;

public abstract class Stationery implements Comparable {
    String type;
    String itemName;
    double price;

    public Stationery(String type, String itemName, double price) {
        this.type = type;
        this.itemName = itemName;
        this.price = price;
    }

    public String getFullInfo() {
        return String.format(
                "type:%s, itemName:%s, price:%.2f",
                type,
                itemName,
                price);
    }

    @Override
    public int compareTo(Object o) {
        Stationery entry = (Stationery) o;

        if (Math.abs(price - entry.price) >= 0.01) {
            return ((price - entry.price) > 0) ? 1 : -1;
        }
        return itemName.compareTo(entry.itemName);
    }

    int compareToByPrice(Object o) {
        Stationery entry = (Stationery) o;
        if (Math.abs(price - entry.price) < 0.005) return 0;
        return ((price - entry.price) > 0) ? 1 : -1;
    }

    int compareToByName(Object o) {
        Stationery entry = (Stationery) o;
        return itemName.compareTo(entry.itemName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationery that = (Stationery) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(type, that.type) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, itemName, price);
    }


    static Stationery createNewStationeryByTerminal() {
        System.out.print("Insert Stationery type (pen / pencil / ruler / stapler) : ");
        Scanner scType = new Scanner(System.in);
        String type = scType.nextLine();

        switch (type) {
            case "pen":
                return Pen.getFromTerminal();
            case "pencil":
                return Pencil.getFromTerminal();
            case "ruler":
                return Ruler.getFromTerminal();
            case "stapler":
                return Stapler.getFromTerminal();
            default:
                System.out.println("Invalid value");
                break;
        }
        return null;
    }

    static Stationery getStationeryFromString(String str) {
        String[] StationeryInfo = str.split(", ");
        String type = StationeryInfo[0].substring(5);
        switch (type) {
            case "Pen":
                return Pen.getFromArr(StationeryInfo);
            case "Pencil":
                return Pencil.getFromArr(StationeryInfo);
            case "Ruler":
                return Ruler.getFromArr(StationeryInfo);
            case "Stapler":
               return Stapler.getFromArr(StationeryInfo);
            default:
                break;
        }
        return null;
    }
}