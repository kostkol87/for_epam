package HW03;

import java.util.Calendar;
import java.util.Formatter;

public class CrazyLogger {
    private StringBuilder log;

    public void logIt(CharSequence msg){
        if (log == null){
            log = new StringBuilder();
        }
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();
        formatter.format("%1$td-%1$tm-%1$tY : %1$th-%1$tM - ",calendar);
        log.append(formatter.toString() + msg + "\r\n");
    }

    public StringBuilder getLog() {
        return log;
    }

    public void getBySubString(CharSequence msg){
        String[] logArr = getLog().toString().split("\r\n");

        for (String logStr: logArr){
            if (logStr.indexOf(msg.toString()) >= 0){
                System.out.println(logStr);
            }
        }
    }
}
