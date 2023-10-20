package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.BaiViet;
import com.example.jpa_webapi_final.Model.DangKyHoc;
import com.example.jpa_webapi_final.Services.BaiVietServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/baiviet")
public class BaiVietController {

    @Autowired
    private BaiVietServices baiVietServices;


    @RequestMapping(value = "addBaiViet" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addBaiViet(@RequestBody BaiViet baiViet){
        return baiVietServices.addBaiViet(baiViet);
    }

    @RequestMapping(value = "remakeBaiViet" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeBaiViet(@RequestBody BaiViet suaBaiViet){
        return baiVietServices.remakeBaiViet(suaBaiViet);
    }

    @RequestMapping(value = "removeBaiViet" , method = RequestMethod.DELETE)
    public String removeBaiViet(@RequestParam(value = "baiVietId") int baiVietId){
        return baiVietServices.removeBaiViet(baiVietId);
    }

    @RequestMapping(value = "dsBaiViet" , method = RequestMethod.GET)
    public List<BaiViet> dsBaiViet(){
        return baiVietServices.dsBaiViet();
    }


    @RequestMapping(value = "timKiemBaiVietByTenBaiViet" , method = RequestMethod.GET)
    public String timKiemBaiVietByTenBaiViet(@RequestParam(value = "tenBaiViet") String tenBaiViet){
        return baiVietServices.timKiemBaiVietByTenBaiViet(tenBaiViet);
    }

}
