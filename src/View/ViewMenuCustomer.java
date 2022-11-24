package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Models.EnumStatusUser;
import Models.QueueTable;
import Models.Customer;

public class ViewMenuCustomer extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    SingletonCustomer sc = SingletonCustomer.getInstance();
    Customer cust = sc.getCurrentCustomer();
    JFrame f = new JFrame("");
    JLabel labTitle;
    JButton buttonReservation, buttonJoinMember, buttonATM, buttonUpdateProfile, buttonLogout, buttonFoodOrder;
    SingletonQueue sq = SingletonQueue.getInstance();

    public ViewMenuCustomer() {        
        String text = "";
        boolean valid = QueueController.cekValiditasQueue();
        if(valid == true){
            text = "<html>Selamat Datang, "+cust.getFirstname()+"<br> queuemu "+CustomerController.urutanQueue()+"</html>";
        }else{
            text = "<html>Selamat Datang, "+cust.getFirstname();
        }
        labTitle = new JLabel(text);
        buttonFoodOrder = new JButton("Order Food");
        buttonReservation = new JButton("Reserve Table");
        buttonJoinMember = new JButton("Join Membership");
        buttonATM = new JButton("Balance");
        buttonUpdateProfile = new JButton("Update Profile");
        buttonLogout = new JButton("LogOut");

        labTitle.setBounds(20, 20, 200, 70);
        buttonReservation.setBounds(30, 90, 150, 70);
        buttonJoinMember.setBounds(190, 90, 150, 70);
        buttonATM.setBounds(30, 170, 150, 70);
        buttonUpdateProfile.setBounds(190, 170, 150, 70);
        buttonLogout.setBounds(240, 250, 100, 30);
        buttonFoodOrder.setBounds(30, 90, 150, 70);

        f.add(labTitle);
        f.add(buttonReservation);
        f.add(buttonJoinMember);
        f.add(buttonATM);
        f.add(buttonUpdateProfile);
        f.add(buttonLogout);

        f.setSize(400, 400);
        buttonReservation.addActionListener(this);
        buttonJoinMember.addActionListener(this);
        buttonATM.addActionListener(this);
        buttonUpdateProfile.addActionListener(this);
        buttonLogout.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        if (e.getSource() == buttonReservation) {
            new ViewMenuReservation();
        } else if (e.getSource() == buttonJoinMember) {
            new ViewMember();
        } else if (e.getSource() == buttonATM) {
            new ViewMenuATM();
        } else if (e.getSource() == buttonUpdateProfile) {
            new ViewUpdateProfile(EnumStatusUser.CUSTOMER);
        } else if (e.getSource() == buttonLogout) {
            new ViewMenuUtama();
        }
    }

}
