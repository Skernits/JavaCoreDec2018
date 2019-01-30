package org.test.epamtasks.part2task1234;

import java.util.Scanner;

public class WorkPlace {
    private String emplFirstName;
    private String emplLastName;
    private String id;

    WorkPlace(String emplFirstName, String emplLastName, String id) {
        this.emplFirstName = emplFirstName;
        this.emplLastName = emplLastName;
        this.id = id;
    }

   String getId() {
        return id;
    }

    public String getFullInfo() {
        return String.format(
                "FirstName:%s, LastName:%s, ID:%s",
                emplFirstName,
                emplLastName,
                id);
    }

    static WorkPlace getFromString(String str) {
        String[] personArrString = str.split(", ");

        WorkPlace newWorkPlace = new WorkPlace(
                personArrString[0].substring(10),
                personArrString[1].substring(9),
                personArrString[2].substring(3)
        );
        return  newWorkPlace;
    }

    static WorkPlace getFromTerminal(String id) {

        System.out.print("Insert employee first name: ");
        Scanner scFirstName = new Scanner(System.in);
        String firstName = scFirstName.nextLine();

        System.out.print("Insert employee last name: ");
        Scanner scLastName = new Scanner(System.in);
        String lastName = scLastName.nextLine();

        return new WorkPlace(firstName, lastName, id);
    }

}
