package Controller;

import java.sql.SQLException;
import java.sql.Statement;

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
    public static int gachaDiscount(Discount[] discount){
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "SELECT * FROM discount";

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
    public static String orderMenu(){
        
    }
    public static String checkTransaction(){

    }
}