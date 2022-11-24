package View;

import Controller.RegisterController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.*;

import Models.Customer;

/**
 * @author bryanimanuell
 */

public class ViewRegister {
    RegisterController rc = new RegisterController();
    Customer cust;
    JTextField username, password, email;

    public ViewRegister() {
        // JFrame
        JFrame jf = new JFrame("Input Data");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 300);

        JLabel jlNama = new JLabel("Username");
        jlNama.setBounds(50, 60, 150, 30);

        JLabel jlEmail = new JLabel("Email");
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

        JButton registrasi = new JButton("Register");
        registrasi.setBounds(100, 200, 90, 30);
        registrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = rc.searchUser();
                if (!check) {
                    rc.insertData(username.getText(), email.getText(), password.getText());
                    jf.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "username tersebut sudah ada");
                }
            }
        });

        JButton back = new JButton("Login");
        back.setBounds(400, 200, 70, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new ViewMenuUtama();
            }
        });
        //
        jf.add(jlNama);
        jf.add(username);
        jf.add(jlEmail);
        jf.add(email);
        jf.add(jlPassword);
        jf.add(password);
        jf.add(registrasi);
        jf.add(back);
        jf.getContentPane().setBackground(Color.lightGray);
        jf.setLayout(null);
        jf.setVisible(true);
    }
}
