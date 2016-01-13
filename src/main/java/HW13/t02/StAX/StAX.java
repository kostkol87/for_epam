package HW13.t02.StAX;

import HW13.t02.Food;
import HW13.t02.MenuTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAX {
    public static final String XML = "C:\\epam\\src\\main\\java\\HW13\\t02\\breakfast-menu.xml";

    public List<Food> parse_it(String xml) {
        try {
            List<Food> result = new ArrayList<>();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xml));
            Food food = null;
            MenuTagName elementName = null;
            while (reader.hasNext()) {
                int type = reader.next();


                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String tmpName = reader.getLocalName();
                        elementName = getTagName(tmpName);
                        switch (elementName) {
                            case FOOD:
                                food = new Food();
                                food.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (text.isEmpty()) {
                            break;
                        }
                        switch (elementName) {
                            case NAME:
                                food.setName(text);
                                break;
                            case PRICE:
                                food.setPrice(text);
                                break;
                            case DESCRIPTION:
                                food.setDescription(text);
                                break;
                            case CALORIES:
                                Integer calories = Integer.parseInt(text);
                                food.setCalories(calories);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = getTagName(reader.getLocalName());
                        switch (elementName) {
                            case FOOD:
                                result.add(food);
                        }
                }
            }

            return result;
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MenuTagName getTagName(String element) {
        MenuTagName result = MenuTagName.NULL;
        try {
            if (element != null){
                result = MenuTagName.valueOf(element.toUpperCase().replace("-", "_"));
            }
        } catch (EnumConstantNotPresentException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void demo(){
        List<Food> foods = new StAX().parse_it(StAX.XML);
        for( Food food : foods){
            System.out.println(food);
        }
    }
}
