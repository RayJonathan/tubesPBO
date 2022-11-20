package Model.Users;

import Model.CabangHotel;
import Model.InterfaceEnum.EnumStatusUser;
import Model.InterfaceEnum.InterfaceData;

public class Staff extends User implements InterfaceData {
    private int idStaff;
    private double gaji;
    private CabangHotel cabang;

    public Staff(String username, String firstName, String lastName, String password, String email, String noTelp,
            EnumStatusUser status, int idStaff, double gaji, CabangHotel cabang) {
        super(username, firstName, lastName, password, email, noTelp, status);
        this.idStaff = idStaff;
        this.gaji = gaji;
        this.cabang = cabang;
    }

    public int getIdStaff() {
        return idStaff;
    }
    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }
    public double getGaji() {
        return gaji;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    public CabangHotel getCabang() {
        return cabang;
    }
    public void setCabang(CabangHotel cabang) {
        this.cabang = cabang;
    }

    public void manageVoucher() {}

    public void manageExtra() {}

    public void dataCustomer() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateAccount() {
        // TODO Auto-generated method stub
        
    }
}
