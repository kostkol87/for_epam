package HW02.t04;

import HW02.t03.Stationery;
import java.util.Comparator;

public class PriceComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {

        Double d1 = ((Stationery) o1).getPrice();
        Double d2 = ((Stationery) o2).getPrice();

        return Double.compare(d1, d2);
    }
}
