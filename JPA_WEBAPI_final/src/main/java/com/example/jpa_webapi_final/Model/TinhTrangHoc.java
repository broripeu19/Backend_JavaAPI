package com.example.jpa_webapi_final.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tinhtranghocs")
public class TinhTrangHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "tinhtranghocid")
    private int tinhTrangHocId;

    @Column(name = "tentinhtrang")
    private String tenTinhTrang;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tinhTrangHoc")
    @JsonManagedReference
    private Set<DangKyHoc>dangKyHocs;

    public int getTinhTrangHocId() {
        return tinhTrangHocId;
    }

    public void setTinhTrangHocId(int tinhTrangHocId) {
        this.tinhTrangHocId = tinhTrangHocId;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
