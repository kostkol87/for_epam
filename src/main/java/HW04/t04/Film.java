package HW04.t04;

import java.io.*;
import java.util.Arrays;

public class Film implements Serializable{

    final static String DEFAULT_PATH = System.getProperty("user.dir") + "/src/main/resources/" + "films.collection";

    String title;
    String[] actors;

    public Film(String title, String ... actors) {
        this.title = title;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }

    public static FilmsCollection restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Film.DEFAULT_PATH))) {
            FilmsCollection films = (FilmsCollection) ois.readObject();
            return films;
        }
    }

    public static void persist(FilmsCollection films) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Film.DEFAULT_PATH))) {
            oos.writeObject(films);
        }
    }
}
