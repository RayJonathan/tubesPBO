package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    static public double checkBalance(String idCustomer) {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String query = "SELECT balance FROM customer WHERE id_cust = '" + idCustomer + "'";
        double bal = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                bal = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return bal;
    }
    public static void main(String[] args) {
        System.out.println("WOI");
        setBalance(0, "udin");
    }
}