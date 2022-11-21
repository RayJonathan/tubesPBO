package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Models.*;

/**
 *
 * @author bryanimanuell
 */

public class RegisterController {
    Customer cust;
    ConnectDatabase conn = new ConnectDatabase();

    public String hitungId(){
        String idTerbaru = "";
        ConnectDatabase conn = new ConnectDatabase();
        String query = "SELECT MAX(id_cust) FROM customer";
            conn.connect();
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String idTerbesar ="";
                if(rs.next()){
                    idTerbesar = rs.getString("MAX(id_cust)");
                }
                String angkaStrTerbesar= idTerbesar.substring(1);
                int angkaTerbesar = Integer.parseInt(angkaStrTerbesar);
                int angkaTerbaru = angkaTerbesar + 1;
                String angkaStrTerbaru = Integer.toString(angkaTerbaru);
                if(angkaTerbaru<10){
                    idTerbaru = "C00"+angkaStrTerbaru;
                }else if(angkaTerbaru<100){
                    idTerbaru = "C0"+angkaStrTerbaru;
                }else{
                    idTerbaru = "C"+angkaStrTerbaru;
                }
            } catch (SQLException except) {
                except.printStackTrace();
            }
            conn.disconnect();
        return idTerbaru;
    }

    public void insertDB() {
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO customer(id_cust, username, firstname, lastname, email, status_user, isMember, balance, password) VALUES(?,?,?,?,?,?,?,?,?)");
            stat.setString(1, cust.getIdCust());
            stat.setString(2, cust.getUsername());
            stat.setString(3, "");
            stat.setString(4, "");
            stat.setString(6, "");
            stat.setInt(7, 0);
            stat.setDouble(8, 10000);

            stat.setString(5, cust.getEmail());
            stat.setString(9, cust.getPassword());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
    }

    public void insertData(String username, String email, String password) {
        cust = new Customer();
        String template = hitungId();
        cust.setIdCust(template);
        cust.setUsername(username);
        cust.setPassword(password);
        cust.setEmail(email);
        insertDB();
    }

    public boolean searchUser() {
        boolean available = false;

        return available;
    }
}
