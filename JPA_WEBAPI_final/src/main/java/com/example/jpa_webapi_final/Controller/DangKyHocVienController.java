package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.DangKyHoc;
import com.example.jpa_webapi_final.Model.HocVien;
import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Services.DangKyHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/dangkyhocvien")
public class DangKyHocVienController {
    @Autowired
    private DangKyHocServices dangKyHocServices;


    @RequestMapping(value = "addDangKyHocVien" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addDangKyHocVien(@RequestBody DangKyHoc dangKyHoc){
        return dangKyHocServices.addDangKyHocVien(dangKyHoc);
    }

    @RequestMapping(value = "remakeDangKyHocVien" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeDangKyHocVien(@RequestBody DangKyHoc dangKyHoc){
        return dangKyHocServices.remakeDangKyHocVien(dangKyHoc);
    }

    @RequestMapping(value = "removeDangKyHocVien" , method = RequestMethod.DELETE)
    public String removeDangKyHocVien(@RequestParam(value = "dangKyHocVienId") int dangKyHocVienId){
        return dangKyHocServices.removeDangKyHocVien(dangKyHocVienId);
    }

    @RequestMapping(value = "dsDangKyHoc" , method = RequestMethod.GET)
    public List<DangKyHoc> dsDangKyHoc(){
        return dangKyHocServices.dsDangKyHoc();
    }



}
