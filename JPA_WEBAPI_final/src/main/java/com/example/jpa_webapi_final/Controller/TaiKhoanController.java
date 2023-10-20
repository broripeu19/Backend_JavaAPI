package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Model.TaiKhoan;
import com.example.jpa_webapi_final.Services.TaiKhoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanServices taiKhoanServices;

    @RequestMapping(value = "addTaiKhoan" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addTaiKhoan(@RequestBody TaiKhoan taiKhoan){
        return taiKhoanServices.addNewTaiKhoan(taiKhoan);
    }

    @RequestMapping(value = "remakeTaiKhoan" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeTaiKhoan(@RequestBody TaiKhoan suaTaiKhoan){
        return taiKhoanServices.remakeTaiKhoan(suaTaiKhoan);
    }

    @RequestMapping(value = "removeTaiKhoan" , method = RequestMethod.DELETE)
    public String removeTaiKhoan(@RequestParam(value = "taiKhoanId") int taiKhoanId){
        return taiKhoanServices.removeTaiKhoan(taiKhoanId);
    }

    @RequestMapping(value = "timTaiKhoanTheoTenTaiKhoan" , method = RequestMethod.GET)
    public String timTaiKhoanTheoTenTaiKhoan(@RequestParam(value = "tenTaiKhoan") String tenTaiKhoan){
        return taiKhoanServices.timTaiKhoanByTenTaiKhoan(tenTaiKhoan);
    }
    @RequestMapping(value = "dsTaiKhoan" , method = RequestMethod.GET)
    public List<TaiKhoan> dsTaiKhoan(){
        return taiKhoanServices.dsTaiKhoan();
    }

}
