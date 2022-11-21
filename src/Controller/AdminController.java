package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Menu;

public class AdminController {
    static public String addMenu(Menu menu) {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO users(userName, userEmail, password) VALUES(?,?,?,?)");
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
}
