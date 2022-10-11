package com.example.test1;

public class Sinhvien {
    private String malop,masv,tensv;
    private String diem,date;

    public Sinhvien() {
    }

    public Sinhvien(String malop, String masv, String tensv, String diem, String date) {
        this.malop = malop;
        this.masv = masv;
        this.tensv = tensv;
        this.diem = diem;
        this.date = date;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
