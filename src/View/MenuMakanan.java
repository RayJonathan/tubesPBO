package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Controller.*;

public class MenuMakanan {
    <<<<<<<HEAD
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    static private ArrayList<String> menu = new ArrayList<>();

    =======
    static private ArrayList<String> menu = new ArrayList<>();

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();>>>>>>>00e0 ee123f8097f3f17a152a833ad013ebfecc08

    public static void main(String[] args) {
        showFood();
        JFrame frame = new JFrame("Menu Makanan");

        JPanel board = new JPanel();
        int counter = 0;
        board.setLayout(null);
        board.setBounds(0, 0, 1500, 990);
        int x = 20;
        for (int i = 0, y = 20; i < menu.size(); i++, y += 50) {

            JLabel lab = new JLabel(" " + menu.get(i));
            JCheckBox check = new JCheckBox();
            JTextField quantity = new JTextField();
            quantity.setBounds(x + 150 + 75, y, 75, 30);
            check.setBounds(x + 150, y, 75, 30);
            lab.setBounds(x, y, 145, 30);
            board.add(check);
            board.add(lab);
            board.add(quantity);
            System.out.println(y);
            counter += y;
        }
        frame.setSize(500, 500);
        JLabel ladder = new JLabel();
        ladder.setBounds(0, 0, 50, 200);
        ladder.setOpaque(true);
        JLayeredPane pane = frame.getLayeredPane();
        pane.add(ladder, new Integer(2)); // front
        pane.add(board, new Integer(1)); // back
        JButton submit = new JButton("SUBMIT");
        submit.setBounds(250, counter, 130, 50);
        board.add(submit);
        frame.setVisible(true);
    }

    <<<<<<<HEAD
    // public static void main(String[] Args) {
    // showFood();
    // JFrame frame = new JFrame("Menu Makanan");
    // JLabel label1 = new JLabel(menu.get(0));
    // label1.setBounds(20, 20, 50, 30);
    // frame.setSize(400, 400);
    // frame.add(label1);
    // frame.setVisible(true);

    // }

    public static void showFood() {
        ConnectDatabase conn = new ConnectDatabase();

    public static String showFood() {
        ArrayList<String> menu = new ArrayList<>();
        conn.connect();

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                menu.add(rs.getString("name_menu"));
       

            rs.toString();
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
