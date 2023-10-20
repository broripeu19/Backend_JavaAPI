package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Model.TinhTrangHoc;
import com.example.jpa_webapi_final.Services.TinhTrangHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/version1.0")
public class TìnhTrangHocController {

    @Autowired
    private TinhTrangHocServices tinhTrangHocServices;


    @RequestMapping(value = "addTinhTrangHoc" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addTinhTrangHoc(@RequestBody TinhTrangHoc tinhTrangHoc){
        return tinhTrangHocServices.addTinhTrangHoc(tinhTrangHoc);
    }

    @RequestMapping(value = "remakeTinhTrangHoc" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeTinhTrangHoc(@RequestBody TinhTrangHoc suaTinhTrangHoc){
        return tinhTrangHocServices.remakeTinhTrangHoc(suaTinhTrangHoc);
    }

    @RequestMapping(value = "removeTinhTrangHoc" , method = RequestMethod.DELETE)
    public String removeTinhTrangHoc(@RequestParam(value = "tinhTrangHocId") int tinhTrangHocId){
        return tinhTrangHocServices.removeTinhTrangHoc(tinhTrangHocId);
    }
}

