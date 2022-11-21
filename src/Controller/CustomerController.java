package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Transaction;

public class CustomerController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static String joinMember(String idCust) {
        conn.connect();
        String output = "";
        String query = "UPDATE customer SET isMember ='" + 1 + "'"
                + "WHERE id_cust ='" + idCust + "'";
        ;
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

    public static String reserveMeja(String idTable, String idUser) {
        conn.connect();
        try {
            String template = hitungId();
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO reservation VALUES(?,?,?)");
            stat.setString(1, template);
            stat.setString(2, idTable);
            stat.setString(3, idUser);
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return "";
    }

    public static String hitungId() {
        String idTerbaru = "";
        String query = "SELECT MAX(id_reservation) FROM reservation";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String idTerbesar = "";
            if (rs.next()) {
                idTerbesar = rs.getString("MAX(id_reservation)");
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

    public static String reserveTable(String reserve, String table, String user) {
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

    public static String orderMenu(String details, String receipt, String menu, int quantity, String status,
            double subtotal) {
        status = "inProgress";
        conn.connect();
        String output = "";
        String query = "INSERT INTO receiptDetails VALUES ('" + details + "'" + receipt + "'" + menu + "'" + quantity
                + "'" + status + "'" + subtotal + "')";
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

    public static ArrayList<Transaction> checkTransaction(String idCust) {
        conn.connect();
        String query = "SELECT a.* FROM transaction a"
                + "INNER JOIN receipt b ON a.id_receipt = b.id_receipt"
                + "INNER JOIN reservation c ON b.id_reservation = c.id_reservation"
                + "WHERE c.id_cust = '" + idCust + "'";
        ArrayList<Transaction> transaksi = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                transaksi.add(new Transaction(rs.getString("id_transaction"), rs.getInt("total")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return transaksi;
    }
}