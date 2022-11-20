package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Reservation {
    private int idReservation;
    private Room room;
    private int pilihanIdCabang;
    private String pilihanJenisRoom;
    private ArrayList<Extra> extra;
    private Date tanggalCheckIn;
    private Date tanngalCheckOut;
    private int berapaOrang;
    private double totalBayar;

    public Reservation(int idReservation, Room room, int pilihanIdCabang, String pilihanJenisRoom,
            ArrayList<Extra> extra, Date tanggalCheckIn, Date tanngalCheckOut, int berapaOrang, double totalBayar) {
        this.idReservation = idReservation;
        this.room = room;
        this.pilihanIdCabang = pilihanIdCabang;
        this.pilihanJenisRoom = pilihanJenisRoom;
        this.extra = extra;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanngalCheckOut = tanngalCheckOut;
        this.berapaOrang = berapaOrang;
        this.totalBayar = totalBayar;
    }

    public int getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public int getPilihanIdCabang() {
        return pilihanIdCabang;
    }
    public void setPilihanIdCabang(int pilihanIdCabang) {
        this.pilihanIdCabang = pilihanIdCabang;
    }
    public String getPilihanJenisRoom() {
        return pilihanJenisRoom;
    }
    public void setPilihanJenisRoom(String pilihanJenisRoom) {
        this.pilihanJenisRoom = pilihanJenisRoom;
    }
    public ArrayList<Extra> getExtra() {
        return extra;
    }
    public void setExtra(ArrayList<Extra> extra) {
        this.extra = extra;
    }
    public Date getTanggalCheckIn() {
        return tanggalCheckIn;
    }
    public void setTanggalCheckIn(Date tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }
    public Date getTanngalCheckOut() {
        return tanngalCheckOut;
    }
    public void setTanngalCheckOut(Date tanngalCheckOut) {
        this.tanngalCheckOut = tanngalCheckOut;
    }
    public int getBerapaOrang() {
        return berapaOrang;
    }
    public void setBerapaOrang(int berapaOrang) {
        this.berapaOrang = berapaOrang;
    }
    public double getTotalBayar() {
        return totalBayar;
    }
    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public void hitungTotalBayar() {}
}
