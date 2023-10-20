package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.KhoaHoc;
import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Services.BangKhoaHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/bangkhoahoc")
public class BangKhoaHocController {

    @Autowired
    private BangKhoaHocServices bangKhoaHocServices;

    @RequestMapping(value = "hienThiDanhSachKhoaHoc" , method = RequestMethod.GET )
    public List<KhoaHoc> hienThiDanhSachKhoaHoc(){
        return bangKhoaHocServices.hienThiDanhSachKhoaHoc();
    }

    @RequestMapping(value = "timKiemKhoaHocByTenKhoaHoc" , method = RequestMethod.GET )
    public KhoaHoc timKiemKhoaHocByTenKhoaHoc(@RequestParam(value = "tenKhoaHoc") String tenKhoaHoc){
        return bangKhoaHocServices.timKiemKhoaHocByTenKhoaHoc(tenKhoaHoc);
    }
}
