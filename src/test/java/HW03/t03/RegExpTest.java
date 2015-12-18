package HW03.t03;

import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class RegExpTest {

    @Test
    public void testCollectFromHTML() throws Exception {
        RegExp regExp = new RegExp();
        String s = regExp.collectFromHTML(regExp.FILE_PATH);
        Assert.assertTrue(s.contains("элементарные коллапсары (описание элементарных и индуцированных коллапсаров дано в книге)."));
    }

    @Test
    public void testIsConseq() throws Exception {
        RegExp regExp = new RegExp();
        boolean conseq = regExp.isConseq(regExp.collectFromHTML(regExp.FILE_PATH));
        Assert.assertFalse(conseq);
    }

    @Test
    public void testMarkSentences() throws Exception {
        RegExp regExp = new RegExp();
        System.out.println(regExp.markSentences(regExp.collectFromHTML(regExp.FILE_PATH), regExp.OUTPUT));

        BufferedReader in = new BufferedReader(new FileReader(regExp.OUTPUT));
        StringBuilder html = new StringBuilder();
        String tmp;
        while ((tmp = in.readLine()) != null) {
            html.append(tmp.trim());
        }
        Assert.assertTrue(html.toString().contains("<font size=\"5\" color=\"red\" face=\"Arial\">"));
    }
}