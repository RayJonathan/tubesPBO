package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.CustomerController;

public class ViewCheckQueue {
    public ViewCheckQueue(){
        JFrame f = new JFrame("Check Queue");

        int queue = CustomerController.urutanQueue();

        JLabel labQueue = new JLabel("Queuemu : "+queue);
        labQueue.setBounds(50,50, 100, 30);
        JButton back = new JButton("back");
        back.setBounds(50, 100, 100, 30);
        back.addActionListener(e -> {
            f.dispose();
            new ViewMenuCustomer();
        });

        f.add(labQueue);
        f.add(back);

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}