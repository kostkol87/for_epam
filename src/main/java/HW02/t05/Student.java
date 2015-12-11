package HW02.t05;

import java.util.EnumSet;

/**
 * Created by Konstantin on 10.12.2015.
 */
public class Student {
    private String name;
    private String surname;
    EnumSet<Subjects> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EnumSet<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(EnumSet<Subjects> subjects) {
        this.subjects = subjects;
    }
}
