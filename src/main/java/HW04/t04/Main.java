package HW04.t04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    FilmsCollection films;

    public void main_loop() throws IOException, ClassNotFoundException {
        if (!new File(Film.DEFAULT_PATH).exists()){
            films = new FilmsCollection();
        }else {
            films = Film.restore();
        }

        System.out.println("1 - Отобразить всю коллекцию \r\n 2 - Добавить новый фильм \r\n 3 - удалить фильм \r\n 0 - выхлд");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                for (Film film:films) System.out.println(film);
                break;
            }case 2:{
                System.out.println("Введите название фильма");
                String title = scanner.nextLine();
                if(title != ""){
                    System.out.println("Введите актеров через запятую");
                    String[] actors = scanner.nextLine().toString().split(",");
                    if (actors.length != 0){
                        films.add(new Film(title, actors));
                        Film.persist(films);
                    }

                }

                break;
            }case 3:{
                System.out.println("Введите название фильма");
                String title = scanner.nextLine();
                for (Film film : films) {
                    if (film.title.equals(title));
                    films.remove(film);
                }
                Film.persist(films);
                break;
            }case 0:{
                Film.persist(films);
                break;
            }default:
                System.out.println("Bad choice =) Muhahahahaa");
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        while (true){
            m.main_loop();
        }

    }
}
