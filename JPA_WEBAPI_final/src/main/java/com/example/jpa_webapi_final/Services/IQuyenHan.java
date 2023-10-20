package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.QuyenHan;

import java.util.List;

public interface IQuyenHan {

    public String addQuyenHan(QuyenHan quyenHan);
    public String remakeQuyenHan(QuyenHan suaQuyenHan);
    public String removeQuyenHan(int quyenHanId);
    public List<QuyenHan> dsQuyenHan();
}
