package Models;

public class Customer extends User{
    String idCust;
    Boolean isMember;
    double balance;

    public Customer() {

    }

    public Customer(String username, String password, String firstname, String lastname, String email,
            EnumStatusUser status, String idCust, Boolean isMember, double balance) {
        super(username, password, firstname, lastname, email, EnumStatusUser.CUSTOMER);
        this.idCust = idCust;
        this.isMember = isMember;
        this.balance = balance;
    }

    public Customer(String idCust, Boolean isMember, double balance) {
        this.idCust = idCust;
        this.isMember = isMember;
        this.balance = balance;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}