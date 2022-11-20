package Model.Users;

import Model.InterfaceEnum.EnumStatusUser;

public class Boss extends User {
    private int idBoss;

    public Boss(String username, String firstName, String lastName, String password, String email, String noTelp,
            EnumStatusUser status, int idBoss) {
        super(username, firstName, lastName, password, email, noTelp, status);
        this.idBoss = idBoss;
    }

    public int getIdBoss() {
        return idBoss;
    }
    public void setIdBoss(int idBoss) {
        this.idBoss = idBoss;
    }

    public void viewPendapatanTotal() {}

    public void addCabang() {}

    @Override
    public void updateAccount() {
        // TODO Auto-generated method stub
        
    }
}
