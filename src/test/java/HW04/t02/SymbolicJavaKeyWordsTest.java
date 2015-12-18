package HW04.t02;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

public class SymbolicJavaKeyWordsTest {

    @Test
    public void testReadFile() throws Exception {
        SymbolicJavaKeyWords symbolicJavaKeyWords = new SymbolicJavaKeyWords();
        String content = symbolicJavaKeyWords.readFile(System.getProperty("user.dir") + "/src/main/java/HW03/t03/RegExp.java");
        System.out.println(content);
        Assert.assertTrue(content != null);
    }

    @Test
    public void testSearchAndCount() throws Exception {
        SymbolicJavaKeyWords symbolicJavaKeyWords = new SymbolicJavaKeyWords();
        String content = symbolicJavaKeyWords.readFile(System.getProperty("user.dir") + "/src/main/java/HW03/t03/RegExp.java");
        Map<String, Integer> kwAndCount = symbolicJavaKeyWords.searchAndCount(content.toString());
        for (Map.Entry<String, Integer> pair : kwAndCount.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        Assert.assertEquals(6, (int) kwAndCount.get("new"));
    }
}