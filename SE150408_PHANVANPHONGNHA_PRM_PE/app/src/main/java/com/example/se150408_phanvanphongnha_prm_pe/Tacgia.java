package com.example.se150408_phanvanphongnha_prm_pe;

public class Tacgia {

    private int Id;
    private String TenTacGia;
    private String DiaChi;
    private String DienThoai;

    public Tacgia(int id, String tenTacGia, String diaChi, String dienThoai) {
        Id = id;
        TenTacGia = tenTacGia;
        DiaChi = diaChi;
        DienThoai = dienThoai;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }
}
