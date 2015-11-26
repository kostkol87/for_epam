package JAVA.SE.HW01.t06;

import java.util.Scanner;

public class Note {
    private String note;
    private int id;
    private Scanner scanner = new Scanner(System.in);

    public Note() {
        this.id = Notepad.notesCounter;
        Notepad.notesCounter += 1;
        System.out.println("Введите текст записи № " + this.id + ": ");
        this.note = scanner.nextLine();

    }

    public String getNote() {
        return note;
    }

    public void setNote() {
        System.out.println("Вы меняете текст записи №" + this.id + ", введите новый текст записи: ");
        this.note = scanner.nextLine();
    }
}
