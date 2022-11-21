package Controller;

public class SingletonDatabase {
    private static ConnectDatabase conn;
    public static ConnectDatabase getConnectObject(){
        if (conn == null) {
            conn = new ConnectDatabase();
        }
        return conn;
    }
}

