package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewQueueTable extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonContinue, buttonBack;
    public ViewQueueTable(int capacity){
        labTitle = new JLabel("Queuemu adalah");
        buttonContinue = new JButton("Continue");
        buttonBack = new JButton("Return");

        labTitle.setBounds(20, 20, 100, 20);
        buttonContinue.setBounds(200, 100, 100, 40);
        buttonBack.setBounds(80, 100, 100, 40);

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
        if (e.getSource() == buttonContinue) {
            new MenuMakanan();
        } else if (e.getSource() == buttonBack) {
            new ViewMenuCustomer();
        }
    }
}
