package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Models.*;

/**
 *
 * @author calvin
 */
public class ViewMenuUtama extends JFrame implements ActionListener {
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    JFrame f = new JFrame("");
    JTextField username;
    JPasswordField pass;
    JLabel labUsername, labPass, labError;
    JButton login, register;

    public ViewMenuUtama() {
        username = new JTextField("");
        pass = new JPasswordField("");
        labUsername = new JLabel("Username :");
        labPass = new JLabel("Password :");
        login = new JButton("Login");
        register = new JButton("Register");
        labError = new JLabel("Username/Pass Incorrect");

        labUsername.setBounds(20, 20, 100, 20);
        labPass.setBounds(20, 50, 100, 20);
        username.setBounds(120, 20, 140, 20);
        pass.setBounds(120, 50, 140, 20);
        login.setBounds(200, 100, 100, 40);
        register.setBounds(80, 100, 100, 40);
        labError.setBounds(120, 70, 200, 20);

        f.add(username);
        f.add(pass);
        f.add(labUsername);
        f.add(labPass);
        f.add(register);
        f.add(login);
        f.add(labError);
        labError.setVisible(false);
        f.setSize(400, 400);
        login.addActionListener(this);
        register.addActionListener(this);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String searchUsername = username.getText();
            char[] arrPass = pass.getPassword();
            String searchPass = new String(arrPass);
            String id = "";
            String status = "";
            String query = "SELECT * FROM customer WHERE username='" + searchUsername + "' AND password='" + searchPass
                    + "'";
            String query2 = "SELECT * FROM admin WHERE username='" + searchUsername + "' AND password='" + searchPass
                    + "'";
            conn.connect();
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    SingletonCustomer sc = SingletonCustomer.getInstance();
                    Customer cust = new Customer();
                    id = rs.getString("id_cust");
                    cust.setIdCust(id);
                    cust.setUsername(rs.getString("username"));
                    cust.setPassword(rs.getString("password"));
                    cust.setFirstname(rs.getString("firstname"));
                    cust.setLastname(rs.getString("lastname"));
                    cust.setEmail(rs.getString("email"));
                    cust.setIsMember(rs.getBoolean("isMember"));
                    cust.setBalance(rs.getDouble("balance"));
                    status = "cust";
                    sc.setCurrentCustomer(cust);
                }

                Statement stmt2 = conn.con.createStatement();
                ResultSet rs2 = stmt2.executeQuery(query2);
                while (rs2.next()) {
                    SingletonAdmin sa = SingletonAdmin.getInstance();
                    Admin admin = new Admin();
                    id = rs2.getString("id_admin");
                    admin.setIdAdmin(id);
                    admin.setUsername(rs2.getString("username"));
                    admin.setPassword(rs2.getString("password"));
                    admin.setFirstname(rs2.getString("firstname"));
                    admin.setLastname(rs2.getString("lastname"));
                    admin.setEmail(rs2.getString("email"));
                    status = "admin";
                    sa.setCurrentAdmin(admin);
                }

                if (!id.equals("")) {
                    if (status.equals("cust")) {
                        new ViewMenuCustomer();
                    } else {
                        new ViewMenuAdmin();
                    }
                    f.dispose();
                } else {
                    labError.setVisible(true);
                }
            } catch (SQLException except) {
                except.printStackTrace();
            }
            conn.disconnect();
        } else if (e.getSource() == register) {
            f.dispose();
            new ViewRegister();
        }
    }
}