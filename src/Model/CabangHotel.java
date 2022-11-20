package Model;

import java.util.ArrayList;

public class CabangHotel {
    private int idCabang;
    private String lokasiCabang;
    private String alamatCabang;
    private ArrayList<Room> listRoom;
    
    public CabangHotel(int idCabang, String lokasiCabang, String alamatCabang, ArrayList<Room> listRoom) {
        this.idCabang = idCabang;
        this.lokasiCabang = lokasiCabang;
        this.alamatCabang = alamatCabang;
        this.listRoom = listRoom;
    }

    public int getIdCabang() {
        return idCabang;
    }
    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }
    public String getLokasiCabang() {
        return lokasiCabang;
    }
    public void setLokasiCabang(String lokasiCabang) {
        this.lokasiCabang = lokasiCabang;
    }
    public String getAlamatCabang() {
        return alamatCabang;
    }
    public void setAlamatCabang(String alamatCabang) {
        this.alamatCabang = alamatCabang;
    }
    public ArrayList<Room> getListRoom() {
        return listRoom;
    }
    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }
}
