package HW02.t03;

import java.util.HashSet;

public class NoviceSet {
    public HashSet<Stationery> getNoviceSet(){
        HashSet<Stationery> noviceSet = new HashSet<Stationery>();
        noviceSet.add(new Pen("Parker", 59.9));
        noviceSet.add(new Pen("Parker", 59.9));
        noviceSet.add(new Pencil("", 20));
        noviceSet.add(new Pencil("", 20));
        noviceSet.add(new Pencil("", 20));
        noviceSet.add(new Pencil("", 20));
        noviceSet.add(new Rubber("", 5));
        noviceSet.add(new Rubber("", 5));
        noviceSet.add(new Corrector("", 100));
        noviceSet.add(new Marker("",15));
        noviceSet.add(new Paper("", 300));
        noviceSet.add(new Sticker("", 35));
        noviceSet.add(new Stapler("", 231.5));
        noviceSet.add(new Clip("", 10));
        return noviceSet;
    }
}
