package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.HocVien;
import com.example.jpa_webapi_final.Model.KhoaHoc;

import java.util.List;

public interface IHocVien {

    public String themMoiHocVien(HocVien hocVien);
    public String suaThongTinHocVien(HocVien suaHocVien);
    public String xoaHocVien(int hocVienId);
    public List<HocVien> danhSachHocVien();
    public String timKiemHocVienByTenHocVien(String tenHocVien);
    public String timKiemHocVienByEmail(String email);

}
