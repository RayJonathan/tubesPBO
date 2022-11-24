package Controller;

import Models.Customer;

public class SingletonCustomer {

    private static SingletonCustomer instance;
    private Customer currentCustomer;

    public static SingletonCustomer getInstance() {
        if (instance == null) {
            instance = new SingletonCustomer();
        }
        return instance;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

}