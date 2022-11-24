package Controller;

import java.sql.SQLException;
import java.sql.Statement;

public class TableController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static void isOccupiedManipulation(String noTable) {
        conn.connect();
        String query = "UPDATE `table` SET isOccupied = '1' WHERE noTable = '" + noTable + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
