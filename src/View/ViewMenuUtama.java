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

/**
 *
 * @author calvin
 */
public class ViewMenuUtama extends JFrame implements ActionListener {

    ConnectDatabase conn = new ConnectDatabase();
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
        labError.setBounds(120, 60, 200, 20);

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

    public static void main(String[] args) {
        new ViewMenuUtama();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String searchUsername = username.getText();
            String searchPass = pass.getText();
            int id = 0;
            String query = "SELECT * FROM user WHERE username='" + searchUsername + "' AND password='" + searchPass
                    + "'";
            conn.connect();
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    id = rs.getInt("id");
                }
                if (id != 0) {
                    f.setVisible(false);
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