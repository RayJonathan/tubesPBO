package Models;
public class QueueTable {
    private int idQueue;
    private String idCust;
    private int jumlahOrang;
    
    public QueueTable(int idQueue, String idCust, int jumlahOrang) {
        this.idQueue = idQueue;
        this.idCust = idCust;
        this.jumlahOrang = jumlahOrang;
    }

    public int getIdQueue() {
        return idQueue;
    }

    public void setIdQueue(int idQueue) {
        this.idQueue = idQueue;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }
}
