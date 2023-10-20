package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.DangKyHoc;

import java.util.List;

public interface IDangKyHoc {

    public String addDangKyHocVien(DangKyHoc dangKyHoc);

    public String remakeDangKyHocVien(DangKyHoc suaDangKyKhoaHoc);

    public String removeDangKyHocVien(int khoaHocId );

    public List<DangKyHoc> dsDangKyHoc();
}
