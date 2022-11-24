package Models;

public class Transaction {
    String idTransaction;
    String idReciept;
    String idDiscount;
    double total;

    public Transaction(String idTransaction, String idReciept, String idDiscount, double total) {
        this.idTransaction = idTransaction;
        this.idReciept = idReciept;
        this.idDiscount = idDiscount;
        this.total = total;
    }

    public String getIdTransaction() {
        return idTransaction;
    }
    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }
    public String getIdReciept() {
        return idReciept;
    }
    public void setIdReciept(String idReciept) {
        this.idReciept = idReciept;
    }
    public String getIdDiscount() {
        return idDiscount;
    }
    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
