package HW03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Acer s3 on 11.12.2015.
 */
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