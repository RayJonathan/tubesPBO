package View;

import Controller.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    String table ="";
    int countTable = 0;

    public ViewQueueTable(int capacity){
        String query = "SELECT * FROM `table` WHERE isOccupied = 0 AND capacity="+capacity;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                table = rs.getString("id_table");
            }else{
                table = "kosong";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        labTitle = new JLabel("Queuemu adalah "+countTable);
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
            
            new MenuCustomer();
        } else if (e.getSource() == buttonBack) {
            new ViewMenuCustomer();
        }
    }
}
