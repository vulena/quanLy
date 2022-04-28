/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.model;

/**
 *
 * @author ASUS
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String maPhong;
    private String maKH;
    private String ngayHD;
    private String maDV;
    private Double giaHD;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String maPhong, String maKH, String ngayHD, String maDV, Double giaHD) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maPhong = maPhong;
        this.maKH = maKH;
        this.ngayHD = ngayHD;
        this.maDV = maDV;
        this.giaHD = giaHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public Double getGiaHD() {
        return giaHD;
    }

    public void setGiaHD(Double giaHD) {
        this.giaHD = giaHD;
    }
    
    
    
}
