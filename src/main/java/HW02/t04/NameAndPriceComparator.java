package HW02.t04;

import HW02.t03.Stationery;

import java.util.Comparator;

public class NameAndPriceComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        Stationery st1 = (Stationery) o1;
        Stationery st2 = (Stationery) o2;

        Double d1 = st1.getPrice();
        Double d2 = st2.getPrice();

        String str1 = st1.getLabel();
        String str2 = st2.getLabel();

        return Integer.compare(Double.compare(d1, d2), -str1.compareTo(str2));
    }
}
