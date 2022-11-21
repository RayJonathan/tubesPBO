package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewMenuReservation extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonContinue, buttonBack;
    JRadioButton jr1, jr2, jr3;

    public ViewMenuReservation(){
        labTitle = new JLabel("Pilih Kapasitas Meja");
        jr1 = new JRadioButton("2");
        jr2 = new JRadioButton("4");
        jr3 = new JRadioButton("6");
        buttonContinue = new JButton("Continue");
        buttonBack = new JButton("Back");

        labTitle.setBounds(20, 20, 100, 70);
        jr1.setBounds(30, 90, 70, 30);
        jr2.setBounds(30, 130, 70, 30);
        jr3.setBounds(30, 170, 70, 30);
        buttonContinue.setBounds(30, 220, 120, 40);
        buttonBack.setBounds(30, 270, 120, 40);

        ButtonGroup bg=new ButtonGroup();    
        bg.add(jr1);bg.add(jr2);    

        f.add(labTitle);
        f.add(jr1);
        f.add(jr2);
        f.add(jr3);
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
        new ViewMenuReservation();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int capacityValue=0;
        if(jr1.isSelected()){
            capacityValue = 2;
        }
        if(jr2.isSelected()){
            capacityValue = 4;
        }
        if(jr3.isSelected()){
            capacityValue = 6;
        }
        
        if(e.getSource() == buttonContinue){
            f.dispose();
            new ViewQueueTable(capacityValue);
        }
        if(e.getSource() == buttonBack){
            f.dispose();
            new ViewMenuCustomer();
        }
    }
}
