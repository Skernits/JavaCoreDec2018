package org.test.epamtasks.part2task5;


public class Student {
    private String FirstName;
    private String LastName;
    private String id;

    public Student(String firstName, String lastName, String id) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.id = id;
    }

    String getFullInfo() {
        return FirstName + " " + LastName + " id: " + id;
    }

}
