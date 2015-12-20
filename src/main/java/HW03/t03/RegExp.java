package HW03.t03;

import javax.swing.text.BadLocationException;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    final String FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/Java.SE.03.Information handling_task_attachment.html";
    final String OUTPUT = System.getProperty("user.dir") + "/src/main/resources/output.html";

    public String collectFromHTML(String file) throws IOException, BadLocationException {
        StringBuilder html = new StringBuilder();

        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            String tmp;
            while ((tmp = in.readLine()) != null) {
                html.append(tmp.trim());
            }
            return html.toString();
        }
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

    public String markSentences(String html, String output) throws IOException, BadLocationException {
        Pattern sentence = Pattern.compile("" +
                "(?![^\\.]\\s+|\\s+<div>|\\s+<p>)(?![^\\.]\\s+[\\(\\\"`'])([\\\"\\`\\']?[А-ЯA-Z]" +
                "[^\\.\\!\\?]*((\\([р|Р]ис\\.|[р|Р]исунке)\\s?(\\d+)\\)?)+(.)*?)(?=[\\.\\!\\?](\\s|\\Z|</div>|</p>))");

        Matcher matcherS = sentence.matcher(html);

        ArrayList<String> sentences = new ArrayList<>();

        while (matcherS.find()) {
            sentences.add(matcherS.group());
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (String str : sentences) {
                html = html.replace(str, "<font size=\"5\" color=\"red\" face=\"Arial\">" + str + "</font>");
            }
        }
        return sentences.size() + " sentences was marked";
    }
}
