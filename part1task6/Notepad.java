package org.test.epamtasks.part1task6;

/**
 * Class provides storage of Notes and  gives possibility of adding, changing and removing Notes.
 * @author Svetlana Kernitskaya
 *
 */

public class Notepad {
    /**
     * notes - is storage (Array of Notes)
     */
    private Note[] notes = new Note[10];
    /**
     * idxNote - if index of "free for write" position in Array (last Note +1);
     */
    private int idxNote = 0; //

    public Notepad() { }

    /**
     * Method allow to add String to Notepad
     * @param str string for adding to Notepad
     */
    public void addNote(String str) {
        Note note = new Note(str);
        if (idxNote >= notes.length) {
            Note[] notesNew = new Note[idxNote + 10];
            for (int i = 0; i < idxNote; i++) {
                notesNew[i] = notes[i];
            }
            notes = notesNew;
        }
        notes[idxNote] = note;
        idxNote++;
    }

    /**
     * Method returns all Notes from Notepad
     * @return array of Notes
     */
    public Note[] listAllNotes() {
        Note[] allNotes = new Note[idxNote];
        for (int i = 0; i < idxNote; i++) {
            allNotes[i] = notes[i];
        }
        return allNotes;
    }

    /**
     * Method removes Note from Notepad by its index;
     * @param idx - index of note that we want to remove from Notepad
     * @return true - if note has been removed from Notepad; false - if idx is more then number of notes in Notepad.
     */
    public boolean removeNote(int idx) {   // remove note at idx - index;
        if (idx >= idxNote) {
            return false;
        } else {
            Note[] notesNew = new Note[notes.length];
            int j = 0;
            for (int i = 0; i < idx; i++) {
                notesNew[j] = notes[i];
                j++;
            }
            for (int i = idx + 1; i < idxNote; i++) {
                notesNew[j] = notes[i];
                j++;
            }
            notes = notesNew;
            idxNote = j;
        }
        return true;
    }

    /**
     * Method allows to edit Note
     *
     * @param idx - index of Note that we want to change.
     * @param newStr  - new String that should replace Note at idx in Notepad.
     */
    public boolean editNote(int idx, String newStr) {
        if (idx >= idxNote) {
            return false;
        } else {
            Note note = new Note(newStr);
            notes[idx] = note;
        }
        return true;

    }

}
