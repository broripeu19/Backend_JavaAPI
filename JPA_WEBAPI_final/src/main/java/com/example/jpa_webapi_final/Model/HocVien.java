package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "hocviens")
public class HocVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienId;

    @Column(name = "hinhanh")
    private String hinhAnh;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Column(name = "sodienthoai")
    private int soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "tinhthanh")
    private String tinhThanh;

    @Column(name = "quanhuyen")
    private String quanHuyen;

    @Column(name = "phuongxa")
    private String phuongXa;

    @Column(name = "sonha")
    private int soNha;


    @OneToMany(fetch = FetchType.LAZY , mappedBy = "hocVien")
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;


    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public int getSoNha() {
        return soNha;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
