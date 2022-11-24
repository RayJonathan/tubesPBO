package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.*;
import Models.*;

public class ViewUpdateProfile extends JFrame implements ActionListener {
    JFrame f = new JFrame("Menu Update Profile");
    JButton buttonUpdateProfile, buttonBack;
    JTextField firstname, lastname;
    JPasswordField password;
    JLabel labFName, labLName, labPass;
    EnumStatusUser esu = EnumStatusUser.ADMIN;
    SingletonCustomer sc = SingletonCustomer.getInstance();
    SingletonAdmin sa = SingletonAdmin.getInstance();
    Customer cust = sc.getCurrentCustomer();
    Admin admin = sa.getCurrentAdmin();

    public ViewUpdateProfile(EnumStatusUser status) {
        labFName = new JLabel("First Name");
        labLName = new JLabel("Last Name");
        labPass = new JLabel("Password");
        String isiFirstname = "", isiLastname = "" , isiPassword = "";
        if (status == EnumStatusUser.CUSTOMER) {
            isiFirstname = cust.getFirstname();
            isiLastname = cust.getLastname();
            isiPassword = cust.getPassword();
            esu = EnumStatusUser.CUSTOMER;
        } else {
            isiFirstname = admin.getFirstname();
            isiLastname = admin.getLastname();
            isiPassword = admin.getPassword();
        }
        firstname = new JTextField(isiFirstname);
        lastname = new JTextField(isiLastname);
        password = new JPasswordField(isiPassword);
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
            if(esu == EnumStatusUser.CUSTOMER){
                cust.setFirstname(firstname.getText());
                cust.setLastname(lastname.getText());
                char[] passChar = password.getPassword();
                String inputPassword = new String(passChar);
                cust.setPassword(inputPassword);
            }else{
                admin.setFirstname(firstname.getText());
                admin.setLastname(lastname.getText());
                char[] passChar = password.getPassword();
                String inputPassword = new String(passChar);
                admin.setPassword(inputPassword);
            }
            f.dispose();
            UserController.updateDB(esu);
            if(esu==EnumStatusUser.CUSTOMER){
                new ViewMenuCustomer();
            }else{
                new ViewMenuAdmin();
            }
        } else if (e.getSource() == buttonBack) {
            if(esu==EnumStatusUser.CUSTOMER){
                new ViewMenuCustomer();
            }else{
                new ViewMenuAdmin();
            }
            f.dispose();
        }
    }
}
