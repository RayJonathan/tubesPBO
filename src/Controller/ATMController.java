package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Customer;

public class ATMController {

    static public String setBalance(double value) {
        Customer cust = new Customer();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO users(userName, userEmail, password) VALUES(?,?,?)");
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
}