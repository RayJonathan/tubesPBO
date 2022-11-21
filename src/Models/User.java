package Models;

public class User {
    String username;
    String password;
    String firstname;
    String lastname;
    String email;
    EnumStatusUser status;

    public User(String username, String password, String firstname, String lastname, String email,
            EnumStatusUser status) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.status = status;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public EnumStatusUser getStatus() {
        return status;
    }

    public void setStatus(EnumStatusUser status) {
        this.status = status;
    }

    

}
