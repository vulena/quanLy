/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanLy.view;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import quanLy.model.DichVu;
import quanLy.model.HoaDon;
import quanLy.model.KhachHang;
import quanLy.model.NhanVien;
import quanLy.model.Phong;
import quanLy.service.Service;


public class TrangChuQuanLy extends javax.swing.JFrame {
    private List<JPanel> luaChon = new ArrayList<>();
    private List<JLabel> mau = new ArrayList<>();
    private Service service ;
    DefaultTableModel defaultTableModel;
    public TrangChuQuanLy() {
        initComponents();
        setLocationRelativeTo(null);
        createPanel();
        listLable(0);
        domau();
        listmau(0);
        
        //--------------------Nhan Vien------------------------//
        String[] columsNhanVien = {"Mã nhân viên", "Họ tên","Chức vụ","Lương","Ngày sinh", "Giới tính"};
        defaultTableModel = new DefaultTableModel(columsNhanVien,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        
        };
        tbNhanVien.setModel(defaultTableModel);
        service = new Service();
        setTableDataNhanVien(service.getTableNhanVien());
        
        //--------------------Khach Hang------------------------//
        String[] columsKhachHang = {"Mã khách hàng", "Họ tên","Cmnd","Quốc tịch","Giới tính", "Tuổi","Số điện thoại","Mã phòng"};
        defaultTableModel = new DefaultTableModel(columsKhachHang,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        
        };
        tbKhachHang.setModel(defaultTableModel);
        service = new Service();
        setTableDataKhachHang(service.getTableKhachHang());
        
        //--------------------Phong------------------------//
        String[] columsPhong = {"Mã phòng", "Tên phòng","Loại Phòng","Giá phòng","Tình trạng", "Mã nhân viên","Mã dịch vụ"};
        defaultTableModel = new DefaultTableModel(columsPhong,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        
        };
        tbPhong.setModel(defaultTableModel);
        service = new Service();
        setTableDataPhong(service.getTablePhong());
        
        //--------------------Phong------------------------//
        String[] columsDichVu = {"Mã dịch vụ", "Tên dịch vụ","Giá dịch Vụ"};
        defaultTableModel = new DefaultTableModel(columsDichVu,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        
        };
        tbDichVu.setModel(defaultTableModel);
        service = new Service();
        setTableDataDichVu(service.getTableLDichVu());
        
        //--------------------Hoa Don------------------------//
        String[] columsHoaDon = {"Mã hoá đơn", "Mã nhân viên","Mã phòng","Mã khách hàng","Ngay hoa don","Mã dịch vụ","Gia Hoa Don"};
        defaultTableModel = new DefaultTableModel(columsHoaDon,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        
        };
        tbHoaDon.setModel(defaultTableModel);
        service = new Service();
        setTableDataHoaDon(service.getTableHoaDon());
        
        
        
        
    }
    public void setTableDataNhanVien(List<NhanVien> nhanVien){
        for(NhanVien nv : nhanVien){
            defaultTableModel.addRow(new Object[]{nv.getMaNV(),nv.getTenNV(),nv.getChucVu(),nv.getLuong(),nv.getNgaySinh(),nv.getGioiTinh()});
        }
    }
    public void setTableDataKhachHang(List<KhachHang> khachHangs){
        for(KhachHang kh : khachHangs){
            defaultTableModel.addRow(new Object[]{kh.getMaKH(),kh.getTenKH(),kh.getCmnd(),kh.getQuocTich(),kh.getGioiTinh(),kh.getTuoi(),kh.getSoDienThoai(),kh.getMaPhong()});
        }
    }
    
    public void setTableDataPhong(List<Phong> phongs){
        for(Phong ph : phongs){
            defaultTableModel.addRow(new Object[]{ph.getMaPhong(),ph.getTenPhong(),ph.getLoaiPhong(),ph.getGiaPhong(),ph.getTinhTrang(),ph.getMaNV(),ph.getMaDV()});
        }
    }
    
    public void setTableDataDichVu(List<DichVu> dichVus){
        for(DichVu dv : dichVus){
            defaultTableModel.addRow(new Object[]{dv.getMaDV(),dv.getTenDV(),dv.getGiaDV()});
        }
    }
    
    public void setTableDataHoaDon(List<HoaDon> hoaDon){
        for(HoaDon hd : hoaDon){
            defaultTableModel.addRow(new Object[]{hd.getMaHD(),hd.getMaNV(),hd.getMaPhong(),hd.getMaKH(),hd.getNgayHD(),hd.getMaDV(),hd.getGiaHD()});
        }
    }
    public void createPanel(){
        luaChon.add(jpn_NhanVien);
        luaChon.add(jpnQL_KhachHang);
        luaChon.add(jpnQL_Phong);
        luaChon.add(jpnQL_DichVu);
        luaChon.add(jpnQL_HoaDon);
        listLable(0);
    }
    public void domau(){
        mau.add(jlbQL_NhanVien);
        mau.add(jlb_KhachHang);
        mau.add(jlb_Phong);
        mau.add(jlb_DichVu);
        mau.add(jlb_HoaDon);
        listmau(0);
        
    }
    public void listLable(int x){
        
        for(int i = 0; i<luaChon.size();i++){
            if(i==x){
                luaChon.get(i).setVisible(true);
            }
            else
                luaChon.get(i).setVisible(false);
        }
    }
    public void listmau(int x){
        
        for(int i = 0; i<mau.size();i++){
            if(i==x){
                mau.get(i).setBackground(Color.yellow);
            }
            else
                mau.get(i).setBackground(Color.gray);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpnDieuKhien = new javax.swing.JPanel();
        jlbQL_NhanVien = new javax.swing.JLabel();
        jlb_KhachHang = new javax.swing.JLabel();
        jlb_Phong = new javax.swing.JLabel();
        jlb_DichVu = new javax.swing.JLabel();
        jlb_HoaDon = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jpn_NhanVien = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfMaNV = new javax.swing.JTextField();
        jtfHoTenNV = new javax.swing.JTextField();
        jtfChuVuNV = new javax.swing.JTextField();
        jtfLuongNV = new javax.swing.JTextField();
        jbtThemNV = new javax.swing.JButton();
        jbtXoaNV = new javax.swing.JButton();
        jtfSuaNV = new javax.swing.JButton();
        jbtMoiNV = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfNSNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdNamNV = new javax.swing.JRadioButton();
        nuNuNV = new javax.swing.JRadioButton();
        jpnQL_KhachHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jpnQL_Phong = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfMaPhong = new javax.swing.JTextField();
        jtfTenPhong = new javax.swing.JTextField();
        jtfGiaPhong = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jtfMaNhanVien = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jtfMaDichVu = new javax.swing.JTextField();
        jrbDangThue = new javax.swing.JRadioButton();
        jrbVIP = new javax.swing.JRadioButton();
        jrbTrong = new javax.swing.JRadioButton();
        jrbThuong = new javax.swing.JRadioButton();
        jtfTimKiem = new javax.swing.JTextField();
        bntTimKiem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpnQL_DichVu = new javax.swing.JPanel();
        btnXoaDV = new javax.swing.JPanel();
        btnSuaDV = new javax.swing.JButton();
        jtfGiaDV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnMoiDV = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        btnThemDV = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jtfMDV = new javax.swing.JTextField();
        jtfTenDV = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jtfTimKiemDV = new javax.swing.JTextField();
        btnTimKiemDV = new javax.swing.JLabel();
        jpnQL_HoaDon = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField20 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel5.setBackground(new java.awt.Color(255, 255, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/hotel.png"))); // NOI18N
        jLabel5.setText("QUẢN LÝ KHÁCH SẠN");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnDieuKhien.setBackground(new java.awt.Color(255, 255, 204));

        jlbQL_NhanVien.setBackground(new java.awt.Color(255, 153, 153));
        jlbQL_NhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbQL_NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQL_NhanVien.setText("QUẢN LÝ NHÂN VIÊN");
        jlbQL_NhanVien.setOpaque(true);
        jlbQL_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQL_NhanVienMouseClicked(evt);
            }
        });

        jlb_KhachHang.setBackground(new java.awt.Color(255, 153, 153));
        jlb_KhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlb_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_KhachHang.setText("QUẢN LÝ KHÁCH HÀNG");
        jlb_KhachHang.setOpaque(true);
        jlb_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_KhachHangMouseClicked(evt);
            }
        });

        jlb_Phong.setBackground(new java.awt.Color(255, 153, 153));
        jlb_Phong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlb_Phong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_Phong.setText("QUẢN LÝ PHÒNG");
        jlb_Phong.setOpaque(true);
        jlb_Phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_PhongMouseClicked(evt);
            }
        });

        jlb_DichVu.setBackground(new java.awt.Color(255, 153, 153));
        jlb_DichVu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlb_DichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_DichVu.setText("QUẢN LÝ DỊCH VỤ");
        jlb_DichVu.setOpaque(true);
        jlb_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_DichVuMouseClicked(evt);
            }
        });

        jlb_HoaDon.setBackground(new java.awt.Color(255, 153, 153));
        jlb_HoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlb_HoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_HoaDon.setText("QUẢN LÝ HOÁ ĐƠN");
        jlb_HoaDon.setOpaque(true);
        jlb_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_HoaDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnDieuKhienLayout = new javax.swing.GroupLayout(jpnDieuKhien);
        jpnDieuKhien.setLayout(jpnDieuKhienLayout);
        jpnDieuKhienLayout.setHorizontalGroup(
            jpnDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDieuKhienLayout.createSequentialGroup()
                .addGroup(jpnDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnDieuKhienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnDieuKhienLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpnDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbQL_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnDieuKhienLayout.setVerticalGroup(
            jpnDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDieuKhienLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQL_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlb_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlb_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlb_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnView.setLayout(new java.awt.CardLayout());

        jpn_NhanVien.setBackground(new java.awt.Color(204, 255, 204));

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mã nhân viên:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Họ và tên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Chức vụ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Lương");

        jtfMaNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfHoTenNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfChuVuNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfLuongNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jbtThemNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/add-file.png"))); // NOI18N
        jbtThemNV.setText("Thêm");
        jbtThemNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThemNVActionPerformed(evt);
            }
        });

        jbtXoaNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/delete.png"))); // NOI18N
        jbtXoaNV.setText("Xoá   ");
        jbtXoaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXoaNVActionPerformed(evt);
            }
        });

        jtfSuaNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/update1.png"))); // NOI18N
        jtfSuaNV.setText("Sửa ");
        jtfSuaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSuaNVActionPerformed(evt);
            }
        });

        jbtMoiNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtMoiNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/reset.png"))); // NOI18N
        jbtMoiNV.setText("Mới  ");
        jbtMoiNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtMoiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMoiNVActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ngày sinh");

        jtfNSNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Giới Tính");

        buttonGroup1.add(rdNamNV);
        rdNamNV.setSelected(true);
        rdNamNV.setText("Nam");

        buttonGroup1.add(nuNuNV);
        nuNuNV.setText("Nữ");

        javax.swing.GroupLayout jpn_NhanVienLayout = new javax.swing.GroupLayout(jpn_NhanVien);
        jpn_NhanVien.setLayout(jpn_NhanVienLayout);
        jpn_NhanVienLayout.setHorizontalGroup(
            jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jtfHoTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jtfLuongNV, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jtfChuVuNV, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jtfNSNV))
                        .addGap(134, 134, 134)
                        .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jbtXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jtfSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jbtMoiNV, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addGap(79, 79, 79))
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addComponent(rdNamNV, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(nuNuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpn_NhanVienLayout.setVerticalGroup(
            jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_NhanVienLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jbtThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jbtXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jtfSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfChuVuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtMoiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfNSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_NhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(15, 15, 15)
                .addGroup(jpn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdNamNV)
                    .addComponent(nuNuNV))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        jpnView.add(jpn_NhanVien, "card2");

        jpnQL_KhachHang.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbKhachHang);

        jTextField8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tên Khách Hàng ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Quốc Tịch ");

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/reset.png"))); // NOI18N
        jButton11.setText("Mới");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/delete.png"))); // NOI18N
        jButton12.setText("Xoá   ");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Mã Khách Hàng ");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/update1.png"))); // NOI18N
        jButton13.setText("Sửa ");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/add-file.png"))); // NOI18N
        jButton9.setText("Thêm");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Chứng Minh Nhân Dân");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Giới Tính");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tuổi");

        jTextField21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Số điện thoại");

        jTextField23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Mã Phòng");

        jTextField25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jTextField8)
                            .addComponent(jTextField7)
                            .addComponent(jTextField5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField21)
                            .addComponent(jTextField25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        jButton11.getAccessibleContext().setAccessibleName("Mới");

        javax.swing.GroupLayout jpnQL_KhachHangLayout = new javax.swing.GroupLayout(jpnQL_KhachHang);
        jpnQL_KhachHang.setLayout(jpnQL_KhachHangLayout);
        jpnQL_KhachHangLayout.setHorizontalGroup(
            jpnQL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnQL_KhachHangLayout.setVerticalGroup(
            jpnQL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnQL_KhachHang, "card3");

        jpnQL_Phong.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/update1.png"))); // NOI18N
        btnSua.setText("Sửa ");
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/add-file.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Mã Phòng");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Loại Phòng");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Giá Phòng");

        jtfMaPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfTenPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfGiaPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tên Phòng");

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/reset.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/delete.png"))); // NOI18N
        btnXoa.setText("Xoá   ");
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbPhong);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Tình Trạng");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Mã Nhân Viên");

        jtfMaNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Mã Dịch Vụ");

        jtfMaDichVu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        buttonGroup3.add(jrbDangThue);
        jrbDangThue.setSelected(true);
        jrbDangThue.setText("Đang Thuê");
        jrbDangThue.setActionCommand("");
        jrbDangThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDangThueActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbVIP);
        jrbVIP.setText("VIP");

        buttonGroup3.add(jrbTrong);
        jrbTrong.setText("Trống");
        jrbTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTrongActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbThuong);
        jrbThuong.setSelected(true);
        jrbThuong.setText("Thường ");
        jrbThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbThuongActionPerformed(evt);
            }
        });

        jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimKiemActionPerformed(evt);
            }
        });

        bntTimKiem.setBackground(new java.awt.Color(204, 255, 204));
        bntTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/search.png"))); // NOI18N
        bntTimKiem.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tìm Kiếm ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMaNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(jtfMaDichVu)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jrbDangThue)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrbTrong))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMaPhong)
                                    .addComponent(jtfTenPhong)
                                    .addComponent(jtfGiaPhong)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jrbThuong)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrbVIP))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(bntTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbVIP)
                            .addComponent(jrbThuong))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jrbDangThue)
                                .addComponent(jrbTrong)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTimKiem))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jpnQL_PhongLayout = new javax.swing.GroupLayout(jpnQL_Phong);
        jpnQL_Phong.setLayout(jpnQL_PhongLayout);
        jpnQL_PhongLayout.setHorizontalGroup(
            jpnQL_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnQL_PhongLayout.setVerticalGroup(
            jpnQL_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnQL_Phong, "card4");

        jpnQL_DichVu.setBackground(new java.awt.Color(255, 255, 255));

        btnXoaDV.setBackground(new java.awt.Color(204, 255, 204));

        btnSuaDV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/update1.png"))); // NOI18N
        btnSuaDV.setText("Sửa ");
        btnSuaDV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtfGiaDV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Mã Dịch Vụ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Tên Dịch Vụ");

        btnMoiDV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoiDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/reset.png"))); // NOI18N
        btnMoiDV.setText("Mới  ");
        btnMoiDV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/delete.png"))); // NOI18N
        jButton20.setText("Xoá   ");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThemDV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/add-file.png"))); // NOI18N
        btnThemDV.setText("Thêm");
        btnThemDV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Giá Dịch Vụ");

        jtfMDV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtfTenDV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tbDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbDichVu);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tìm Kiếm");

        btnTimKiemDV.setBackground(new java.awt.Color(255, 204, 204));
        btnTimKiemDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/search.png"))); // NOI18N
        btnTimKiemDV.setOpaque(true);

        javax.swing.GroupLayout btnXoaDVLayout = new javax.swing.GroupLayout(btnXoaDV);
        btnXoaDV.setLayout(btnXoaDVLayout);
        btnXoaDVLayout.setHorizontalGroup(
            btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(btnXoaDVLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnXoaDVLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTimKiemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(btnXoaDVLayout.createSequentialGroup()
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMDV, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jtfTenDV, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jtfGiaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                        .addGap(116, 116, 116)
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMoiDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnThemDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        btnXoaDVLayout.setVerticalGroup(
            btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXoaDVLayout.createSequentialGroup()
                .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnXoaDVLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnThemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnSuaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btnXoaDVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfTimKiemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMDV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(btnXoaDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addComponent(btnMoiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnQL_DichVuLayout = new javax.swing.GroupLayout(jpnQL_DichVu);
        jpnQL_DichVu.setLayout(jpnQL_DichVuLayout);
        jpnQL_DichVuLayout.setHorizontalGroup(
            jpnQL_DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnQL_DichVuLayout.setVerticalGroup(
            jpnQL_DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnQL_DichVu, "card5");

        jpnQL_HoaDon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/add-file.png"))); // NOI18N
        jButton23.setText("Thêm");
        jButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jTextField17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Mã Phòng");

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/reset.png"))); // NOI18N
        jButton22.setText("Mới");
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Mã Khách Hàng");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Mã Hoá Đơn");

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/delete.png"))); // NOI18N
        jButton24.setText("Xoá   ");
        jButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Mã Nhân Viên");

        jButton25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanLy/image/update1.png"))); // NOI18N
        jButton25.setText("Sửa ");
        jButton25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbHoaDon);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Ngày");

        jTextField29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Mã Dịch vụ");

        jTextField30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Thành Tiền");

        jTextField31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField20)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField31, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField29, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jpnQL_HoaDonLayout = new javax.swing.GroupLayout(jpnQL_HoaDon);
        jpnQL_HoaDon.setLayout(jpnQL_HoaDonLayout);
        jpnQL_HoaDonLayout.setHorizontalGroup(
            jpnQL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnQL_HoaDonLayout.setVerticalGroup(
            jpnQL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnQL_HoaDon, "card6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnDieuKhien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDieuKhien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbQL_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQL_NhanVienMouseClicked
        listLable(0);
        listmau(0);
    }//GEN-LAST:event_jlbQL_NhanVienMouseClicked

    private void jlb_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_KhachHangMouseClicked
        listLable(1);
        listmau(1);
    }//GEN-LAST:event_jlb_KhachHangMouseClicked

    private void jlb_PhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_PhongMouseClicked
        listLable(2);
        listmau(2);
    }//GEN-LAST:event_jlb_PhongMouseClicked

    private void jlb_DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_DichVuMouseClicked
        listLable(3);
        listmau(3);
    }//GEN-LAST:event_jlb_DichVuMouseClicked

    private void jlb_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_HoaDonMouseClicked
        listLable(4);
        listmau(4);
    }//GEN-LAST:event_jlb_HoaDonMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jrbDangThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDangThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbDangThueActionPerformed

    private void jrbTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbTrongActionPerformed

    private void jrbThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbThuongActionPerformed

    private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimKiemActionPerformed

    private void jbtXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXoaNVActionPerformed
        service = new Service();
        int row = tbNhanVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào trong bảng!","Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int a =  JOptionPane.showConfirmDialog(this,"Ban có chắc muốn xoá không?");
            if(a == JOptionPane.YES_OPTION){
                String maNV = (String)tbNhanVien.getValueAt(row, 0);
                service.xoaNV(maNV);
                defaultTableModel.setRowCount(0);
                List<NhanVien> nhanViens = service.getTableNhanVien();
                for(NhanVien nv : nhanViens){
                    defaultTableModel.addRow(new Object[]{nv.getMaNV(),nv.getTenNV(),nv.getChucVu(),nv.getLuong(),nv.getNgaySinh(),nv.getGioiTinh()});
    }
            }
        }
        
    }//GEN-LAST:event_jbtXoaNVActionPerformed

    private void jbtMoiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMoiNVActionPerformed
           jtfMaNV.setText("");
           jtfMaNhanVien.setText("");
           jtfHoTenNV.setText("");
           jtfChuVuNV.setText("");
           jtfLuongNV.setText("");
           jtfNSNV.setText("");
           rdNamNV.isSelected();
           
    }//GEN-LAST:event_jbtMoiNVActionPerformed

    private void jbtThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThemNVActionPerformed
        NhanVien nhanVien  = new NhanVien();
        nhanVien.setMaNV(jtfMaNV.getText());
        nhanVien.setTenNV(jtfHoTenNV.getText());
        nhanVien.setChucVu(jtfChuVuNV.getText());
        nhanVien.setLuong(Double.parseDouble(jtfLuongNV.getText()));
        nhanVien.setNgaySinh(jtfNSNV.getText());
        String gioiTinh = "";
        if(rdNamNV.isSelected())
            gioiTinh = "Nam";
        else
            gioiTinh = "Nu";
        
        nhanVien.setGioiTinh(gioiTinh);
        service = new Service();
        service.themNhanvien(nhanVien);
        List<NhanVien> nhanViens = service.getTableNhanVien();
        defaultTableModel.setRowCount(0);
        for(NhanVien nv : nhanViens){
            defaultTableModel.addRow(new Object[]{nv.getMaNV(),nv.getTenNV(),nv.getChucVu(),nv.getLuong(),nv.getNgaySinh(),nv.getGioiTinh()});
    }
        JOptionPane.showMessageDialog(this, "Them thanh cong");
    }//GEN-LAST:event_jbtThemNVActionPerformed

    private void tbNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMousePressed
        
    }//GEN-LAST:event_tbNhanVienMousePressed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int row = tbNhanVien.getSelectedRow();
        service = new Service();
        String maNV = (String) tbNhanVien.getValueAt(row, 0);
        System.out.println(maNV);
        suaNhanVien(maNV);
        setTableDataNhanVien(service.getTableNhanVien());
        
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void jtfSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSuaNVActionPerformed
       
    }//GEN-LAST:event_jtfSuaNVActionPerformed
    public void suaNhanVien(String maNVs){
        NhanVien nhanVien = new NhanVien();
        service = new Service();
        nhanVien = service.getmaNhanVien(maNVs);
        jtfMaNV.setText(nhanVien.getMaNV());
        jtfHoTenNV.setText(nhanVien.getTenNV());
        jtfChuVuNV.setText(nhanVien.getChucVu());
        String a = String.valueOf(nhanVien.getLuong());
       
        jtfLuongNV.setText(a);
        jtfNSNV.setText(nhanVien.getNgaySinh());
        String b = nhanVien.getGioiTinh();
        if(b.equals("Nam"))
            rdNamNV.setSelected(true);
        else
            nuNuNV.setSelected(true);
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TrangChuQuanLy().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bntTimKiem;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMoiDV;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDV;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDV;
    private javax.swing.JLabel btnTimKiemDV;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel btnXoaDV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton jbtMoiNV;
    private javax.swing.JButton jbtThemNV;
    private javax.swing.JButton jbtXoaNV;
    private javax.swing.JLabel jlbQL_NhanVien;
    private javax.swing.JLabel jlb_DichVu;
    private javax.swing.JLabel jlb_HoaDon;
    private javax.swing.JLabel jlb_KhachHang;
    private javax.swing.JLabel jlb_Phong;
    private javax.swing.JPanel jpnDieuKhien;
    private javax.swing.JPanel jpnQL_DichVu;
    private javax.swing.JPanel jpnQL_HoaDon;
    private javax.swing.JPanel jpnQL_KhachHang;
    private javax.swing.JPanel jpnQL_Phong;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel jpn_NhanVien;
    private javax.swing.JRadioButton jrbDangThue;
    private javax.swing.JRadioButton jrbThuong;
    private javax.swing.JRadioButton jrbTrong;
    private javax.swing.JRadioButton jrbVIP;
    private javax.swing.JTextField jtfChuVuNV;
    private javax.swing.JTextField jtfGiaDV;
    private javax.swing.JTextField jtfGiaPhong;
    private javax.swing.JTextField jtfHoTenNV;
    private javax.swing.JTextField jtfLuongNV;
    private javax.swing.JTextField jtfMDV;
    private javax.swing.JTextField jtfMaDichVu;
    private javax.swing.JTextField jtfMaNV;
    private javax.swing.JTextField jtfMaNhanVien;
    private javax.swing.JTextField jtfMaPhong;
    private javax.swing.JTextField jtfNSNV;
    private javax.swing.JButton jtfSuaNV;
    private javax.swing.JTextField jtfTenDV;
    private javax.swing.JTextField jtfTenPhong;
    private javax.swing.JTextField jtfTimKiem;
    private javax.swing.JTextField jtfTimKiemDV;
    private javax.swing.JRadioButton nuNuNV;
    private javax.swing.JRadioButton rdNamNV;
    private javax.swing.JTable tbDichVu;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTable tbPhong;
    // End of variables declaration//GEN-END:variables
}
