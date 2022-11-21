package View;

import javax.swing.*;

public class TopUpATM {
    public static void main(String[] args) {
        JFrame f = new JFrame("TOP UP");
        JLabel tag1 = new JLabel("TOP UP BALANCE");
        JLabel tag2 = new JLabel("Insert Balance");
        JTextField value = new JTextField();
        JButton topUp = new JButton("Top Up");
        JButton back = new JButton("Back");
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
    }
}
