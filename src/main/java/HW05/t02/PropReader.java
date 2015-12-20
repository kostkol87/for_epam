package HW05.t02;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * —оздать УуниверсальныйФ класс, позвол€ющий получить значение из любого properties-
 * файла. ‘изическое чтение файла должно происходить только один раз. ќбработайте
 * следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.
 */
public class PropReader {

    public String getByKey(String key, String fName, String sep){
        Map<String, String> props = readFile(fName, sep);
        if (!props.containsKey(key)){
            System.err.println("Key does not exist...");
        }
        return props.get(key);
    }

    private Map<String, String> readFile(String fName, String sep) {
        Map<String, String> props = new HashMap<>();
        String line;
        String[] split;

        try (BufferedReader bfr = new BufferedReader(new FileReader(fName))) {
            while ((line = bfr.readLine()) != null) {
                split = line.trim().split(sep);
                if (split.length > 2 || split.length < 1){
                    System.out.println("incorect property file, part of data was lost");
                    return props;
                }if (split.length == 2) {
                    props.put(split[0], split[1]);
                }else {
                    props.put(split[0], "");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

}
