package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "khoahocs")
public class KhoaHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "khoahocid")
    private int khoaHocId;

    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;

    @Column(name = "thoigianhoc")
    private int thoiGianHoc;

    @Column(name = "gioithieu")
    private String gioiThieu;

    @Column(name = "noiDung")
    private String noiDung;

    @Column(name = "hocphi")
    private int hocPhi;

    @Column(name = "sohocvien")
    private int soHocVien;

    @Column(name = "soluongmon")
    private int soLuongMon;

    @Column(name = "hinhanh")
    private String hinhAnh;

    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocId;

    @ManyToOne
    @JoinColumn(name = "loaikhoahocid" , insertable = false , updatable = false)
    @JsonBackReference
    private LoaiKhoaHoc loaiKhoaHoc;


    @OneToMany( fetch = FetchType.LAZY , mappedBy = "khoaHoc")
    @JsonIgnore
    private Set<DangKyHoc> dangKyHocs;


    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public int getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(int thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getSoHocVien() {
        return soHocVien;
    }

    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }

    public int getSoLuongMon() {
        return soLuongMon;
    }

    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getLoaiKhoaHocId() {
        return loaiKhoaHocId;
    }

    public void setLoaiKhoaHocId(int loaiKhoaHocId) {
        this.loaiKhoaHocId = loaiKhoaHocId;
    }

    public LoaiKhoaHoc getLoaiKhoaHoc() {
        return loaiKhoaHoc;
    }

    public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        this.loaiKhoaHoc = loaiKhoaHoc;
    }

    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
