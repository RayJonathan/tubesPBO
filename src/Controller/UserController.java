package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Models.*;
import View.ViewMenuCustomer;

import javax.swing.JOptionPane;

public class UserController {
    Customer cust;
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public UserController(){
        updateDB();
        new ViewMenuCustomer();
    }

    public void updateDB() {
        conn.connect();
        String path1 = "UPDATE customer";
        String path2 = "UPDATE admin";
        String query = " SET firstname = ?, lastname = ?, password = ? WHERE username = ?";
        System.out.println(cust.getStatus());
        if (cust.getStatus() == EnumStatusUser.CUSTOMER) {
            path1 += query;
            query = path1;
        } else {
            path2 += query;
            query = path2;
        }
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
