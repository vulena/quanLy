/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.service;

import java.sql.SQLException;
import java.util.List;
import quanLy.Dao.Dao;
import quanLy.model.DichVu;
import quanLy.model.HoaDon;
import quanLy.model.KhachHang;
import quanLy.model.NhanVien;
import quanLy.model.Phong;
import quanLy.model.TaoTaiKhoan;

/**
 *
 * @author ASUS
 */
public class Service {
    private Dao dao ;

    public Service() {
        this.dao =new Dao();
    }
    public int kiemTraTaiKhoan(String tenTaiKhoan,String matKhau) throws SQLException{
        return dao.kiemTraTaiKhoan(tenTaiKhoan, matKhau);
    }
    public void themTaiKhoan(TaoTaiKhoan taoTaiKhoan){
        dao.themTaiKhoan(taoTaiKhoan);
    }
    public List<NhanVien> getTableNhanVien(){
        return dao.getTableNhanVien();
    }
    public List<KhachHang> getTableKhachHang(){
        return dao.getTableKhachHang();
    }
    public List<Phong> getTablePhong(){
        return dao.getTablePhong();
    }
    public List<DichVu> getTableLDichVu(){
        return dao.getTableLDichVu();
    }
    public List<HoaDon> getTableHoaDon(){
        return dao.getTableHoaDon();
    }
    public void xoaNV(String maNV){
        dao.xoaNV(maNV);
    }
    public void themNhanvien(NhanVien nhanVien){
        dao.themNhanvien(nhanVien);
    }
    public NhanVien getmaNhanVien(String maNV){
        return dao.getmaNhanVien(maNV);
    }
}
