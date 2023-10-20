package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quyenhans")
public class QuyenHan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyenhanid")
    private int quyenHanId;

    @Column(name = "tenquyenhan")
    private String tenQuyenHan;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "quyenHan")
    @JsonManagedReference
    private Set<TaiKhoan> taiKhoanS;


    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }

    public Set<TaiKhoan> getTaiKhoanS() {
        return taiKhoanS;
    }

    public void setTaiKhoanS(Set<TaiKhoan> taiKhoanS) {
        this.taiKhoanS = taiKhoanS;
    }
}
