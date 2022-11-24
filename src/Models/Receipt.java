package Models;

import java.sql.Date;

public class Receipt {
    String idReceipt;
    String idTable;
    String idCust;
    Date date;

    public Receipt() {

    }

    public Receipt(String idReceipt, String idTable, String idCust, Date date) {
        this.idReceipt = idReceipt;
        this.idTable = idTable;
        this.idCust = idCust;
        this.date = date;
    }

    public String getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
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