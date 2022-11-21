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
    static public void payment(String idTransaction) {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String idCust = "";
        double totalBayar = 0;
        double balCust = 0;
        String query = "SELECT c.id_cust FROM transaction a"
        + "INNER JOIN receipt b ON a.id_receipt = b.id_receipt"
        + "INNER JOIN reservation c ON b.id_reservation = c.id_reservation"
        + "WHERE a.id_transaction = '" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                idCust = rs.getString("id_cust");
            }

            query = "SELECT total FROM transaction WHERE id_transaction = '" + idTransaction + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                idCust = rs.getString("total");
            }
            
            query = "SELECT balance FROM customer WHERE id_cust = '" + idCust + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                idCust = rs.getString("balance");
            }
            
            double newBal = balCust - totalBayar;
            query = "UPDATE customer SET balance ='" + newBal + "'"
                + "WHERE id_cust ='" + idCust + "'";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
    }
    public static void main(String[] args) {
        System.out.println("WOI");
        setBalance(0, "udin");
    }
}