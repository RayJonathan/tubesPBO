package Controller;

import Models.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueueController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    static SingletonCustomer cust = SingletonCustomer.getInstance();
    static SingletonQueue queue = SingletonQueue.getInstance();

    public static boolean cekValiditasQueue(){
        conn.connect();
        String idCust = cust.getCurrentCustomer().getIdCust();
        String queryIdQueue = "SELECT * FROM queue WHERE id_cust='"+idCust+"'";
        boolean valid = false;
        try {
            Statement stmtIdQueue = conn.con.createStatement();
            ResultSet rsIdQueue = stmtIdQueue.executeQuery(queryIdQueue);
            if (rsIdQueue.next()) {
                QueueTable q = new QueueTable(rsIdQueue.getInt("id_queue"), idCust, rsIdQueue.getInt("capacity"));
                queue.setcurrentQueue(q);
                valid = true;
            }
        } catch (SQLException eQueue) {
            eQueue.printStackTrace();
        }
        conn.disconnect();
        return valid;
    }

    public static void insertIntoQueue(int capacity){
        conn.connect();
        int countID = 0;
                String queryIdQueue = "SELECT * FROM queue";
                try{
                    Statement stmtIdQueue = conn.con.createStatement();
                    ResultSet rsIdQueue = stmtIdQueue.executeQuery(queryIdQueue);
                    while(rsIdQueue.next()){
                        countID++;
                    }
                } catch (SQLException eQueue) {
                    eQueue.printStackTrace();
                }
                countID = countID + 1;
                String queryQueue = "INSERT INTO queue VALUES ('"+countID+"','"+cust.getCurrentCustomer().getIdCust()+"', '"+capacity+"')";
                try{
                    Statement stmtQueue = conn.con.createStatement();
                    stmtQueue.executeUpdate(queryQueue);
                } catch (SQLException eQueue) {
                    eQueue.printStackTrace();
                }

                QueueTable q = new QueueTable(countID, cust.getCurrentCustomer().getIdCust(), capacity);
                queue.setcurrentQueue(q);

                conn.disconnect();

    }
}
