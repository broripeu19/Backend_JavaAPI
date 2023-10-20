package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.TaiKhoan;

import java.util.List;

public interface ITaiKhoan {
    public String addNewTaiKhoan(TaiKhoan taiKhoan);
    public String remakeTaiKhoan(TaiKhoan suaTaiKhoan);
    public String removeTaiKhoan(int taiKhoanId);
    public String timTaiKhoanByTenTaiKhoan(String tenTaiKhoan);
    public List<TaiKhoan> dsTaiKhoan();


}
