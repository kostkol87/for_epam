package HW13.t01;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Создайте xml-файл, хранящий информацию о книгах из домашней библиотеки. Создайте
 * xsd-схему, валидирующую этот файл. При разработке XSD в обязательном порядке используйте
 * простые и комплексные типы, перечисления, шаблоны и предельные значения, атрибуты и тип ID.
 */
public class XMLValidatetor {
    public static void main (String args[]) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File("C:\\epam\\src\\main\\java\\HW13\\t01\\books.xml"));

// create a SchemaFactory capable of understanding WXS schemas
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

// load a WXS schema, represented by a Schema instance
        Source schemaFile = new StreamSource(new File("C:\\epam\\src\\main\\java\\HW13\\t01\\books.xsd"));
        Schema schema = factory.newSchema(schemaFile);

// create a Validator instance, which can be used to validate an instance document
        Validator validator = schema.newValidator();

// validate the DOM tree
        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException e) {
            // instance document is invalid!
            System.out.println("document invalid!");
        }
    }
}
