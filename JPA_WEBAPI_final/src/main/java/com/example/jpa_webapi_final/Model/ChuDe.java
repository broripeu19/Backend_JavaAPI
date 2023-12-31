package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chudes")
public class ChuDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeId;

    @Column(name = "tenchude")
    private String tenChuDe;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;

    @ManyToOne
    @JoinColumn(name = "loaibaivietid" , insertable = false , updatable = false)
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;


    @OneToMany(fetch = FetchType.LAZY , mappedBy = "chuDe")
    @JsonManagedReference
    private Set<BaiViet> baiViets;

    public int getChuDeId() {
        return chuDeId;
    }

    public void setChuDeId(int chuDeId) {
        this.chuDeId = chuDeId;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getLoaiBaiVietId() {
        return loaiBaiVietId;
    }

    public void setLoaiBaiVietId(int loaiBaiVietId) {
        this.loaiBaiVietId = loaiBaiVietId;
    }

    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }

    public Set<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(Set<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }
}
