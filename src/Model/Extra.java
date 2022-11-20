package Model;

public class Extra {
    private int idExtra;
    private int idCabang;
    private String namaExtra;
    private int hargaExtra;
    
    public Extra(int idExtra, int idCabang, String namaExtra, int hargaExtra) {
        this.idExtra = idExtra;
        this.idCabang = idCabang;
        this.namaExtra = namaExtra;
        this.hargaExtra = hargaExtra;
    }

    public int getIdExtra() {
        return idExtra;
    }
    public void setIdExtra(int idExtra) {
        this.idExtra = idExtra;
    }
    public int getIdCabang() {
        return idCabang;
    }
    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }
    public String getNamaExtra() {
        return namaExtra;
    }
    public void setNamaExtra(String namaExtra) {
        this.namaExtra = namaExtra;
    }
    public int getHargaExtra() {
        return hargaExtra;
    }
    public void setHargaExtra(int hargaExtra) {
        this.hargaExtra = hargaExtra;
    }
}
