public class Admin {
    String idAdmin;
    String password;
    String username;
    String firstname;
    String lastname;
    String email;
    String statusUser;

    public Admin(String idAdmin, String password, String username, String firstname, String lastname, String email,
            String statusUser) {
        this.idAdmin = idAdmin;
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.statusUser = statusUser;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
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

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    @Override
    public String toString() {
        return "Admin [idAdmin=" + idAdmin + ", password=" + password + ", username=" + username + ", firstname="
                + firstname + ", lastname=" + lastname + ", email=" + email + ", statusUser=" + statusUser + "]";
    }

}
//halo