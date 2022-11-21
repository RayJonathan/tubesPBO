package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.*;
import javax.swing.JOptionPane;

public class UserController {

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public void updateDB(String username) {
        conn.connect();
        String path1 = "UPDATE customer";
        String path2 = "UPDATE admin";
        String query = " SET firstname = ?, lastname = ?, password = ? WHERE username = ?";
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM customer Where=" + username + ")");
            if (result.getString("status_user").equalsIgnoreCase("Customer")) {
                path1 += query;
                query = path1;
            } else {
                path2 += query;
                query = path2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();

        try {
            PreparedStatement stat = conn.con.prepareStatement(query);

            JOptionPane.showMessageDialog(null, "Berhasil update barang ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal update barang ke database");
        }
        conn.disconnect();
    }

}
