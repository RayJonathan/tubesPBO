package View;

import java.awt.event.*;
import Controller.ATMController;
import javax.swing.*;

public class MainATM {
    public MainATM() { 
        
        String username = "123";
        JFrame f = new JFrame("ATM");
        JLabel tag = new JLabel("WELLCOME TO ATM");
        JButton topUp = new JButton("Top Up");
        JButton balance = new JButton("Balance");
        JButton back = new JButton("Back");
        tag.setBounds(150, 10, 250, 30);
        topUp.setBounds(50, 100, 95, 30);
        balance.setBounds(200, 100, 95, 30);
        back.setBounds(150, 200, 80, 30);
        f.add(topUp);
        f.add(balance);
        f.add(tag);
        f.add(back);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        topUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TopUpATM(username);
            }
        });
        balance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ATMController.showBalance(username);
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewMenuCustomer();
            }
        });
    }

}
