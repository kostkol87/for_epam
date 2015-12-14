package HW03.t03;

import javax.swing.text.BadLocationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegExp {
    private final String filePath = System.getProperty("user.dir") + "/src/main/resources/Java.SE.03.Information handling_task_attachment.html";
    String html;
    public void collectFromHTML() throws IOException, BadLocationException {
        Pattern pattern = Pattern.compile("");
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String tmp;
        while ((tmp = in.readLine()) != null){
            html += tmp;
        }
        System.out.println(html);
    }

    public static void main(String[] args) throws IOException, BadLocationException {
        RegExp regExp = new RegExp();
        regExp.collectFromHTML();
    }
}
