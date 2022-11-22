package Controller;

import java.sql.ResultSet;

import Models.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.JOptionPane;

public class FoodOrderController {

    Customer cust;
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static String hitungId() {
        String idTerbaru = "";
        String query = "SELECT MAX(id_receipt) FROM receiptdetails";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String idTerbesar = "";
            if (rs.next()) {
                idTerbesar = rs.getString("MAX(id_receipt)");
            }
            String angkaStrTerbesar = idTerbesar.substring(1);
            int angkaTerbesar = Integer.parseInt(angkaStrTerbesar);
            int angkaTerbaru = angkaTerbesar + 1;
            String angkaStrTerbaru = Integer.toString(angkaTerbaru);
            if (angkaTerbaru < 10) {
                idTerbaru = "R00" + angkaStrTerbaru;
            } else if (angkaTerbaru < 100) {
                idTerbaru = "R0" + angkaStrTerbaru;
            } else {
                idTerbaru = "R" + angkaStrTerbaru;
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }
        conn.disconnect();
        return idTerbaru;
    }

    public static String hitungIdDetail() {
        String idTerbaru = "";
        String query = "SELECT MAX(id_receiptDetails) FROM receiptdetails";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String idTerbesar = "";
            if (rs.next()) {
                idTerbesar = rs.getString("MAX(id_receiptDetails)");
            }
            String angkaStrTerbesar = idTerbesar.substring(1);
            int angkaTerbesar = Integer.parseInt(angkaStrTerbesar);
            int angkaTerbaru = angkaTerbesar + 1;
            String angkaStrTerbaru = Integer.toString(angkaTerbaru);
            if (angkaTerbaru < 10) {
                idTerbaru = "RD00" + angkaStrTerbaru;
            } else if (angkaTerbaru < 100) {
                idTerbaru = "RD0" + angkaStrTerbaru;
            } else {
                idTerbaru = "RD" + angkaStrTerbaru;
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }
        conn.disconnect();
        return idTerbaru;
    }

    public static void insertDB(String pesanan, Double double1) {
        conn.connect();
        String idPesananString = hitungId();
        try {
            PreparedStatement pstat = conn.con.prepareStatement(
                    "INSERT INTO `receiptdetails`(`id_receiptDetails`, `id_receipt`, `id_menu`, `quantity`, `status_food_progress`, `subtotal`) VALUES (?,?,?,?,?,?)");
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM menu WHERE name_menu='" + pesanan + "'");
            if (result.next()) {
                pstat.setString(1, "101");
                pstat.setString(2, idPesananString);
                pstat.setString(3, "201");
                pstat.setDouble(4, double1);
                pstat.setString(5, "Pending");
                double subtotal = result.getDouble("price") * double1;
                pstat.setDouble(6, subtotal);
                pstat.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }

        conn.disconnect();
    }

}
