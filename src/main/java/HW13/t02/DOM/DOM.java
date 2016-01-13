package HW13.t02.DOM;

import HW13.t02.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM {

    public static final String XML = "C:\\epam\\src\\main\\java\\HW13\\t02\\breakfast-menu.xml";
    //создание DOM-анализатора (Xerces)
   public void demo() throws ParserConfigurationException, IOException, SAXException {
       DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       Document document = documentBuilder.parse(XML);
       Element root = document.getDocumentElement();
       List<Food> menu = new ArrayList<Food>();
       NodeList foodNodes = root.getElementsByTagName("food");
       Food food = null;
       for (int i = 0; i < foodNodes.getLength(); i++) {
           food = new Food();
           Element foodElement = (Element) foodNodes.item(i);
           food.setId(Integer.parseInt(foodElement.getAttribute("id")));
           food.setName(getSingleChild(foodElement,
                   "name").getTextContent().trim());
           food.setDescription(getSingleChild(foodElement,
                   "description").getTextContent().trim());
           menu.add(food);
       }
       for (Food f: menu) {
           System.out.println(f);
       }
}

    private static Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;

    }
}
