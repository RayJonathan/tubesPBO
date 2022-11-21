package View;

import java.awt.event.*;
import Controller.*;
import javax.swing.*;

public class BalanceATM {
    public BalanceATM() {
        JFrame f = new JFrame("BALANCE");
        JLabel tag1 = new JLabel("YOUR BALANCE IS :");
        JTextField value = new JTextField();
        JButton back = new JButton("Back");
        tag1.setBounds(150, 10, 250, 30);
        value.setBounds(110, 50, 150, 30);
        back.setBounds(155, 100, 95, 30);

        f.add(tag1);
        f.add(back);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        back.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int topupValue = Integer.parseInt(value.getText());
                System.out.println(TopupController.setBalance(topupValue));
            }
        });
    }
}
