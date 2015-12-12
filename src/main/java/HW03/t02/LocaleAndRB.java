package HW03.t02;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Enumeration;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class LocaleAndRB {
    ResourceBundle bundle;

    public LocaleAndRB(Locale locale){
        bundle = ResourceBundle.getBundle("resource", locale);

    }

    public static void main(String[] args) {
        LocaleAndRB localeAndRB = new LocaleAndRB(new Locale("en", "US"));
        Enumeration<String> keys = localeAndRB.bundle.getKeys();
        String s;
        try {
            while ((s = keys.nextElement()) != null){
                System.out.println(s);
            }
        }catch (NoSuchElementException e){

        }
    }
}
