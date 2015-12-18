package HW04.t02;

import HW04.t01.BytesJavaKeyWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
 * языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте
 * только символьные потоки ввода-вывода.
 */
public class SymbolicJavaKeyWords {
    public String readFile(String path) throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder fileContent = new StringBuilder();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                fileContent.append(tmp);
            }
            return fileContent.toString();
        }
    }
    public static Map<String, Integer> searchAndCount(String fileContent){
        return BytesJavaKeyWords.searchAndCount(fileContent);
    }
}
