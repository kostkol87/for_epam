package JAVA.SE.HW01.t06;

import java.util.Arrays;

public class Notepad {
    static int notesCounter = 1;
    private Note[] notes = new Note[10];

    /**
     * Добавление новой записи в блокнот.
     *
     *  Длинна массива {@link #notes} удваивается при заплнении.
     */
    public void addNote() {
        if (notes[notes.length - 1] != null) {
            notes = Arrays.copyOf(notes, notes.length * 2);
        }
        notes[Notepad.notesCounter] = new Note();
    }

    /**
     * Удаление записи
     * @param noteId - идентификатор записи для удаления
     */
    public void rmNote(int noteId) {
        notes[noteId] = null;
    }

    /**
     * Изменение записи
     * @param noteId - идентификатор записи для изменения
     */
    public void changeNote(int noteId) {
        notes[noteId].setNote();
    }

    /**
     * Показать все записи в блокноте через стандартный поток вывода
     */
    public void showNotes() {
        for (Note note : notes) {
            if (note != null){
                System.out.println(note.getNote());
            }
        }
    }
}
