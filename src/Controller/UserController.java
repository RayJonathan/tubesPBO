package Controller;

import java.sql.Statement;
import java.sql.SQLException;
import Models.*;

import javax.swing.JOptionPane;

public class UserController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    static public void updateDB(EnumStatusUser status) {
        SingletonAdmin sa = SingletonAdmin.getInstance();
        SingletonCustomer sc = SingletonCustomer.getInstance();
        //update yg di sql skrng
        conn.connect();
        String path1 = "UPDATE customer";
        String path2 = "UPDATE admin";
        String firstname ="",lastname="", password = "", username = "";
        String query = "";
        if (status == EnumStatusUser.CUSTOMER) {
            Customer cust = sc.getCurrentCustomer();
            firstname = cust.getFirstname();
            lastname = cust.getLastname();
            password = cust.getPassword();
            username = cust.getUsername();
            query = path1+" SET firstname = '"+firstname+"', lastname = '"+lastname+"', password = '"+password+"' WHERE username = '"+username+"'";
        } else {
            Admin admin = sa.getCurrentAdmin();
            firstname = admin.getFirstname();
            lastname = admin.getLastname();
            password = admin.getPassword();
            username = admin.getUsername();
            query = path2+" SET firstname = '"+firstname+"', lastname = '"+lastname+"', password = '"+password+"' WHERE username = '"+username+"'";
        }

        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil update barang ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal update barang ke database");
        }
        conn.disconnect();
    }

}
