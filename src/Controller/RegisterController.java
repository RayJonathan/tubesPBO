package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.*;

/**
 * @author bryanimanuell
 */

public class RegisterController {
    Customer cust;

    public void insertDB() {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO users(userName, userEmail, password) VALUES(?,?,?)");
            stat.setString(1, cust.getUsername());
            stat.setString(2, cust.getEmail());
            stat.setString(3, cust.getPassword());
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
