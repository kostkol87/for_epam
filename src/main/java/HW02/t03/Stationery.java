package HW02.t03;

public class Stationery {
    String name;
    double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name + " " + price;
    }
}
