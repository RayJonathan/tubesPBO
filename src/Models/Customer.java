package Models;

public class Customer {
    String idCust;
    String username;
    String password;
    String firstname;
    String lastname;
    String email;
    Boolean isMember;
    double balance;

    public Customer() {

    }

    public Customer(String idCust, String password, String username, String firstname, String lastname, String email,
            Boolean isMember, double balance) {
        this.idCust = idCust;
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.isMember = isMember;
        this.balance = balance;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Customer [idCust=" + idCust + ", password=" + password + ", username=" + username + ", firstname="
                + firstname + ", lastname=" + lastname + ", email=" + email + ", isMember=" + isMember + ", balance="
                + balance + "]";
    }

}