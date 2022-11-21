package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Models.Discount;

public class CustomerController {
    public static String joinMember(String user) {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "UPDATE customer SET isMember ='" + 1 + "'" + "WHERE id_cust ='" + user + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
    public static int gachaDiscount(){
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        ArrayList<Discount> discount = new ArrayList<>();
        String query = "SELECT * FROM discount";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                discount.add(new Discount(rs.getString("id_discount"), rs.getInt("discount_amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        Random ran = new Random();
        return discount.get(ran.nextInt(discount.size())).getDiscountAmount();
    }
    public static String reserveTable(String reserve, String table, String user){
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "INSERT INTO reservation VALUES ('" + reserve + "'" + table + "'" + user + "')";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
    public static String orderMenu(String details, String receipt, String menu, int quantity, String status, double subtotal){
        status = "inProgress";
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "INSERT INTO receiptDetails VALUES ('" + details + "'" + receipt + "'" + menu + "'" + quantity + "'" + status + "'" + subtotal + "')";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
    public static String checkTransaction(){
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "SELECT * FROM transaction";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
}