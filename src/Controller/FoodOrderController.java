package Controller;

import java.sql.ResultSet;

import Models.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class FoodOrderController {

    Customer cust;
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static String hitungIdDetail() {
        String idTerbaru = "";
        String query = "SELECT COUNT(id_receiptDetails) as 'Count' FROM receiptdetails";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int idTerbesar = 0;
            if (rs.next()) {
                idTerbesar = rs.getInt("Count");
            }
            int angkaTerbaru = idTerbesar + 1;
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
        return idTerbaru;
    }

    public void insertDB() {
        conn.connect();
        try {
            PreparedStatement pstat = conn.con.prepareStatement(
                    "INSERT INTO receipt(id_receipt, id_reservation, date) VALUES (?,?,?)");

            pstat.setString(1, hitungIdDetail());
            pstat.setString(2, ReservationController.hitungReservationId());
            pstat.setDate(3, new Date(System.currentTimeMillis()));
            pstat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }

        conn.disconnect();
    }

    public static void insertDB(String idMenu, int qty, double price, String idReceipt) {
        conn.connect();
        try {
            PreparedStatement pstat = conn.con.prepareStatement(
                    "INSERT INTO receiptdetails(id_receiptDetails, id_receipt, id_menu, quantity, status_food_progress, subtotal) VALUES (?,?,?,?,?,?)");

            pstat.setString(1, hitungIdDetail());
            pstat.setString(2, idReceipt);
            pstat.setString(3, idMenu);
            pstat.setInt(4, qty);
            pstat.setString(5, EnumStatusFood.INPROGRESS.toString());
            double subtotal = price * qty;
            pstat.setDouble(6, subtotal);
            pstat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }

        conn.disconnect();
    }

}
//