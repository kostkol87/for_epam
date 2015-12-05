package HW02.t03;

import org.junit.Test;

import java.util.HashSet;

public class StationeryTest {
    @Test
    public void testStationery() throws Exception {
        HashSet<Stationery> noviceSet = new NoviceSet().getNoviceSet();
        for (Stationery s : noviceSet){
            System.out.println(s);
        }
    }
}