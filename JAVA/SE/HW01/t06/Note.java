package JAVA.SE.HW01.t06;

import java.util.Scanner;

public class Note {
    private String note;
    private int id;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор создает новую запись в блокноте при созданиие объекта
     **/
    public Note() {
        this.id = Notepad.notesCounter;
        Notepad.notesCounter++;
        System.out.println("Enter text of new note № " + this.id + ": ");
        this.note = scanner.nextLine();

    }

    public String getNote() {
        return "Note " + this.id + "#: " + note;
    }

    public void setNote() {
        System.out.println("You're changing note №" + this.id + ", enter new text of note: ");
        this.note = scanner.nextLine();
    }
}
