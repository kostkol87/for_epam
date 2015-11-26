package JAVA.SE.HW01.t06;

import java.util.Arrays;

public class Notepad {
    static int notesCounter;
    private Note[] notes = new Note[10];

    public void addNote(Note note) {
        if (notes[notes.length - 1] != null) {
            this.notes = Arrays.copyOf(this.notes, notes.length * 2);
        }
        notes[Notepad.notesCounter] = note;
    }

    public void rmNote(int noteId) {
        notes[noteId] = null;
        System.out.println("Запись № " + noteId + " была успешно удалена");
    }

    public void changeNote(int noteId) {
        notes[noteId].setNote();

    }

    public void showNotes() {
        for (Note note : notes) {
            if (note == null){
                System.out.println("эта запись не существует!!!");
            }else {
                System.out.println("Запись: " + note.getNote());
            }
        }
    }
}
