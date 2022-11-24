package Controller;

import java.sql.SQLException;
import java.sql.Statement;

public class TableController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static void isOccupiedManipulation(String noTable) {
        conn.connect();
        String query = "UPDATE table set isOccupied = '1' WHERE id_table = '" + noTable + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
