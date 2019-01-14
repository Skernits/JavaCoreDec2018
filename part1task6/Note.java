package org.test.epamtasks.part1task6;

/**
 * @author Svetlana Kernitskaya
 * Class Note creates note for containing in Notepad
 */

public class Note {
    private String note;

    public Note(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }
}
