package HW04.t04;

import junit.framework.Assert;
import org.junit.Test;

public class FilmTest {

    @Test
    public void testName() throws Exception {
        FilmsCollection films = new FilmsCollection();
        films.add(new Film("Ливень", "Морган Фримен", "Кристиан Слэйтер", "Рэнди Куэйд"));
        films.add(new Film("Области тьмы", "Брэдли Купер", "Джейк Макдорман", "Дженнифер Карпентер"));
        films.add(new Film("Анклав", "Филип Шубарич", "Денис Мурич", "Ненад Станойкович"));

        Film.persist(films);

        FilmsCollection restored = Film.restore();
        for (Film film : restored) {
            System.out.println(film);
        }
        Assert.assertEquals(films.size(), restored.size());
    }
}