package HW05.t02;

import junit.framework.Assert;
import org.junit.Test;

public class PropReaderTest {
    static final String FILE_NAME = System.getProperty("user.dir") + "\\src\\main\\java\\HW05\\t02\\test.properties";

    @Test
    public void testGetByKey() throws Exception {

        PropReader pr = new PropReader();

        Assert.assertEquals("world", pr.getByKey("hello", FILE_NAME, ":"));

        Assert.assertEquals("python", pr.getByKey("goodbye", FILE_NAME, ":"));

        Assert.assertTrue(pr.getByKey("noExists", FILE_NAME, ":") == null);

        Assert.assertFalse(pr.getByKey("goodbye", FILE_NAME, ":") == null);

        Assert.assertFalse(pr.getByKey("goodbye", FILE_NAME, ":").equals("world"));


    }
}