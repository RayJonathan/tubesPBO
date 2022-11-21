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
        showFood();
        JFrame frame = new JFrame();

        JPanel board = new JPanel();

        board.setLayout(null);
        board.setBounds(0, 0, 500, 500);

        for (int i = 0, x = 0; i < menu.size(); i++, x += 50) {
            for (int j = 0, y = 0; j < menu.size(); j++, y += 50) {
                JLabel lab = new JLabel(" " + menu.get(j));
                lab.setOpaque(true);
                lab.setBounds(x, y, 50, 50);
                board.add(lab);
            }
        }

        frame.setSize(400, 400);
        JLabel ladder = new JLabel();
        ladder.setBounds(0, 0, 50, 200);
        ladder.setOpaque(true);

        JLayeredPane pane = frame.getLayeredPane();

        pane.add(ladder, new Integer(2)); // front
        pane.add(board, new Integer(1)); // back

        frame.setVisible(true);
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
