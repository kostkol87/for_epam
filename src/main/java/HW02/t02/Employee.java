package HW02.t02;

public class Employee {
    private String name;
    private String sName;
    private Stationery[] stationery;

    public Employee(String name, String sName, Stationery ... stationery) {
        this.name = name;
        this.sName = sName;
        this.stationery = stationery;
    }

    public String getName() {
        return name;
    }

    public String getsName() {
        return sName;
    }

    public double inventory(){
        double summ = 0;
        for (Stationery curr : stationery){
            summ += curr.getPrice()*curr.getCount();
        }
        return summ;
    }
}
