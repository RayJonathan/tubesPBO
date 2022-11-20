package Model.Users;

import java.util.ArrayList;

import Model.Reservation;
import Model.InterfaceEnum.EnumMember;
import Model.InterfaceEnum.EnumStatusUser;
import Model.InterfaceEnum.InterfaceData;

public class Customer extends User implements InterfaceData{
    private int idCustomer;
    private double saldoWallet;
    private EnumMember statusMember;
    private ArrayList<Reservation> listTransaksi;

    public Customer(String username, String firstName, String lastName, String password, String email, String noTelp,
            EnumStatusUser status, int idCustomer, double saldoWallet, EnumMember statusMember,
            ArrayList<Reservation> listTransaksi) {
        super(username, firstName, lastName, password, email, noTelp, status);
        this.idCustomer = idCustomer;
        this.saldoWallet = saldoWallet;
        this.statusMember = statusMember;
        this.listTransaksi = listTransaksi;
    }

    public int getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    public double getSaldoWallet() {
        return saldoWallet;
    }
    public void setSaldoWallet(double saldoWallet) {
        this.saldoWallet = saldoWallet;
    }
    public EnumMember getStatusMember() {
        return statusMember;
    }
    public void setStatusMember(EnumMember statusMember) {
        this.statusMember = statusMember;
    }
    public ArrayList<Reservation> getListTransaksi() {
        return listTransaksi;
    }
    public void setListTransaksi(ArrayList<Reservation> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    public void roomReservation() {}
    
    public void joinMember() {}
    
    public void isiSaldo() {}

    @Override
    public void dataCustomer() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateAccount() {
        // TODO Auto-generated method stub
        
    }
}