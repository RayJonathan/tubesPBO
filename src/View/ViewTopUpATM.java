package View;

import java.awt.event.*;

import javax.swing.*;

import Controller.ATMController;
import Controller.SingletonCustomer;

public class ViewTopUpATM {
    SingletonCustomer sc = SingletonCustomer.getInstance();
    public ViewTopUpATM(String username, String prevMenu) {
        JFrame f = new JFrame("TOP UP");
        JLabel tag1 = new JLabel("TOP UP BALANCE");
        JLabel tag2 = new JLabel("Insert Balance");
        JButton topUp = new JButton("Top Up");
        JButton back = new JButton("Back");
        JLabel saldo = new JLabel("Saldo : "+sc.getCurrentCustomer().getBalance());
        JTextField value = new JTextField();
        tag1.setBounds(150, 10, 250, 30);
        tag2.setBounds(10, 50, 90, 30);
        value.setBounds(110, 50, 150, 30);
        saldo.setBounds(10, 100, 90, 30);
        topUp.setBounds(50, 130, 95, 30);
        back.setBounds(155, 130, 95, 30);
        f.add(topUp);
        f.add(tag1);
        f.add(tag2);
        f.add(value);
        f.add(saldo);
        f.add(back);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topUp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int topupValue = Integer.parseInt(value.getText());

                ATMController.setBalance(topupValue, username);

            }
        });

        back.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                if (prevMenu.equals("bayar")) {
                    new ViewTransaction();
                } else {
                    new ViewMenuATM();
                }

            }
        });

    }

}
