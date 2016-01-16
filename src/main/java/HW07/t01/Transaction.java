package HW07.t01;

public class Transaction {
    private Transaction() {
    }

    private Account sender;
    private Account reciever;
    private double summa;

    private Transaction(Account sender, Account reciever, double summa) {
        if (summa != 0) {
            if (sender != null && reciever != null) synchronized (Transaction.class) {
                this.sender = sender;
                this.reciever = reciever;
                this.summa = summa;
                HistoryUtil.addLine(sender.getId() + "|" + sender.getAmount() + "|" + reciever.getId() + "|" + reciever.getAmount() + "|" + summa + "trans");

                //not atomic !!!
                sender.setAmount(sender.getAmount() - summa);
                reciever.setAmount(reciever.getAmount() + summa);
            }
        }
    }

}
