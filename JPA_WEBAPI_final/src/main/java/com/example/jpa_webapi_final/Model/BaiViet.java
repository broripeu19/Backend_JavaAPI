package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "baiviets")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baiVietId;

    @Column(name = "tenbaiviet")
    private String tenBaiViet;

    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;


    @Column(name = "tentacgia")
    private String tenTacGia;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "noidungngan")
    private String noiDungNgan;

    @Column(name = "chudeid")
    private int chuDeId;

    @Column(name = "taikhoanid")
    private int taiKhoanId;

    @ManyToOne
    @JoinColumn(name = "chudeid" , insertable = false ,updatable = false)
    @JsonIgnore
    private ChuDe chuDe;

    @ManyToOne
    @JoinColumn(name = "taikhoanid" , insertable = false ,updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;

    public int getBaiVietId() {
        return baiVietId;
    }

    public void setBaiVietId(int baiVietId) {
        this.baiVietId = baiVietId;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public LocalDate getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDate thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungNgan() {
        return noiDungNgan;
    }

    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }

    public int getChuDeId() {
        return chuDeId;
    }

    public void setChuDeId(int chuDeId) {
        this.chuDeId = chuDeId;
    }

    public int getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(int taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public ChuDe getChuDe() {
        return chuDe;
    }

    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
