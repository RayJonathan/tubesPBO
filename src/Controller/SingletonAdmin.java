package Controller;

import Models.Admin;


public class SingletonAdmin {

    private static SingletonAdmin instance;
    private Admin currentAdmin;

    public static SingletonAdmin getInstance() {
        if (instance == null) {
            instance = new SingletonAdmin();
        }
        return instance;
    }

    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public void setCurrentAdmin(Admin currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

}