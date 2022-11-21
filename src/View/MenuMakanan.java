package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Controller.*;

public class MenuMakanan {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    static private ArrayList<String> menu = new ArrayList<>();

    // public static void main(String[] args) {
    // showFood();
    // JFrame frame = new JFrame("Menu Makanan");
    // JPanel board = new JPanel();
    // int counter = 0;
    // board.setLayout(null);
    // board.setBounds(0, 0, 1500, 990);
    // int x = 20;
    // frame.setSize(500, 500);
    // JButton submit = new JButton("SUBMIT");
    // submit.setBounds(350, counter, 130, 50);
    // board.add(submit);
    // JLabel ladder = new JLabel();
    // ladder.setBounds(0, 0, 50, 200);
    // ladder.setOpaque(true);
    // JLayeredPane pane = frame.getLayeredPane();
    // pane.add(ladder, new Integer(2)); // front
    // pane.add(board, new Integer(1)); // back
    // frame.setVisible(true);
    // }

    public static void main(String[] Args) {
        showFood();
        JFrame frame = new JFrame("Menu Makanan");

        JLabel label0 = new JLabel(menu.get(0));
        JLabel label1 = new JLabel(menu.get(1));
        JLabel label2 = new JLabel(menu.get(2));
        JLabel label3 = new JLabel(menu.get(3));
        JLabel label4 = new JLabel(menu.get(4));
        JLabel label5 = new JLabel(menu.get(5));
        JLabel label6 = new JLabel(menu.get(6));
        JLabel label7 = new JLabel(menu.get(7));

        JTextField qty0 = new JTextField();
        JTextField qty1 = new JTextField();
        JTextField qty2 = new JTextField();
        JTextField qty3 = new JTextField();
        JTextField qty4 = new JTextField();
        JTextField qty5 = new JTextField();
        JTextField qty6 = new JTextField();
        JTextField qty7 = new JTextField();

        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);
        qty0.setBounds(170, 20, 150, 30);

        label0.setBounds(20, 20, 150, 30);
        label1.setBounds(20, 60, 150, 30);
        label2.setBounds(20, 150, 150, 30);
        label3.setBounds(20, 140, 150, 30);
        label4.setBounds(20, 180, 150, 30);
        label5.setBounds(20, 220, 150, 30);
        label6.setBounds(20, 260, 150, 30);
        label7.setBounds(20, 300, 150, 30);

        frame.add(label0);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);

        frame.add(qty0);
        frame.add(qty1);
        frame.add(qty2);
        frame.add(qty3);
        frame.add(qty4);
        frame.add(qty5);
        frame.add(qty6);
        frame.add(qty7);

        frame.setSize(800, 800);
        frame.setVisible(true);

    }

    public static void showFood() {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                menu.add(rs.getString("name_menu"));
            }
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
