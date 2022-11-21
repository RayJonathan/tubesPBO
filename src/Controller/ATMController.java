package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Customer;

public class ATMController {

    static public String setBalance(double value, String username) {
        Customer cust = new Customer();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        double balanceTemp = 0;
        username = "udin";
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT balance FROM customer WHERE username='" + username + "'");
            if (result.next()) {
                System.out.println(result);
                System.out.println("oke");
            }
        } catch (SQLException e) {
            System.out.println(e);
            output = "Gagal memasukan data";
            System.out.println(output);
        }
        conn.disconnect();

        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO customer(balance) VALUES()");
            stat.setString(1, cust.getUsername());
            stat.setString(2, cust.getEmail());
            stat.setString(3, cust.getPassword());
            stat.executeUpdate();
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            System.out.println(e);
            output = "Gagal memasukan data";
        }
        conn.disconnect();

        return output;
    }

    public static void main(String[] args) {
        System.out.println(setBalance(0, "udin"));
    }
}