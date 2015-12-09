package HW02.t03;

import java.util.ArrayList;
import java.util.List;

public class NoviceSet {
    public List<Stationery> getNoviceSet() {
        ArrayList<Stationery> noviceSet = new ArrayList<Stationery>();
        noviceSet.add(new Pen("Parker", 100.0));
        noviceSet.add(new Pen("Parker", 59.9));
        noviceSet.add(new Pencil("H", 20));
        noviceSet.add(new Pencil("HB", 20));
        noviceSet.add(new Pencil("3B*", 20));
        noviceSet.add(new Pencil("7B*", 20));
        noviceSet.add(new Rubber("LYRA", 5));
        noviceSet.add(new Rubber("LYRA", 5));
        noviceSet.add(new Corrector("BiC", 100));
        noviceSet.add(new Marker("MOLOTOW", 15));
        noviceSet.add(new Paper("Bereg", 300));
        noviceSet.add(new Sticker("DeliMemoPaper", 35));
        noviceSet.add(new Stapler("Swingline", 231.5));
        noviceSet.add(new Clip("SteelClip", 10));
        return noviceSet;
    }

    public void printNoviceSet(List<Stationery> noviceSet) {
        for (Stationery element : noviceSet) {
            System.out.println(element);
        }
    }
}
