package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.ConnectDatabase;

public class MenuMakanan {
    public static void main(String[] args) {
        String menu1 = showFood();
        JLabel label1 = new JLabel();
        System.out.println(showFood());
    }

    public static String showFood() {
        ArrayList<String> menu = new ArrayList<>();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        JLabel tempLabel = new JLabel();
        JFrame frame = new JFrame("Frame");

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                menu.add(rs.getString("name_menu"));
            }
            JOptionPane.showMessageDialog(null, "Berhasil menemukan data dari database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
        conn.disconnect();
        tempLabel.setBounds(10, 20, 80, 30);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        return output;
    }
}
