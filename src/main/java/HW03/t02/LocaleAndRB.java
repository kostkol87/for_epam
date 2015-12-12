package HW03.t02;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleAndRB {

    private ResourceBundle bundle_q;
    private ResourceBundle bundle_a;
    private Scanner scanner = new Scanner(System.in);

    public void setBundleLocale(Locale locale) {
        bundle_q = ResourceBundle.getBundle("questions", locale);
        bundle_a = ResourceBundle.getBundle("answers", locale);

        Enumeration<String> keys = bundle_q.getKeys();

        while (keys.hasMoreElements()) {
            String s = keys.nextElement();
            System.out.println(s.substring(1) + ". " + bundle_q.getString(s));
        }
    }

    public void getBundleQuestions(int q) {
        System.out.println(bundle_a.getString("q" + q));
    }

    public void quiz() {
        int i;
        System.out.println("Select language/Выберите язык:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.print(">>> ");
        i = scanner.nextInt();
        switch (i) {
            case 1: {
                setBundleLocale(new Locale("en", "US"));
                break;
            }
            case 2: {
                setBundleLocale(new Locale("ru", "RU"));
                break;
            }
        }
        System.out.print(">>> ");
        getBundleQuestions(scanner.nextInt());
    }

    public static void main(String[] args) {
        LocaleAndRB localeAndRB = new LocaleAndRB();
        localeAndRB.quiz();
    }
}
