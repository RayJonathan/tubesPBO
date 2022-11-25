package Controller;

import Models.Discount;

public class SingletonDiscount {

    private static SingletonDiscount instance;
    private Discount currentDiscount;

    public static SingletonDiscount getInstance() {
        if (instance == null) {
            instance = new SingletonDiscount();
        }
        return instance;
    }

    public Discount getcurrentDiscount() {
        return currentDiscount;
    }

    public void setcurrentDiscount(Discount currentDiscount) {
        this.currentDiscount = currentDiscount;
    }

}