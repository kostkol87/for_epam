package HW01.t06;

import java.util.Scanner;

public class Note {
    private String note;
    private int id;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор создает новую запись в блокноте при созданиие объекта
     **/
    public Note() {
        id = Notepad.notesCounter;
        Notepad.notesCounter++;
        System.out.println("Enter text of new note № " + id + ": ");
        note = scanner.nextLine();
    }

    public String getNote() {
        return "Note " + id + "#: " + note;
    }

    public void setNote() {
        System.out.println("You're changing note №" + id + ", enter new text of note: ");
        note = scanner.nextLine();
    }
}
