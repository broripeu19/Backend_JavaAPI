package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loaibaiviets")
public class LoaiBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;

    @Column(name = "tenloai")
    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiBaiViet")
    @JsonManagedReference
    private Set<ChuDe> chuDeS;


    public int getLoaiBaiVietId() {
        return loaiBaiVietId;
    }

    public void setLoaiBaiVietId(int loaiBaiVietId) {
        this.loaiBaiVietId = loaiBaiVietId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Set<ChuDe> getChuDeS() {
        return chuDeS;
    }

    public void setChuDeS(Set<ChuDe> chuDeS) {
        this.chuDeS = chuDeS;
    }
}
