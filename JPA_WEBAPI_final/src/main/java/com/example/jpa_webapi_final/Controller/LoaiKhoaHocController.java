package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Services.LoaiKhoaHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/version1.0/loaikhoahoc")
public class LoaiKhoaHocController {

    @Autowired
    private LoaiKhoaHocServices loaiKhoaHocServices;


    @RequestMapping(value = "addLoaiKhoaHoc" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc addLoaiKhoaHoc(@RequestBody LoaiKhoaHoc loaiKhoaHoc){
        return loaiKhoaHocServices.addLoaiKhoaHoc(loaiKhoaHoc);
    }

    @RequestMapping(value = "remakeLoaiKhoaHoc" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc remakeLoaiKhoaHoc(@RequestBody LoaiKhoaHoc sualoaiKhoaHoc){
        return loaiKhoaHocServices.remakeLoaiKhoaHoc(sualoaiKhoaHoc);
    }

    @RequestMapping(value = "removeLoaiKhoaHoc" , method = RequestMethod.DELETE)
    public LoaiKhoaHoc removeLoaiMonAn(@RequestParam(value = "loaiKhoaHocId") int loaiKhoaHocId){
        return loaiKhoaHocServices.removeLoaiKhoaHoc(loaiKhoaHocId);
    }

}
