package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.DangKyHoc;
import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Model.QuyenHan;
import com.example.jpa_webapi_final.Services.QuyenHanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/quyenhan")
public class QuyenHanController {

    @Autowired
    private QuyenHanServices quyenHanServices;

    @RequestMapping(value = "addQuyenHan" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addLoaiKhoaHoc(@RequestBody QuyenHan quyenHan){
        return quyenHanServices.addQuyenHan(quyenHan);
    }

    @RequestMapping(value = "remakeQuyenHan" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeQuyenHan(@RequestBody QuyenHan suaQuyenHan){
        return quyenHanServices.remakeQuyenHan(suaQuyenHan);
    }

    @RequestMapping(value = "removeQuyenHan" , method = RequestMethod.DELETE)
    public String removeQuyenHan(@RequestParam(value = "quyenHanId") int quyenHanId){
        return quyenHanServices.removeQuyenHan(quyenHanId);
    }

    @RequestMapping(value = "dsQuyenHan" , method = RequestMethod.GET)
    public List<QuyenHan> dsQuyenHan(){
        return quyenHanServices.dsQuyenHan();
    }

}
