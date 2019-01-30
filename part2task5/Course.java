package org.test.epamtasks.part2task5;


public enum Course {
    DISCIPLINE1("Eng", true),
    DISCIPLINE2("Java", false),
    DISCIPLINE3("Math", true);

    String name;
    boolean integerTypeOfGrades;

    Course(String name, boolean integerTypeOfGrades) {
        this.name = name;
        this.integerTypeOfGrades = integerTypeOfGrades;
    }

    String getFullInfo() {
        return name + " integerTypeOfGrades: " + integerTypeOfGrades;
    }

}
