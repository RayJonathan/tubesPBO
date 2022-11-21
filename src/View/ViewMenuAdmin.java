package View;

import javax.swing.*;

import Controller.AdminController;
import Models.Menu;

public class ViewMenuAdmin {
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

        buttonTotalIncome.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, 
            "Total seluruh pendapatan sebesar: " + AdminController.totalIncome());
        });

        buttonTotalSale.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, 
            "Total penjualan: \n" + AdminController.totalSale());
        });

        buttonManageQueue.addActionListener(e ->{});

        buttonAddMenu.addActionListener(e ->{
            f.dispose();
            AddMenu();
        });

        buttonUpdateStatusFood.addActionListener(e ->{});

        buttonLogout.addActionListener(e ->{
            f.dispose();
            new ViewMenuUtama();
        });

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void AddMenu() {
        JFrame f = new JFrame("Add Menu");
        
        JLabel labTitle = new JLabel("Add New Menu");
        JLabel labIdMenu = new JLabel("Id Menu:");
        JLabel labNameMenu = new JLabel("Menu Name:");
        JLabel labCategory = new JLabel("Category:");
        JLabel labPrice = new JLabel("Price:");

        JTextField inpIdMenu = new JTextField();
        JTextField inpNameMenu = new JTextField();

        JRadioButton food = new JRadioButton("Food");
        JRadioButton drink = new JRadioButton("Drink");
        ButtonGroup category = new ButtonGroup();
        category.add(food);
        category.add(drink);

        JTextField inpPrice = new JTextField();

        JButton buttonAdd = new JButton("Add");
        JButton buttonCancel = new JButton("Cancel");

        labTitle.setBounds(160, 20, 100, 40);
        labIdMenu.setBounds(50, 70, 100, 40);
        labNameMenu.setBounds(50, 120, 100, 40);
        labCategory.setBounds(50, 170, 100, 40);
        labPrice.setBounds(50, 220, 100, 40);

        inpIdMenu.setBounds(130, 75, 100, 25);
        inpNameMenu.setBounds(130, 125, 100, 25);
        food.setBounds(130, 170, 65, 25);
        drink.setBounds(190, 170, 65, 25);
        inpPrice.setBounds(130, 220, 105, 25);

        buttonAdd.setBounds(90, 270, 75, 50);
        buttonCancel.setBounds(210, 270, 75, 50);

        f.add(labTitle);
        f.add(labIdMenu);
        f.add(labNameMenu);
        f.add(labCategory);
        f.add(labPrice);

        f.add(inpIdMenu);
        f.add(inpNameMenu);
        f.add(food);
        f.add(drink);
        f.add(inpPrice);

        f.add(buttonAdd);
        f.add(buttonCancel);

        buttonAdd.addActionListener(e ->{
            String idMenu = inpIdMenu.getText();
            String namaMenu = inpNameMenu.getText();
            String categoryTemp = "";
            if(food.isSelected()) {
                categoryTemp = "Food";
            } else if(drink.isSelected()) {
                categoryTemp = "Drink";
            }
            double price = Double.parseDouble(inpPrice.getText());
            
            Menu newMenu = new Menu(idMenu, namaMenu, categoryTemp, price);

            AdminController.addMenu(newMenu);
        });

        buttonCancel.addActionListener(e ->{
            f.dispose();
            new ViewMenuAdmin();
        });


        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
