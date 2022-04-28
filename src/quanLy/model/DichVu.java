/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.model;

/**
 *
 * @author ASUS
 */
public class DichVu {
    private String maDV;
    private String tenDV;
    private Double giaDV;

    public DichVu() {
    }

    public DichVu(String maDV, String tenDV, Double giaDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(Double giaDV) {
        this.giaDV = giaDV;
    }
    
    
}
