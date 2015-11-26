package JAVA.SE.HW01.t06;

public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        for (int i = 0; i < 11; i++) {
            notepad.addNote(new Note());
        }

        notepad.changeNote(5);

        notepad.rmNote(1);

        notepad.showNotes();
    }
}
