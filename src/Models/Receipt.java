package Models;
import java.sql.Date;

public class Receipt {
    String idReceipt;
    String idReservation;
    Date date;
    
    public Receipt(String idReceipt, String idReservation, Date date) {
        this.idReceipt = idReceipt;
        this.idReservation = idReservation;
        this.date = date;
    }

    public String getIdReceipt() {
        return idReceipt;
    }
    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }
    public String getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
