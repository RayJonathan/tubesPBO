package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUpdateProfile extends JFrame implements ActionListener {
    JFrame f = new JFrame("Menu Update Profile");
    JButton buttonUpdateProfile, buttonBack;
    JTextField firstname, lastname;
    JPasswordField password;
    JLabel labFName, labLName, labPass;

    public ViewUpdateProfile() {
        labFName = new JLabel("First Name");
        labLName = new JLabel("Last Name");
        labPass = new JLabel("Password");
        firstname = new JTextField();
        lastname = new JTextField();
        password = new JPasswordField();
        buttonUpdateProfile = new JButton("Update Profile");
        buttonBack = new JButton("Back");

        f.setSize(400, 300);
        labFName.setBounds(20, 20, 100, 30);
        labLName.setBounds(20, 50, 100, 30);
        labPass.setBounds(20, 80, 100, 30);

        firstname.setBounds(120, 20, 200, 30);
        lastname.setBounds(120, 50, 200, 30);
        password.setBounds(120, 80, 200, 30);

        buttonUpdateProfile.setBounds(30, 200, 100, 50);
        buttonBack.setBounds(140, 200, 100, 50);

        f.add(labFName);
        f.add(labLName);
        f.add(labPass);

        f.add(firstname);
        f.add(lastname);
        f.add(password);

        f.add(buttonUpdateProfile);
        f.add(buttonBack);

        buttonUpdateProfile.addActionListener(this);
        buttonBack.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUpdateProfile) {
            System.out.println("haa");
            f.dispose();
            new UserController();
        } else if (e.getSource() == buttonBack) {
            new ViewMenuCustomer();
        } 
    }

    // public static void main(String[] args) {
    //     new ViewUpdateProfile();
    // }
}