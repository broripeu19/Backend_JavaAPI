package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;

public interface ILoaiKhoaHoc {
    public LoaiKhoaHoc addLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public LoaiKhoaHoc remakeLoaiKhoaHoc(LoaiKhoaHoc suaLoaiKhoaHoc);
    public LoaiKhoaHoc removeLoaiKhoaHoc(int loaiKhoaHocId);

}
