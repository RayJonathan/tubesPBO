package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Models.Discount;
import Models.Transaction;

public class CustomerController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static String joinMember(String idCust) {
        conn.connect();
        String output = "";
        String query = "UPDATE customer SET isMember ='" + 1 + "'"
                + "WHERE id_cust ='" + idCust + "'";
        ;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }

    public static Discount gachaDiscount() {
        conn.connect();
        ArrayList<Discount> discount = new ArrayList<>();
        String query = "SELECT * FROM discount WHERE id_discount <> 'D000'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                discount.add(new Discount(rs.getString("id_discount"), rs.getInt("discount_amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        Random ran = new Random();
        return discount.get(ran.nextInt(discount.size()));
    }

    public static String reserveMeja(String idTable, String idUser) {
        conn.connect();
        try {
            String template = hitungId();
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO reservation VALUES(?,?,?)");
            stat.setString(1, template);
            stat.setString(2, idTable);
            stat.setString(3, idUser);
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return "";
    }

    public static String hitungId() {
        String idTerbaru = "";
        String query = "SELECT MAX(id_reservation) FROM reservation";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String idTerbesar = "";
            if (rs.next()) {
                idTerbesar = rs.getString("MAX(id_reservation)");
            }
            String angkaStrTerbesar = idTerbesar.substring(1);
            int angkaTerbesar = Integer.parseInt(angkaStrTerbesar);
            int angkaTerbaru = angkaTerbesar + 1;
            String angkaStrTerbaru = Integer.toString(angkaTerbaru);
            if (angkaTerbaru < 10) {
                idTerbaru = "R00" + angkaStrTerbaru;
            } else if (angkaTerbaru < 100) {
                idTerbaru = "R0" + angkaStrTerbaru;
            } else {
                idTerbaru = "R" + angkaStrTerbaru;
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }
        conn.disconnect();
        return idTerbaru;
    }

    public static String orderMenu(String details, String receipt, String menu, int quantity, String status,
            double subtotal) {
        status = "inProgress";
        conn.connect();
        String output = "";
        String query = "INSERT INTO receiptDetails VALUES ('" + details + "'" + receipt + "'" + menu + "'" + quantity
                + "'" + status + "'" + subtotal + "')";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }

    public static ArrayList<Transaction> checkTransaction(String idCust) {
        conn.connect();
        String query = "SELECT a.* FROM transaction a"
                + "INNER JOIN receipt b ON a.id_receipt = b.id_receipt"
                + "INNER JOIN reservation c ON b.id_reservation = c.id_reservation"
                + "WHERE c.id_cust = '" + idCust + "'";
        ArrayList<Transaction> transaksi = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                transaksi.add(new Transaction(
                rs.getString("id_transaction"), 
                rs.getString("id_receipt"),
                rs.getString("id_discount"),
                rs.getDouble("total")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return transaksi;
    }
    public static int urutanQueue(){
        SingletonCustomer sc = SingletonCustomer.getInstance();
        SingletonQueue sq = SingletonQueue.getInstance();
        int countTable = 1;
        conn.connect();
        boolean ketemu = false;
        String query = "SELECT * FROM queue WHERE capacity= "+sq.getcurrentQueue().getJumlahOrang();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            boolean exit = false;
            while(rs.next() && !exit){
                if(rs.getString("id_cust").equals(sc.getCurrentCustomer().getIdCust())){
                    exit = true;
                    ketemu = true;
                }else{
                    countTable++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        conn.disconnect();
        if(ketemu){
            return countTable;
        }else{
            return 0;
        }
    }
    public static String hitungIdTransaction() {
        String idTerbaru = "";
        String query = "SELECT COUNT(id_transaction) as 'Count' FROM transaction";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int idTerbesar = 0;
            if (rs.next()) {
                idTerbesar = rs.getInt("Count");
            }
            int angkaTerbaru = idTerbesar + 1;
            String angkaStrTerbaru = Integer.toString(angkaTerbaru);
            if (angkaTerbaru < 10) {
                idTerbaru = "TRA00" + angkaStrTerbaru;
            } else if (angkaTerbaru < 100) {
                idTerbaru = "TRA0" + angkaStrTerbaru;
            } else {
                idTerbaru = "TRA" + angkaStrTerbaru;
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }
        return idTerbaru;
    }
    public static String newTransaction(String idReceipt, String idDiscount, double total) {
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement(
                    "INSERT INTO transaction VALUES(?,?,?,?)");
            String idTransaction = hitungIdTransaction();
            stat.setString(1, idTransaction);
            stat.setString(2, idReceipt);
            stat.setString(3, idDiscount);
            stat.setDouble(4, total);
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        String idTable = "";
        try{
            String query = "SELECT id_table FROM reservation WHERE id_reservation =("+
                "SELECT id_reservation FROM receipt WHERE id_receipt =("+
                "SELECT id_receipt FROM transaction WHERE id_transaction = 'TRA006'))";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                idTable = rs.getString("id_table");
            }
            
            String query2 = "UPDATE `table` SET isOccupied = 0 WHERE id_table = '"+idTable+"'";
            Statement stmt2 = conn.con.createStatement();
            stmt2.executeUpdate(query2);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database updatetableisoccupied");
            System.out.println(e);
        }
        conn.disconnect();
        return "";
    }
    public static String payFoods(String idCust, double newBal) {
        conn.connect();
        String output = "";
        String query = "UPDATE customer SET balance ='" + newBal + "'"
                + "WHERE id_cust ='" + idCust + "'";
        ;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            output = "Berhasil memasukan data";
        } catch (SQLException e) {
            output = "Gagal memasukan data";
        }
        conn.disconnect();
        return output;
    }
}