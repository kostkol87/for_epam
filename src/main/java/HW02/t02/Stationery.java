package HW02.t02;

public class Stationery {
    private String name;
    private double price;
    private int count;

    public Stationery(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }
}
