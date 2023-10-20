package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.KhoaHoc;

import java.util.List;

public interface IBangKhoaHoc {

    public List<KhoaHoc> hienThiDanhSachKhoaHoc();
    public KhoaHoc timKiemKhoaHocByTenKhoaHoc(String tenKhoaHoc);

}
