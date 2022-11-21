package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Menu;

public class AdminController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    public static int totalIncome() {
        conn.connect();
        String query = "SELECT total FROM transaction";
        int totalPenghasilan = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                totalPenghasilan += rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return totalPenghasilan;
    }
    public static String totalSale() {
        conn.connect();
        String query = "SELECT a.name_menu, sum(b.quantity)"
        + "FROM menu a"
        + "INNER JOIN receiptdetails b ON a.id_menu = b.id_menu"
        + "ORDER BY a.id_menu";

        String totalSale = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                totalSale += rs.getString(0) + ": " + rs.getInt(1) + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return totalSale;
    }
    public static String deleteUser(String idQueue) {
        conn.connect();
        String output = "";
        String query = "DELETE FROM queue WHERE id_queue ='" + idQueue + "'";
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
    public static String addMenu(Menu menu) {
        conn.connect();
        String output = "";
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO menu(id_menu, name_menu, category, price) VALUES(?,?,?,?)");
            stat.setString(1, menu.getIdMenu());
            stat.setString(2, menu.getName_menu());
            stat.setString(3, menu.getCategory());
            stat.setDouble(4, menu.getPrice());
            stat.executeUpdate();
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
    public static String updateStatusFood(String status, String idRecieptDetails) {
        conn.connect();
        String output = "";
        String query = "UPDATE recieptDetails SET status_food_progress ='" + status + "'"
        + "WHERE id_receiptDetails ='" + idRecieptDetails + "'";
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