package Model.Users;

import Model.InterfaceEnum.EnumStatusUser;

public abstract class User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String noTelp;
    private EnumStatusUser status;

    public User(String username, String firstName, String lastName, String password, String email, String noTelp,
            EnumStatusUser status) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.noTelp = noTelp;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public EnumStatusUser getStatus() {
        return status;
    }
    public void setStatus(EnumStatusUser status) {
        this.status = status;
    }

    public abstract void updateAccount();
}
