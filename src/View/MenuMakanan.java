package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Controller.*;

public class MenuMakanan {
    static private ArrayList<String> menu = new ArrayList<>();

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    public static void main(String[] args) {
        JFrame f = new JFrame();
        for (int i = 0; i < menu.size(); i++) {

        }
        JLabel menu1 = new JLabel();
        JButton b = new JButton("click");
        b.setBounds(130, 100, 100, 40);
        f.add(b);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static String showFood() {
        ArrayList<String> menu = new ArrayList<>();
        conn.connect();

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                menu.add(rs.getString("name_menu"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
        System.out.println(menu.size());
        conn.disconnect();

    }
}
