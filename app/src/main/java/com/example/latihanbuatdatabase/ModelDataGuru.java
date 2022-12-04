package com.example.latihanbuatdatabase;

public class ModelDataGuru {
    String nip;
    String nama;
    String status;
    String alamat;
    String kota;

    public ModelDataGuru(String nip, String nama, String status, String alamat, String kota){
        this.nip = nip;
        this.nama = nama;
        this.status = status;
        this.alamat = alamat;
        this.kota = kota;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setSyarat(String kota) {
        this.kota = kota;
    }
}
