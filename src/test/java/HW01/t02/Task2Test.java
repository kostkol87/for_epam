package HW01.t02;

import junit.framework.Assert;

public class Task2Test {
    @org.junit.Test
    public void testName() throws Exception {
        Task2 fm = new Task2();
        if(fm.findMin() != 1.002003004005006E-6){
            Assert.fail();
        }
    }
}