package Controller;

import Models.Reservation;

public class SingletonReservation {

    private static SingletonReservation instance;
    private Reservation currentReservation;

    public static SingletonReservation getInstance() {
        if (instance == null) {
            instance = new SingletonReservation();
        }
        return instance;
    }

    public Reservation getCurrentResarvation() {
        return currentReservation;
    }

    public void setcurrentReservation(Reservation currentReservation) {
        this.currentReservation = currentReservation;
    }

}//