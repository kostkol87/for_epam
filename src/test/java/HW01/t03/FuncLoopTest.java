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
        if (fl.foo(0,1,1).length != 2){
            Assert.fail();
        }
        if(fl.foo(0, 5, 1).length != 6){
            Assert.fail();
        }
        if (fl.foo(10, 100, 2).length != 46){
            Assert.fail();
        }
        if (fl.foo(-100, -50, 2).length != 26){
            Assert.fail();
        }
        if (fl.foo(-100, -50, 0).length != 0){
            Assert.fail();
        }
        if (fl.foo(0,0,0).length != 0){
            Assert.fail();
        }
    }

    @Test
    public void testName() throws Exception {
        fl.builTable(fl.foo(0, 100, 1));
    }


}