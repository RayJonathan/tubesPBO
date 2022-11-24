package Models;
public class Admin extends User{
    String idAdmin;

    public Admin(String username, String password, String firstname, String lastname, String email,
            EnumStatusUser status, String idAdmin) {
        super(username, password, firstname, lastname, email, EnumStatusUser.ADMIN);
        this.idAdmin = idAdmin;
    }

    public Admin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(){

    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

}