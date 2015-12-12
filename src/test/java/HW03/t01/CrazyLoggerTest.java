package HW03.t01;

import HW03.t01.CrazyLogger;
import org.junit.Assert;
import org.junit.Test;

public class CrazyLoggerTest {

    CrazyLogger clLogger = new CrazyLogger();

    @Test
    public void testLogIt() throws Exception {

        for (int i = 0; i < 20; i++) {
            clLogger.logIt("test logging " + i);
        }
        Assert.assertEquals(20, clLogger.getLog().toString().split("\r\n").length);
    }

    @Test
    public void testGetBySubString() throws Exception {

        for (int i = 0; i < 20; i++) {
            clLogger.logIt("test logging " + i);
        }

        clLogger.getBySubString("logging 12");
    }
}