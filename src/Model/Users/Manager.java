package Model.Users;

import Model.CabangHotel;
import Model.InterfaceEnum.EnumStatusUser;

public class Manager extends User {
    private int idManager;
    private CabangHotel cabang;

    public Manager(String username, String firstName, String lastName, String password, String email, String noTelp,
            EnumStatusUser status, int idManager, CabangHotel cabang) {
        super(username, firstName, lastName, password, email, noTelp, status);
        this.idManager = idManager;
        this.cabang = cabang;
    }

    public int getIdManager() {
        return idManager;
    }
    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }
    public CabangHotel getCabang() {
        return cabang;
    }
    public void setCabang(CabangHotel cabang) {
        this.cabang = cabang;
    }

    public void addStaff() {}

    public void deleteStaff() {}

    public void manageGaji() {}

    public void viewDataStaff() {}

    public void viewPendapatanCabang() {}

    public void updateRoomHotel() {}

    @Override
    public void updateAccount() {
        // TODO Auto-generated method stub
        
    }
}
