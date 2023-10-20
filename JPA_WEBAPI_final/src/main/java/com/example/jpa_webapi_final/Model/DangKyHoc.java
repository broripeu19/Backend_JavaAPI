package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dangkyhocs")
public class DangKyHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "dangkyhocid")
    private int dangKyHocId;

    @Column(name = "khoahocid")
    private int khoaHocId;

    @Column(name = "hocvienid")
    private int hocVienId;

    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;

    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;

    @Column(name = "tinhtranghocid")
    private int tinhTrangHocId;

    @Column(name = "taikhoanid")
    private int taiKhoanId;

    @ManyToOne
    @JoinColumn(name = "khoahocid" , insertable = false , updatable = false)
    @JsonIgnore
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "hocvienid" , insertable = false , updatable = false)
    @JsonIgnore
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "tinhtranghocid" , insertable = false , updatable = false)
    @JsonIgnore
    private TinhTrangHoc tinhTrangHoc;

    @ManyToOne
    @JoinColumn(name = "taikhoanid" , insertable = false , updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;


    public int getDangKyHocId() {
        return dangKyHocId;
    }

    public void setDangKyHocId(int dangKyHocId) {
        this.dangKyHocId = dangKyHocId;
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTinhTrangHocId() {
        return tinhTrangHocId;
    }

    public void setTinhTrangHocId(int tinhTrangHocId) {
        this.tinhTrangHocId = tinhTrangHocId;
    }

    public int getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(int taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
