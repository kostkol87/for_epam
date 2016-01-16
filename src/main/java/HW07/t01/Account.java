package HW07.t01;

public class Account {
    private Account(){}

    private int id;
    private double amount;

    public Account(int id, double amount){
        this.id = id;
        this.amount = amount;
        Operator.init(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
