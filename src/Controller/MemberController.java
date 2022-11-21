package Controller;

import java.sql.SQLException;
import java.sql.Statement;

public class MemberController {
    public static String joinMember(String user) {
        ConnectDatabase conn = new ConnectDatabase();
        conn.connect();
        String output = "";
        String query = "UPDATE customer SET isMember ='" + 1 + "'";
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