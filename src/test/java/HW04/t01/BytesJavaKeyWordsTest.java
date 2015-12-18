package HW04.t01;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

public class BytesJavaKeyWordsTest {

    @Test
    public void testReadFile() throws Exception {
        BytesJavaKeyWords bytesJavaKeyWords = new BytesJavaKeyWords();
        String content = bytesJavaKeyWords.readFile(System.getProperty("user.dir") + "/src/main/java/HW03/t03/RegExp.java");
        System.out.println(content);
        Assert.assertTrue(content != null);
    }

    @Test
    public void testSearchAndCount() throws Exception {
        BytesJavaKeyWords bytesJavaKeyWords = new BytesJavaKeyWords();
        String content = bytesJavaKeyWords.readFile(System.getProperty("user.dir") + "/src/main/java/HW03/t03/RegExp.java");
        Map<String, Integer> kwAndCount = bytesJavaKeyWords.searchAndCount(content.toString());
        for (Map.Entry<String, Integer> pair : kwAndCount.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        Assert.assertEquals(6, (int) kwAndCount.get("new"));
    }
}