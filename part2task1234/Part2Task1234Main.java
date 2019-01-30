package org.test.epamtasks.part2task1234;

import java.util.*;

public class Part2Task1234Main {
    final static String path = "./testRegistry.txt";
    final static String regexWorkPlace = "#WorkPlace# ";
    final static String regexStationery = "#Stationery# ";


    public static void main(String[] args) {
        System.out.println("uploading registry from: " + path + "...");
        Registry registry = Registry.uploadRegistry();

        System.out.println("Usage:\n " +
                "1 - print list of Employes \n " +
                "2 - find Workplace by Employee ID, display details of Stationary Kit and total price \n " +
                "3 - add Stationery to exist Workplace \n " +
                "4 - create new Workplace whith New Employee Stationery Kit \n " +
                "0 - exit App \n " +
                ".........");

        boolean flafForExit = true;
        while (flafForExit) {
            System.out.print("Insert command number: ");
            Scanner sc = new Scanner(System.in);

            try {
                int command = sc.nextInt();
                switch (command) {
                    case 1:
                        for (WorkPlace wp : registry.getWorkPlaceList()) {
                            System.out.println(wp.getFullInfo());
                        }
                        break;

                    case 2:
                        System.out.print("Insert Employee ID: ");
                        Scanner scID = new Scanner(System.in);
                        String id = scID.nextLine();
                        if (registry.findWorkPlaceByID(id) == null) {
                            System.out.println("This ID doesn't exist");
                        } else {
                            WorkPlace wp = registry.findWorkPlaceByID(id);
                            System.out.println(wp.getFullInfo());
                            StationeryKit kit = registry.findKStationeryKitByID(id);
                            System.out.println("Print sorted list?\n" +
                                    "default - unsorted list \n" +
                                    "1 - sorted by name \n" +
                                    "2 - sorted by price \n" +
                                    "3 - sorted by price then by name \n"
                            );
                            Scanner srt = new Scanner(System.in);
                            String sortType = srt.nextLine();
                            switch (sortType) {
                                case "1":
                                    kit.sortByName();
                                    break;
                                case "2":
                                    kit.sortByPrice();
                                    break;
                                case "3":
                                    kit.sortByPriceByName();
                                    break;
                                default:
                                    break;
                            }
                                List<Stationery> stationeryList = kit.getStationeries();
                                for (Stationery stationery : stationeryList) {
                                    System.out.println(stationery.getFullInfo());
                                }
                            System.out.println(String.format("Total, rub.: %.2f", registry.SumPerEmployee(id)));
                        }
                        break;

                    case 3:
                        System.out.print("Insert Employee ID: ");
                        Scanner scid = new Scanner(System.in);
                        String iD = scid.nextLine();
                        if (registry.findWorkPlaceByID(iD) != null) {
                            System.out.println("Add Stationery to " + registry.findWorkPlaceByID(iD).getFullInfo());
                            try {
                                Stationery newStationery = Stationery.createNewStationeryByTerminal();
                                if (newStationery != null) {
                                    registry.addStationeryToWorkPlaceByID(iD, newStationery);
                                    registry.saveToFile();
                                }
                            } catch (NullPointerException e) {
                                System.out.println("Incorrect value. You return to main menu");
                            }

                        } else {
                            System.out.print("ID doesn't exist.");
                        }
                        break;

                    case 4:
                        System.out.print("Insert Employee ID: ");
                        scid = new Scanner(System.in);
                        iD = scid.nextLine();
                        if (registry.findWorkPlaceByID(iD) != null) {
                            System.out.println("This ID already exists. You return to main menu");
                        } else {
                            registry.addNewEmployee(WorkPlace.getFromTerminal(iD));
                            registry.saveToFile();
                            System.out.println("New Workplace is created. New employee kit is added");
                        }
                        break;

                    case 0:
                        flafForExit = false;
                        break;

                    default:
                        System.out.println("Incorrect value");
                        break;
                }
            } catch (InputMismatchException iE) {
                System.out.println("Incorrect value");
            }
        }
    }
}
