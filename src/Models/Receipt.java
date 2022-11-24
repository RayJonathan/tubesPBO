package Models;

import java.sql.Date;

public class Receipt {
    String idReceipt;
    String idReservation;
    String idCust;
    Date date;

    public Receipt() {

    }

    public Receipt(String idReceipt, String idReservation, String idCust, Date date) {
        this.idReceipt = idReceipt;
        this.idReservation = idReservation;
        this.idCust = idCust;
        this.date = date;
    }

    public String getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getidReservation() {
        return idReservation;
    }

    public void setidReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
//