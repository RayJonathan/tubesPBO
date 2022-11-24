package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.ConnectDatabase;
import Controller.CustomerController;
import Controller.SingletonCustomer;
import Controller.SingletonDatabase;
import Controller.SingletonReceipt;
import Models.Discount;
import Models.EnumStatusFood;
import Models.ReceiptDetails;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewTransaction {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    double totalHarga = 0;
    Discount diskon = new Discount("", 0);
    public static void main(String[] args) {
        new ViewTransaction();
    }
    public ViewTransaction(){
        JFrame frame = new JFrame("Transaksi");
        SingletonCustomer sc = SingletonCustomer.getInstance();
        SingletonReceipt sr = SingletonReceipt.getInstance();
        String recieptId = "RE001";
        String idCust = "";
        double balCust = 0;

        ArrayList<ReceiptDetails> listMakanan = getRecieptDetail(recieptId);
        ArrayList<Double> hargaMakanan = getHargaMakanan(recieptId);
        
        int y = 20;
        for (int i = 0; i < listMakanan.size(); i++) {
            JLabel listPembelian = new JLabel(listMakanan.get(i).getQuantity() + "x "
                + getNamaMakanan(listMakanan.get(i).getIdMenu()));
            JLabel listHarga = new JLabel("Rp " + hargaMakanan.get(i));

            totalHarga += hargaMakanan.get(i);

            listPembelian.setBounds(50, y, 150, 25);
            listHarga.setBounds(200, y, 150, 25);
            frame.add(listPembelian);
            frame.add(listHarga);
            y += 50;
        }
        if (sc.getCurrentCustomer().getIsMember()) {
            diskon = CustomerController.gachaDiscount();
        }
        totalHarga = totalHarga * (100-diskon.getDiscountAmount()) / 100;

        JLabel discount = new JLabel("Discount: " + diskon.getDiscountAmount() + "%");
        discount.setBounds(50, y, 150, 25);
        frame.add(discount);

        y += 50;
        JLabel total = new JLabel("Total: Rp" + totalHarga);
        total.setBounds(50, y, 150, 25);
        frame.add(total);
        y += 50;

        JButton done = new JButton("Done");
        done.setBounds(50, y, 150, 25);
        frame.add(done);
        done.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (balCust - totalHarga >= 0) {
                    CustomerController.payFoods(idCust, balCust - totalHarga);
                    CustomerController.newTransaction(recieptId, diskon.getIdDiscount(), totalHarga);
                } else {
                    new ViewTopUpATM("pppppppppppppppppppppUSERNAME", "bayar");
                }
                frame.dispose();
                new ViewMenuCustomer();
            }
        });

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                receiptDetails.add(
                        new ReceiptDetails(idReceiptDetails, idReceipt, idMenu, quantity, EnumStatusFood.DELIVERED));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return receiptDetails;
    }
    public ArrayList<Double> getHargaMakanan(String idReciept){
        ArrayList<Double> totalReciept = new ArrayList<>();
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM receiptdetails WHERE id_receipt = '" + idReciept + "'");
            while (rs.next()) {
                totalReciept.add(rs.getDouble("subtotal"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal memasukkan data ke database");
            System.out.println(e);
        }
        conn.disconnect();
        return totalReciept;
    }

    public String getNamaMakanan(String idMenu) {
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
    /* public int getDiscount(String idDiscount){
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
    } */
}