package Models;

public class Reservation {
    String idReservation;
    String idTable;
    String idCustomer;
    public Reservation(){
        
    }
    public Reservation(String idReservation, String idTable, String idCustomer) {
        this.idReservation = idReservation;
        this.idTable = idTable;
        this.idCustomer = idCustomer;
    }
    public String getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }
    public String getIdTable() {
        return idTable;
    }
    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }
    public String getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    
}