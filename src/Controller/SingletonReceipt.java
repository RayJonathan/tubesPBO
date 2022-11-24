package Controller;

import Models.Receipt;

public class SingletonReceipt {

    private static SingletonReceipt instance;
    private Receipt currentReceipt;

    public static SingletonReceipt getInstance() {
        if (instance == null) {
            instance = new SingletonReceipt();
        }
        return instance;
    }

    public Receipt getCurrentReceipt() {
        return currentReceipt;
    }

    public void setCurrentReceipt(Receipt currentReceipt) {
        this.currentReceipt = currentReceipt;
    }

}//