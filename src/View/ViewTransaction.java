package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.ConnectDatabase;
import Controller.SingletonDatabase;
import Models.ReceiptDetails;
import Models.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewTransaction {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    public static void main(String[] args) {
        new ViewTransaction();
    }

    public ViewTransaction(){
        JFrame frame = new JFrame("Transaksi");
        Transaction transactions = getTransaction("TRA001");
        ArrayList<ReceiptDetails> listMakanan = getRecieptDetail(transactions.getIdReciept());
        
        int y = 20;
        for (int i = 0; i < listMakanan.size(); i++) {
            JLabel listPembelian = new JLabel(listMakanan.get(i).getQuantity() + "x "
                + getNamaMakanan(listMakanan.get(i).getIdMenu()));
            JLabel listHarga = new JLabel("Rp " + listMakanan.get(i).getTotal());

            listPembelian.setBounds(50, y, 150, 25);
            listHarga.setBounds(200, y, 150, 25);
            frame.add(listPembelian);
            frame.add(listHarga);
            y += 50;
        }
        JLabel discount = new JLabel("Discount: " + getDiscount(transactions.getIdDiscount()) + "%");
        discount.setBounds(50, y, 150, 25);
        frame.add(discount);
        y += 50;
        JLabel total = new JLabel("Total: Rp" + transactions.getTotal());
        total.setBounds(50, y, 150, 25);
        frame.add(total);
        y += 50;

        JButton done = new JButton("Done");
        done.setBounds(50, y, 150, 25);
        frame.add(done);
        done.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ViewMenuCustomer();
            }
        });

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public Transaction getTransaction(String idTrans){
        Transaction transaction = null;
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM transaction WHERE id_transaction = '" + idTrans + "'");
            while (rs.next()) {
                String idTransaction = rs.getString("id_transaction");
                String idReceipt = rs.getString("id_receipt");
                String idDiscount = rs.getString("id_discount");
                double total = rs.getDouble("total");
                transaction = new Transaction(idTransaction, idReceipt, idDiscount, total);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }

        conn.disconnect();
        return transaction;
    }
    public ArrayList<ReceiptDetails> getRecieptDetail(String idReciept){
        ArrayList<ReceiptDetails> receiptDetails = new ArrayList<>();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM receiptdetails WHERE id_receipt = '" + idReciept + "'");
            while (rs.next()) {
                String idReceiptDetails = rs.getString("id_receiptDetails");
                String idReceipt = rs.getString("id_receipt");
                String idMenu = rs.getString("id_menu");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status_food_progress");
                double total = rs.getDouble("subtotal");
                receiptDetails.add(new ReceiptDetails(idReceiptDetails, idReceipt, idMenu, quantity, status, total));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return receiptDetails;
    }
    public String getNamaMakanan(String idMenu){
        String nama = "";
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM menu WHERE id_menu = '" + idMenu + "'");
            while (rs.next()) {
                nama = rs.getString("name_menu");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return nama;
    }
    public int getDiscount(String idDiscount){
        int ammount = 0;
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM discount WHERE id_discount = '" + idDiscount + "'");
            while (rs.next()) {
                ammount = rs.getInt("discount_amount");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return ammount;
    }
}