package HW02.t03;

import org.junit.Test;

import java.util.ArrayList;

public class StationeryTest {
    @Test
    public void testStationery() throws Exception {
        NoviceSet ns = new NoviceSet();
        ArrayList<Stationery> noviceSet = ns.getNoviceSet();
        ns.printNoviceSet(noviceSet);
    }
}