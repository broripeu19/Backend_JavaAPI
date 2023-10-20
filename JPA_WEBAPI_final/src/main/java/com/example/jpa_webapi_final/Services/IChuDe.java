package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.ChuDe;

import java.util.List;

public interface IChuDe {
    public String addChuDe(ChuDe chuDe);
    public String remakeChuDe(ChuDe suaChuDe);
    public String removeChuDe(int chuDeId);
    public List<ChuDe> dsChuDe();

}
