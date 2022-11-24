package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewJoiningMember extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonContinue, buttonBack;

    public ViewJoiningMember(){
        labTitle = new JLabel("Beli Membership?");
        buttonContinue = new JButton("ya");
        buttonBack = new JButton("tidak");

        labTitle.setBounds(20, 20, 100, 70);
        buttonContinue.setBounds(30, 220, 120, 40);
        buttonBack.setBounds(30, 270, 120, 40);

        f.add(labTitle);
        f.add(buttonContinue);
        f.add(buttonBack);

        f.setSize(400, 400);
        buttonContinue.addActionListener(this);
        buttonBack.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        if(e.getSource() == buttonContinue){
            double usersBalance = ATMController.showBalance("123");
            if(usersBalance>75000){
                CustomerController.joinMember("C001");
                JOptionPane.showMessageDialog(null, "Berhasil, kamu member kami");
                new ViewMenuCustomer();
            }else{
                new ViewTopUpATM("123", "joinMember");
            }
        }
        if(e.getSource() == buttonBack){
            new ViewMember();
        }
    }
}
//