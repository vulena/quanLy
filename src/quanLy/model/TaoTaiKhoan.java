/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.model;

/**
 *
 * @author ASUS
 */
public class TaoTaiKhoan {
    private String hoTen;
    private String tenTaiKhoan;
    private String email;
    private String matKhau;

    public TaoTaiKhoan() {
    }

    public TaoTaiKhoan(String hoTen, String tenTaiKhoan, String email, String matKhau) {
        this.hoTen = hoTen;
        this.tenTaiKhoan = tenTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
}
