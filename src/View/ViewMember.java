package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewMember extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    JFrame f = new JFrame("");
    JLabel labTitle,labMember;
    JButton buttonContinue, buttonBack;

    public ViewMember(){
        labTitle = new JLabel("Benefit Member");
        labMember = new JLabel("<html>Bisa Gacha Diskon<br/>dimulai dari harga 75000<br/>ANDA dapat menang diskon hingga<br/>50%<html>");
        buttonContinue = new JButton("Join Us");
        buttonBack = new JButton("Back");

        labTitle.setBounds(20, 20, 100, 70);
        labMember.setBounds(30, 90, 200, 100);
        buttonContinue.setBounds(30, 220, 120, 40);
        buttonBack.setBounds(30, 270, 120, 40);

        f.add(labTitle);
        f.add(labMember);
        f.add(buttonContinue);
        f.add(buttonBack);

        f.setSize(400, 400);
        buttonContinue.addActionListener(this);
        buttonBack.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ViewMember();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        if(e.getSource() == buttonContinue){
            new ViewJoiningMember();
        }
        if(e.getSource() == buttonBack){
            new ViewMenuCustomer();
        }
    }
}
