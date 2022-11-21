package View;

import java.awt.event.*;

import javax.swing.*;

import Controller.ATMController;

public class TopUpATM {
    public TopUpATM(String username) {

        JFrame f = new JFrame("TOP UP");
        JLabel tag1 = new JLabel("TOP UP BALANCE");
        JLabel tag2 = new JLabel("Insert Balance");
        JButton topUp = new JButton("Top Up");
        JButton back = new JButton("Back");
        JTextField value = new JTextField();
        tag1.setBounds(150, 10, 250, 30);
        tag2.setBounds(10, 50, 90, 30);
        value.setBounds(110, 50, 150, 30);
        topUp.setBounds(50, 100, 95, 30);
        back.setBounds(155, 100, 95, 30);
        f.add(topUp);
        f.add(tag1);
        f.add(tag2);
        f.add(value);
        f.add(back);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        topUp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int topupValue = Integer.parseInt(value.getText());

                ATMController.setBalance(topupValue, username);

            }
        });
    }
}
