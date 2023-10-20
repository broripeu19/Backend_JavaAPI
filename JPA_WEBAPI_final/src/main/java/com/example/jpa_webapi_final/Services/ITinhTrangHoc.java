package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.TinhTrangHoc;

public interface ITinhTrangHoc {

    public String addTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public String remakeTinhTrangHoc(TinhTrangHoc suaTinhTrangHoc);
    public String removeTinhTrangHoc(int tinhTrangHocId);

}
