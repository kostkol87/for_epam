package HW02.t04;

import HW02.t03.Stationery;

import java.util.Comparator;

public class NameComparator implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {

        String str1 = ((Stationery) o1).getLabel();
        String str2 = ((Stationery) o2).getLabel();

        return str1.compareTo(str2);
    }
}
