package HW13.t02.SAX;

import HW13.t02.Food;
import HW13.t02.MenuTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 10.01.2016.
 */
public class SAXHandler extends DefaultHandler {
    List<Food> foods = new ArrayList<>();
    Food food;
    private StringBuilder text;

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));

        switch (tName) {
            case NAME:
                food.setName(text.toString());
                break;
            case PRICE:
                food.setPrice(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case CALORIES:
                food.setCalories(Integer.parseInt(text.toString()));
                break;
            case FOOD:
                foods.add(food);
                food = null;
                break;

        }
    }

}
