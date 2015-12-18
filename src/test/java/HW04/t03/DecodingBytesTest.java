package HW04.t03;

import org.junit.Test;

public class DecodingBytesTest {
    private String path = System.getProperty("user.dir") + "/src/main/resources/" + "utf8file.test";
    @Test
    public void testReadFileU8() throws Exception {
        DecodingBytes db = new DecodingBytes();
        db.readFileU8(path);
    }

    @Test
    public void testRewriteFileU16() throws Exception {
        DecodingBytes db = new DecodingBytes();
        String pathOut = System.getProperty("user.dir") + "/src/main/resources/" + "utf16file.test";
        db.rewriteFileU15(pathOut, db.readFileU8(path));

    }
}