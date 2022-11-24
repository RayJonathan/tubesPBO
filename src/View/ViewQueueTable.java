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
    SingletonCustomer cust = SingletonCustomer.getInstance();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonContinue, buttonBack;
    String table ="";
    String noTable ="";
    int countTable = 0;
    int capacityStatic = 0;

    public ViewQueueTable(int capacity){
        conn.connect();
        capacityStatic = capacity;
        String query = "SELECT * FROM `table` WHERE isOccupied = 0 AND capacity="+capacity;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                table = rs.getString("id_table");
                noTable = rs.getString("noTable");
            }else{
                table = "kosong";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query2 = "SELECT * FROM queue WHERE id_cust <> '"+cust.getCurrentCustomer().getIdCust()+"' AND capacity= "+capacity;
        try{
            Statement stmt2 = conn.con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(query2);
            while(rs2.next()){
                countTable++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        conn.disconnect();

        String stringTitle="";
        if(countTable==0){
            stringTitle = "Silahkan duduk, mejamu di meja "+noTable;
        }else{
            stringTitle = "Queuemu adalah "+countTable+ ", confirm reservation/cancel";
        }
        labTitle = new JLabel(stringTitle);
        buttonContinue = new JButton("Confirm");
        buttonBack = new JButton("Cancel");

        labTitle.setBounds(20, 20, 200, 40);
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
        if (e.getSource() == buttonContinue) {
            if(countTable==0){
                TableController.isOccupiedManipulation(noTable);
                new ViewMenuMakanan();
            }else{
                QueueController.insertIntoQueue(capacityStatic);
                new ViewMenuCustomer();
            }
            f.dispose();
        } else if (e.getSource() == buttonBack) {
            new ViewMenuCustomer();
            f.dispose();
        }
    }
}
