package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.*;

/**
 *
 * @author bryanimanuell
 */

public class RegisterController {
    Customer cust;
    static String template = "C011";

    public void insertDB() {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO customer(id_cust, username, firstname, lastname, email, status_user, isMember, balance, password) VALUES(?,?,?,?,?,?,?,?,?)");
            stat.setString(1, cust.getIdCust());
            stat.setString(2, cust.getUsername());
            stat.setString(3, "");
            stat.setString(4, "");
            stat.setString(6, "");
            stat.setInt(7, 0);
            stat.setDouble(8, 10000);

            stat.setString(5, cust.getEmail());
            stat.setString(9, cust.getPassword());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
    }

    public void insertData(String username, String email, String password) {
        cust = new Customer();
        cust.setIdCust(template);
        cust.setUsername(username);
        cust.setPassword(password);
        cust.setEmail(email);
        insertDB();
    }

    public boolean searchUser() {
        boolean available = false;

        return available;
    }
}
