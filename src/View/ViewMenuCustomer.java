package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewMenuCustomer extends JFrame implements ActionListener { 
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
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

        labTitle.setBounds(20, 20, 100, 50);
        buttonReservation.setBounds(40, 40, 100, 50);
        buttonJoinMember.setBounds(60, 40, 100, 50);
        buttonATM.setBounds(40, 60, 100, 50);
        buttonUpdateProfile.setBounds(60, 60, 100, 50);
        buttonBack.setBounds(360, 360, 100, 20);

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
