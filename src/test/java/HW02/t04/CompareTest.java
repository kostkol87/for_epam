package HW02.t04;

import HW02.t03.NoviceSet;
import HW02.t03.Stationery;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompareTest {
    @Test
    public void testCompare() throws Exception {
        NoviceSet noviceSetObj = new NoviceSet();
        List<Stationery> noviceSet = noviceSetObj.getNoviceSet();

        System.out.println("Unsorted:");
        noviceSetObj.printNoviceSet(noviceSet);
        System.out.println("==================");
        noviceSet.sort(new PriceComparator());

        System.out.println("Sorted by price");
        noviceSetObj.printNoviceSet(noviceSet);
        System.out.println("==================");

        noviceSet.sort(new NameComparator());

        System.out.println("Sorted by label");
        noviceSetObj.printNoviceSet(noviceSet);
        System.out.println("==================");

        noviceSet.sort(new NameAndPriceComparator());

        System.out.println("Sorted by name and price");
        noviceSetObj.printNoviceSet(noviceSet);
        System.out.println("==================");

    }
}
