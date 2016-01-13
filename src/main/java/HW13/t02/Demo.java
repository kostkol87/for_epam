package HW13.t02;

import HW13.t02.DOM.DOM;
import HW13.t02.SAX.SAX;
import HW13.t02.StAX.StAX;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Проанализировать данный xml тремя видами парсеров: SAX, StAX и DOM.
 */
public class Demo {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        new SAX().demo();
        new StAX().demo();
        new DOM().demo();
    }
}
