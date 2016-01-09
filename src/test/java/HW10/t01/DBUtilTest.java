package HW10.t01;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class DBUtilTest {

    DBUtil dbUtil = new DBUtil();
    Connection con = dbUtil.getCon();


    @Test
    @Ignore("this test instead of psvm method")
    public void testMain() throws Exception {
        dbUtil.createTestTable(con);

        ArrayList<String[]> allFields = dbUtil.getAllFields(con);
        for (String[] strs : allFields) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        dbUtil.upadeLine(con, 1, "degrees fahrenheit".toUpperCase(), "Ray Bradbury");
        dbUtil.upadeLine(con, 2, "The Martian Chronicles".toUpperCase(), "Ray Bradbury");
        dbUtil.upadeLine(con, 3, "The October Country".toUpperCase(), "Ray Bradbury");

        dbUtil.getLine(con, 1);

        dbUtil.insertLine(con, "THE GOLDEN APPLES OF THE SUN", "Ray Bradbury");

        dbUtil.dropTable(con, "books");
    }
}