package HW02.t03;

import org.junit.Test;

import java.util.List;

public class StationeryTest {
    @Test
    public void testStationery() throws Exception {
        NoviceSet ns = new NoviceSet();
        List<Stationery> noviceSet = ns.getNoviceSet();
        ns.printNoviceSet(noviceSet);
    }
}