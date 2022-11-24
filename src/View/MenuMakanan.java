package View;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Controller.*;
import Models.Menu;

public class MenuMakanan {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public MenuMakanan() {
        JFrame frame = new JFrame("Menu Makanan");
        ArrayList<Menu> showfood = showFood();

        ArrayList<JTextField> quantity = new ArrayList<>();

        int y = 0;

        for (int i = 0; i < showfood.size(); i++) {
            JLabel foodName = new JLabel(showfood.get(i).getName_menu());
            foodName.setBounds(20, y, 150, 30);
            quantity.add(new JTextField("0"));
            quantity.get(i).setBounds(180, y, 100, 30);
            y += 60;
            frame.add(quantity.get(i));
            frame.add(foodName);
        }

        JButton submit = new JButton("Submit");
        submit.setBounds(40, y, 100, 40);
        submit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < quantity.size(); i++) {
                    int value = Integer.parseInt(quantity.get(i).getText());
                    if (value != 0) {

                        FoodOrderController.insertDB(showfood.get(i).getIdMenu(), value, showfood.get(i).getPrice());
                        System.out.println(value);
                    }
                }
            }
        });
        frame.add(submit);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public ArrayList<Menu> showFood() {
        ArrayList<Menu> menu = new ArrayList<>();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                String idMenu = rs.getString("id_menu");
                String namaMenu = rs.getString("name_menu");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                menu.add(new Menu(idMenu, namaMenu, category, price));
            }
            rs.toString();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }

        System.out.println(menu.size());
        conn.disconnect();
        return menu;
    }
}
