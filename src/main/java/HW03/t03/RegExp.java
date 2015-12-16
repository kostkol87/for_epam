package HW03.t03;

import javax.swing.text.BadLocationException;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    private final String filePath = System.getProperty("user.dir") + "/src/main/resources/Java.SE.03.Information handling_task_attachment.html";
    private final String output = System.getProperty("user.dir") + "/src/main/resources/output.html";
    StringBuilder html = new StringBuilder();


    public String collectFromHTML() throws IOException, BadLocationException {

        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String tmp;
        while ((tmp = in.readLine()) != null) {
            html.append(tmp);
        }
        System.out.println(html);
        return html.toString();
    }

    public boolean isConseq(String html) {
        Pattern pattern = Pattern.compile("(\\([р|Р]ис.|[р|Р]исунке)\\s(\\d+)\\)?");
        Matcher matcher = pattern.matcher(html);
        int tmp = 0;
        while (matcher.find()) {
            int i = Integer.valueOf(matcher.group(2));
            if (tmp < i) {
                tmp = i;
            } else {
                return false;
            }
        }
        return true;
    }

    public String markSentences(String html) throws IOException, BadLocationException {
        Pattern sentence = Pattern.compile("(?![^\\.]\\s+|\\s+)(?![^\\.]\\s+[\\(\\\"`'])([\\\"\\`\\']?[А-ЯA-Z][^\\.\\!\\?]*((\\([р|Р]ис.|[р|Р]исунке)\\s(\\d+)\\)?)+(.)*?)(?=[\\.\\!\\?](\\s|\\Z))");
        Matcher matcherS = sentence.matcher(html);
        ArrayList<String> sentences = new ArrayList<>();
        while (matcherS.find()) {
//            System.out.println(matcherS.group());
            sentences.add(matcherS.group());
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        System.out.println("in " + html);
        for (String str : sentences) {
            html = html.replace(str, "<b>" + str + "</b>");
        }
        writer.write(html);
        writer.close();
        return sentences.size() + " sentences was marked";
    }

    public static void main(String[] args) throws IOException, BadLocationException {
        RegExp regExp = new RegExp();
        System.out.println(regExp.isConseq(regExp.collectFromHTML()));
        regExp.markSentences(regExp.collectFromHTML());
    }
}
