package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import View.ViewMenuUtama;

import Models.*;
import java.awt.event.*;
/**
 *
 * @author bryanimanuell
 */

public class RegisterController {
    Customer cust;
    JTextField username, password, email;

    public RegisterController() {
        cust = new Customer();
        form();
    }

    public void insertDB() {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO users(userName, userEmail, password) VALUES(?,?,?)");
            stat.setString(1, cust.getUsername());
            stat.setString(2, cust.getEmail());
            stat.setString(3, cust.getPassword());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil memasukkan data ke database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
    }

    public void form() {
        // JFrame
        JFrame jf = new JFrame("Input Data");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 800);

        JLabel jlNama = new JLabel("Username");
        jlNama.setBounds(50, 60, 150, 30);

        JLabel jlEmail = new JLabel("Enail");
        jlEmail.setBounds(50, 90, 150, 30);

        JLabel jlPassword = new JLabel("Password");
        jlPassword.setBounds(50, 120, 150, 30);

        // input
        username = new JTextField();
        username.setBounds(180, 65, 240, 20);

        email = new JTextField();
        email.setBounds(180, 95, 240, 20);

        password = new JPasswordField();
        password.setBounds(180, 125, 240, 20);

        JButton submit = new JButton("Registrasi");
        submit.setBounds(100, 700, 90, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = searchUser();
                if (!check) {
                    insertData();
                    insertDB();
                    jf.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "username tersebut sudah ada");
                }
            }
        });

        JButton back = new JButton("Logout");
        back.setBounds(400, 700, 70, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new ViewMenuUtama();
            }
        });

        jf.add(jlNama);
        jf.add(username);
        jf.add(jlEmail);
        jf.add(email);
        jf.add(jlPassword);
        jf.add(password);
        jf.add(submit);
        jf.add(back);

        jf.setLayout(null);
        jf.setVisible(true);
    }

    public void insertData() {
        cust.setUsername(username.getText());
        cust.setPassword(password.getText());
        cust.setEmail(email.getText());
    }

    public boolean searchUser() {
        boolean available = false;

        return available;
    }
}
