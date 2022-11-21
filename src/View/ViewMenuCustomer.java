package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewMenuCustomer extends JFrame implements ActionListener {
    ConnectDatabase conn = new ConnectDatabase();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonReservation, buttonJoinMember, buttonATM, buttonUpdateProfile,buttonBack;

    public ViewMenuCustomer() {
        labTitle = new JLabel("Hey");
        buttonReservation = new JButton("Reserve Table");
        buttonJoinMember = new JButton("Join Membership");
        buttonATM = new JButton("Balance");
        buttonUpdateProfile = new JButton("Update Profile");
        buttonBack = new JButton("back");

        labTitle.setBounds(20, 20, 100, 20);
        buttonReservation.setBounds(40, 20, 100, 20);
        buttonJoinMember.setBounds(40, 20, 100, 20);
        buttonATM.setBounds(80, 20, 100, 20);
        buttonUpdateProfile.setBounds(80, 20, 100, 20);
        buttonBack.setBounds(360, 20, 100, 20);

        f.add(labTitle);
        f.add(buttonReservation);
        f.add(buttonJoinMember);
        f.add(buttonATM);
        f.add(buttonUpdateProfile);
        f.add(buttonBack);
        
        f.setSize(400, 400);
        buttonReservation.addActionListener(this);
        buttonJoinMember.addActionListener(this);
        buttonATM.addActionListener(this);
        buttonUpdateProfile.addActionListener(this);
        buttonBack.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
