package HW01.t03;

import junit.framework.Assert;
import org.junit.Test;

public class FuncLoopTest {
    FuncLoop fl = new FuncLoop();
    /**
     * F(x) = tg(2x - 3)
     */
    @Test
    public void testBasic() throws Exception {
        Assert.assertEquals(2,fl.foo(0,1,1).length);
        Assert.assertEquals(6, fl.foo(0, 5, 1).length);
        Assert.assertEquals(46,fl.foo(10, 100, 2).length);
        Assert.assertEquals(26, fl.foo(-100, -50, 2).length);
        Assert.assertEquals(0, fl.foo(-100, -50, 0).length);
        Assert.assertEquals(0,fl.foo(0,0,0).length);
    }

    @Test
    public void testName() throws Exception {
        fl.builTable(fl.foo(0, 100, 1));
    }


}