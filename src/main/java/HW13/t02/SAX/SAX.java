package HW13.t02.SAX;

import HW13.t02.Food;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SAX {

    public static final String XML = "C:\\epam\\src\\main\\java\\HW13\\t02\\breakfast-menu.xml";

    public static void demo(){
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(XML));
            List<Food> foodList = handler.getFoods();
            for (Food food : foodList) {
                System.out.println(food);
            }
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
