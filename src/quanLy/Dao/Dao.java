/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
public class Dao {
    public int kiemTraTaiKhoan(String tenTaiKhoan,String matKhau) throws SQLException{
        Connection connection = ConnectionJDBC.Connect_JDBC();
            String sql = "select * from DangKy_DangNhap Where taiKhoan = ? and matKhau = ?";
            try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,tenTaiKhoan);
            ps.setString(2,matKhau);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                return 1;   
            }
            }catch(Exception e){
            }
        return 0;
    }
    public void themTaiKhoan(TaoTaiKhoan taoTaiKhoan){
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "insert into DangKy_DangNhap values(?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,taoTaiKhoan.getHoTen());
            ps.setString(2, taoTaiKhoan.getTenTaiKhoan());
            ps.setString(3, taoTaiKhoan.getMatKhau());
            ps.setString(4, taoTaiKhoan.getEmail());
            int rs = ps.executeUpdate();
        }catch(SQLException b ){
            b.printStackTrace();
        } 
     }
    public List<NhanVien> getTableNhanVien(){
        List<NhanVien> nhanVien = new ArrayList<>();
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "Select * from NHANVIEN";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    NhanVien nhanViens = new NhanVien();
                    nhanViens.setMaNV(rs.getString(1));
                    nhanViens.setTenNV(rs.getString(2));
                    nhanViens.setChucVu(rs.getString(3));
                    nhanViens.setLuong(rs.getDouble(4));
                    nhanViens.setNgaySinh(rs.getString(5));
                    nhanViens.setGioiTinh(rs.getString(6));
                   nhanVien.add(nhanViens);
        }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return nhanVien;
    }
    public List<KhachHang> getTableKhachHang(){
        List<KhachHang> khachHang = new ArrayList<>();
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "Select * from KHACHHANG";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    KhachHang khachHangs = new KhachHang();
                    khachHangs.setMaKH(rs.getString(1));
                    khachHangs.setTenKH(rs.getString(2));
                    khachHangs.setCmnd(rs.getString(3));
                    khachHangs.setQuocTich(rs.getString(4));
                    khachHangs.setGioiTinh(rs.getString(5));
                    khachHangs.setTuoi(rs.getInt(6));
                    khachHangs.setSoDienThoai(rs.getString(7));
                    khachHangs.setMaPhong(rs.getString(8));
                    khachHang.add(khachHangs);
        }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return khachHang;
    }
    public List<Phong> getTablePhong(){
        List<Phong> phong = new ArrayList<>();
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "Select * from PHONG";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    Phong phongs = new Phong();
                    phongs.setMaPhong(rs.getString(1));
                    phongs.setTenPhong(rs.getString(2));
                    phongs.setLoaiPhong(rs.getString(3));
                    phongs.setGiaPhong(rs.getDouble(4));
                    phongs.setTinhTrang(rs.getString(5));
                    phongs.setMaNV(rs.getString(6));
                    phongs.setMaDV(rs.getString(7));
                  
                    phong.add(phongs);
        }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return phong;
    }
    public List<DichVu> getTableLDichVu(){
        List<DichVu> dichVu = new ArrayList<>();
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "Select * from DICHVU";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    DichVu dichVus = new DichVu();
                    dichVus.setMaDV(rs.getString(1));
                    dichVus.setTenDV(rs.getString(2));
                    dichVus.setGiaDV(rs.getDouble(3));
                  
                    dichVu.add(dichVus);
        }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return dichVu;
    }
    public List<HoaDon> getTableHoaDon(){
        List<HoaDon> hoaDon = new ArrayList<>();
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "Select * from HOADON";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    HoaDon hoaDons = new HoaDon();
                    hoaDons.setMaHD(rs.getString(1));
                    hoaDons.setMaNV(rs.getString(2));
                    hoaDons.setMaPhong(rs.getString(3));
                    hoaDons.setMaKH(rs.getString(4));
                    hoaDons.setNgayHD(rs.getString(5));
                    hoaDons.setMaDV(rs.getString(6));
                    hoaDons.setGiaHD(rs.getDouble(7));
                    hoaDon.add(hoaDons);
        }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return hoaDon;
    }
    
    public void xoaNV(String maNVS){
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "delete from NHANVIEN where maNV = ?" ;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maNVS);
            int rs = preparedStatement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void themNhanvien(NhanVien nhanVien){
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "insert into NHANVIEN values(?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getTenNV());
            preparedStatement.setString(3, nhanVien.getChucVu());
            preparedStatement.setDouble(4, nhanVien.getLuong());
            preparedStatement.setString(5, nhanVien.getNgaySinh());
            preparedStatement.setString(6, nhanVien.getGioiTinh());
            int rs = preparedStatement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public NhanVien getmaNhanVien(String maNV){
        Connection connection = ConnectionJDBC.Connect_JDBC();
        String sql = "select * from NHANVIEN where maNV = ?" ;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,maNV);
            ResultSet rs = preparedStatement.executeQuery();
               while(rs.next()){
                    NhanVien nhanViens = new NhanVien();
                    nhanViens.setMaNV(rs.getString(1));
                    nhanViens.setTenNV(rs.getString(2));
                    nhanViens.setChucVu(rs.getString(3));
                    nhanViens.setLuong(rs.getDouble(4));
                    nhanViens.setNgaySinh(rs.getString(5));
                    nhanViens.setGioiTinh(rs.getString(6));
                   return nhanViens;
               }
        }catch(SQLException ex){
                ex.printStackTrace();
                }
        return null;
        }
    
}
