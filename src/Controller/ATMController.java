package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ATMController {

    static public double showBalance(String username) {
        double balance = 0;
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM customer WHERE username='" + username + "'");
            if (result.next()) {
                balance = result.getDouble("balance");
            }
            JOptionPane.showMessageDialog(null, "Balance anda : " + balance);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return balance;
    }

    static public void setBalance(double value, String username) {
        value += showBalance(username);
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "UPDATE customer SET balance= ?  WHERE username = ? ");
            stat.setDouble(1, value);
            stat.setString(2, username);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "TOPUP SUCCESS", username, 0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");

        }
        conn.disconnect();
    }

}