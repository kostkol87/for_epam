package HW07.t01;

public class Operator {
    public static void init(Account account){
        if (account != null) {
            synchronized (Operator.class) {
                HistoryUtil.addLine(account.getId() + "|" + account.getAmount() + "|new");
            }
        }
    }

    public void getTransactions(Account account){
        
        while (true){
            HistoryUtil.readLine().split("|");
        }
    }
    public void newTransaction(Account sender, Account reciever, double summa){

    }
}
