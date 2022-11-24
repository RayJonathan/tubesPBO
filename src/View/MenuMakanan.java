package View;

import java.awt.event.*;
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

    public static void main(String[] args) {
        showFood();
        JFrame frame = new JFrame("Menu Makanan");
        ArrayList<String> namaMakanan = new ArrayList<>();
        ArrayList<Double> qty = new ArrayList<>();
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

        JButton submit = new JButton("Submit");

        qty0.setBounds(150, 20, 150, 30);
        qty1.setBounds(150, 60, 150, 30);
        qty2.setBounds(150, 100, 150, 30);
        qty3.setBounds(150, 140, 150, 30);
        qty4.setBounds(150, 180, 150, 30);
        qty5.setBounds(150, 220, 150, 30);
        qty6.setBounds(150, 260, 150, 30);
        qty7.setBounds(150, 300, 150, 30);

        label0.setBounds(20, 20, 150, 30);
        label1.setBounds(20, 60, 150, 30);
        label2.setBounds(20, 100, 150, 30);
        label3.setBounds(20, 140, 150, 30);
        label4.setBounds(20, 180, 150, 30);
        label5.setBounds(20, 220, 150, 30);
        label6.setBounds(20, 260, 150, 30);
        label7.setBounds(20, 300, 150, 30);

        submit.setBounds(40, 340, 150, 30);
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
        frame.add(submit);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        submit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double quantity0 = Integer.parseInt(qty0.getText());
                double quantity1 = Integer.parseInt(qty1.getText());
                double quantity2 = Integer.parseInt(qty2.getText());
                double quantity3 = Integer.parseInt(qty3.getText());
                double quantity4 = Integer.parseInt(qty4.getText());
                double quantity5 = Integer.parseInt(qty5.getText());
                double quantity6 = Integer.parseInt(qty6.getText());
                double quantity7 = Integer.parseInt(qty7.getText());
                if (quantity0 != 0) {
                    namaMakanan.add(menu.get(0));
                    qty.add(quantity0);
                }
                if (quantity1 != 0) {
                    namaMakanan.add(menu.get(1));
                    qty.add(quantity1);
                }
                if (quantity2 != 0) {
                    namaMakanan.add(menu.get(2));
                    qty.add(quantity2);
                }
                if (quantity3 != 0) {
                    namaMakanan.add(menu.get(3));
                    qty.add(quantity3);
                }
                if (quantity4 != 0) {
                    namaMakanan.add(menu.get(4));
                    qty.add(quantity4);
                }
                if (quantity5 != 0) {
                    namaMakanan.add(menu.get(5));
                    qty.add(quantity5);
                }
                if (quantity6 != 0) {
                    namaMakanan.add(menu.get(6));
                    qty.add(quantity6);
                }
                if (quantity7 != 0) {
                    namaMakanan.add(menu.get(7));
                    qty.add(quantity7);
                }

                for (int i = 0; i < menu.size(); i++) {
                    FoodOrderController.insertDB(menu.get(i), qty.get(i));
                }

            }
        });
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
