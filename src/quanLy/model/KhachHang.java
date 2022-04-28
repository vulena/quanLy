/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.model;


public class KhachHang {
    private String maKH;
    private String tenKH;
    private String cmnd;
    private String quocTich;
    private String gioiTinh;
    private int tuoi;
    private String soDienThoai;
    private String maPhong;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String cmnd, String quocTich, String gioiTinh, int tuoi, String soDienThoai, String maPhong) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.cmnd = cmnd;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.soDienThoai = soDienThoai;
        this.maPhong = maPhong;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    
}
