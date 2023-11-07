package com.example.se150408_phanvanphongnha_prm_pe;

import java.util.Date;

public class Sach {

    private int MaSach;
    private String TenSach;
    private String NgayXB;
    private String TheLoai;
    private int idTacGia;

    public Sach(int maSach, String tenSach, String ngayXB, String theLoai, int idTacGia) {
        MaSach = maSach;
        TenSach = tenSach;
        NgayXB = ngayXB;
        TheLoai = theLoai;
        this.idTacGia = idTacGia;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getNgayXB() {
        return NgayXB;
    }

    public void setNgayXB(String ngayXB) {
        NgayXB = ngayXB;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }
}
