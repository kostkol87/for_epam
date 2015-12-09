package HW02.t03;

public class Stationery{
    String label;
    double price;

    public Stationery(String name, double price) {
        this.label = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "<" +this.getClass().getSimpleName() + ">" + " " + label + " " + price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }
}