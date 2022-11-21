public class Transaction {
    String idTransaction;
    double total;

    public Transaction(String idTransaction, double total) {
        this.idTransaction = idTransaction;
        this.total = total;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
