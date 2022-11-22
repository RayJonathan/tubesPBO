package View;

import javax.swing.*;

import Controller.AdminController;

public class ViewMenuAdmin {
    JButton buttonTotalIncome, buttonTotalSale, buttonManageQueue, buttonAddMenu, buttonUpdateStatusFood;
    public ViewMenuAdmin() {
        JFrame f = new JFrame("Menu Admin");
        
        JLabel labTitle = new JLabel("Menu Admin");
        JButton buttonTotalIncome = new JButton("Total Income");
        JButton buttonTotalSale = new JButton("Total Sale");
        JButton buttonManageQueue = new JButton("Manage Queue");
        JButton buttonAddMenu = new JButton("Add Menu");
        JButton buttonUpdateStatusFood = new JButton("Update Status Food");
        JButton buttonLogout = new JButton("Logout");

        labTitle.setBounds(150, 20, 100, 70);
        buttonTotalIncome.setBounds(30, 90, 150, 70);
        buttonTotalSale.setBounds(190, 90, 150, 70);
        buttonManageQueue.setBounds(30, 170, 150, 70);
        buttonAddMenu.setBounds(190, 170, 150, 70);
        buttonUpdateStatusFood.setBounds(110, 250, 150, 70);
        buttonLogout.setBounds(135, 330, 100, 50);

        f.add(labTitle);
        f.add(buttonTotalIncome);
        f.add(buttonTotalSale);
        f.add(buttonManageQueue);
        f.add(buttonAddMenu);
        f.add(buttonUpdateStatusFood);
        f.add(buttonLogout);

        f.setSize(400, 500);
        buttonTotalIncome.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, 
            "Total seluruh pendapatan sebesar: " + AdminController.totalIncome());
        });

        buttonTotalSale.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, 
            "Total penjualan: \n" + AdminController.totalSale());
        });

        buttonManageQueue.addActionListener(e ->{
            
        });

        buttonAddMenu.addActionListener(e ->{});
        
        buttonUpdateStatusFood.addActionListener(e ->{});

        buttonLogout.addActionListener(e ->{
            f.dispose();
            new ViewMenuUtama();
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
