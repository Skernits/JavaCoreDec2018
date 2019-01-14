package org.test.epamtasks.part1task6;

/**
 * Class contains Main method for testing Notepad class.
 * @author Svetlana Kernitskaya
 */

public class Part1Task6Main {

    public static void main(String[] args) {

        Notepad test1 = new Notepad();
//        test1.addNote("note1 for test 1");
//        test1.addNote("note2 for test 1");
//        test1.addNote("note3 for test 1");
//        test1.addNote("note4 for test 1");
//        test1.addNote("note5 for test 1");
//        test1.addNote("note6 for test 1");
//        test1.addNote("note7 for test 1");
//        test1.addNote("note8 for test 1");
//        test1.addNote("note9 for test 1");
//        test1.addNote("note10 for test 1");
//        test1.addNote("note11 for test 1");
//        test1.addNote("note12 for test 1");

        Note[] allNotesTest = test1.listAllNotes();
        for (int i = 0; i < allNotesTest.length; i++) {
            System.out.println(i + ". " + allNotesTest[i].toString());
        }

        if (test1.removeNote(0)) {
            System.out.println("Note has been removed");
        } else {
            System.out.println("Can't find this note");
        }

        if (test1.editNote(1, "Changed!!!")) {
            System.out.println("Note has been changed");
        } else {
            System.out.println("Can't find this note");
        }

        allNotesTest = test1.listAllNotes();
        for (int i = 0; i < allNotesTest.length; i++) {
            System.out.println(i + ". " + allNotesTest[i].toString());
        }

    }
}
