package HW04.t01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
 * языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте
 * только байтовые потоки ввода-вывода.
 */
public class BytesJavaKeyWords {

    public String readFile(String path) throws IOException {

        try (FileInputStream fis = new FileInputStream(path)){
            StringBuilder fileContent = new StringBuilder();

            byte[] buff = new byte[64];

            while ((fis.read(buff)) != -1) {
                fileContent.append(new String(buff, "cp1251"));
            }
            fis.close();
            return fileContent.toString();
        }
    }

    public static Map<String, Integer> searchAndCount(String fileContent) {
        Pattern pattern = Pattern.compile("abstract|assert|boolean|break|byte|" +
                "case|catch|char|class|const|continue|default|do|double|else|" +
                "enum|extends|final|finally|float|for|goto|if|implements|import|" +
                "instanceof|int|interface|long|native|new|package|private|protected|" +
                "public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while");

        Matcher matcher = pattern.matcher(fileContent);
        Map<String, Integer> resultMap = new HashMap<>();
        while (matcher.find()) {
            String group = matcher.group();
            if (resultMap.containsKey(group)) {
                Integer i = resultMap.get(group);
                resultMap.put(group, ++i);
            } else {
                resultMap.put(group, 1);
            }
        }
        return resultMap;
    }
}
