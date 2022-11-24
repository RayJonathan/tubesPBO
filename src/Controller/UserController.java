package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Models.*;

import javax.swing.JOptionPane;

public class UserController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    SingletonAdmin sa = SingletonAdmin.getInstance();
    SingletonCustomer sc = SingletonCustomer.getInstance();

    public void updateDB(EnumStatusUser status) {
        //update yg di sql skrng
        conn.connect();
        String path1 = "UPDATE customer";
        String path2 = "UPDATE admin";
        String firstname ="",lastname="", password = "", username = "";
        String query = " SET firstname = "+firstname+", lastname = "+lastname+", password = "+password+" WHERE username = "+username;
        if (status == EnumStatusUser.CUSTOMER) {
            Customer cust = sc.getCurrentCustomer();
            firstname = cust.getFirstname();
            lastname = cust.getLastname();
            password = cust.getPassword();
            username = cust.getUsername();

            query = path1 + query;
        } else {
            Admin admin = sa.getCurrentAdmin();
            firstname = admin.getFirstname();
            lastname = admin.getLastname();
            password = admin.getPassword();
            username = admin.getUsername();

            query = path2 + query;
        }
        conn.disconnect();

        try {
            PreparedStatement stat = conn.con.prepareStatement(query);
            stat.executeQuery();
            JOptionPane.showMessageDialog(null, "Berhasil update barang ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal update barang ke database");
        }
        conn.disconnect();
    }

}
