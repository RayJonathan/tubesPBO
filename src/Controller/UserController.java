package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserController {

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public void updateDB() {
        conn.connect();
        String path1 = "UPDATE customer";
        String path2 = "UPDATE admin";
        String query = " SET firstname = ?, lastname = ?, password = ? WHERE username = ?";
        if(){
            path1 += query;
            query = path1;
        } else {
            path2 += query;
            query = path2;
        }
        try{
            PreparedStatement stat = conn.con.prepareStatement(query);
            
            JOptionPane.showMessageDialog(null, "Berhasil update barang ke database");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error!! Gagal update barang ke database");
        }
        conn.disconnect();
    }
    
}
