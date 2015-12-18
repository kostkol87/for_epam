package HW04.t04;

import junit.framework.Assert;
import org.junit.Test;

public class FilmTest {

    @Test
    public void testName() throws Exception {
        FilmsCollection films = new FilmsCollection();
        films.add(new Film("������", "������ ������", "�������� �������", "����� �����"));
        films.add(new Film("������� ����", "������ �����", "����� ���������", "��������� ���������"));
        films.add(new Film("������", "����� �������", "����� �����", "����� �����������"));

        Film.persist(films);

        FilmsCollection restored = Film.restore();
        for (Film film : restored) {
            System.out.println(film);
        }
        Assert.assertEquals(films.size(), restored.size());
    }
}