package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.Customer;

public class ATMController {

    static public void setBalance(double value, String username) {
        Customer cust;

        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "UPDATE customer SET balance= ?  WHERE username ='" + username + "'");
            stat.setDouble(1, value);
            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
    }

    public static void main(String[] args) {
        System.out.println("WOI");
        setBalance(0, "udin");
    }
}