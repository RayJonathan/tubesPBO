package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Controller.*;

public class MenuMakanan {
<<<<<<< Updated upstream
    static private ArrayList<String> menu = new ArrayList<>();

=======
<<<<<<< HEAD
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
=======
    static private ArrayList<String> menu = new ArrayList<>();

>>>>>>> 30ef60510d7cbd1dde973e57ecc653697d906948
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    public static String showFood() {
        ArrayList<String> menu = new ArrayList<>();
        
=======
>>>>>>> Stashed changes
    public static void showFood() {
        ConnectDatabase conn = new ConnectDatabase();
>>>>>>> 30ef60510d7cbd1dde973e57ecc653697d906948
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
