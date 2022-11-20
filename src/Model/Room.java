package Model;

import Model.InterfaceEnum.EnumRoom;

public class Room {
    private String idRoom;
    private int idCabang;
    private int idJenisRoom;
    private int nomorRoom;
    private EnumRoom statusOccupied;

    public Room(String idRoom, int idCabang, int idJenisRoom, int nomorRoom, EnumRoom statusOccupied) {
        this.idRoom = idRoom;
        this.idCabang = idCabang;
        this.idJenisRoom = idJenisRoom;
        this.nomorRoom = nomorRoom;
        this.statusOccupied = statusOccupied;
    }

    public String getIdRoom() {
        return idRoom;
    }
    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }
    public int getIdCabang() {
        return idCabang;
    }
    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }
    public int getIdJenisRoom() {
        return idJenisRoom;
    }
    public void setIdJenisRoom(int idJenisRoom) {
        this.idJenisRoom = idJenisRoom;
    }
    public int getNomorRoom() {
        return nomorRoom;
    }
    public void setNomorRoom(int nomorRoom) {
        this.nomorRoom = nomorRoom;
    }
    public EnumRoom getStatusOccupied() {
        return statusOccupied;
    }
    public void setStatusOccupied(EnumRoom statusOccupied) {
        this.statusOccupied = statusOccupied;
    }
}
