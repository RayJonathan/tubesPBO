package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ReservationController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static String reserveMeja(String idTable, String idUser) {
        conn.connect();
        // liatin table queue apakah ada yang mau kapasitas tertentu, jika iya maka
        // duduki di x
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

    public static String hitungIdReservation() {
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
    public static void insertDB(String idReservation, String idTable, String idCust) {
        conn.connect();
        try {
            PreparedStatement pstat = conn.con.prepareStatement(
                    "INSERT INTO `reservation`(`id_reservation`, `id_table`, `id_cust`) VALUES (?,?,?)");

            pstat.setString(1, idReservation);
            pstat.setString(2, idTable);
            pstat.setString(3, idCust);
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