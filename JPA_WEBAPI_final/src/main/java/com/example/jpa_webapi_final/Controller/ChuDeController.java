package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.ChuDe;
import com.example.jpa_webapi_final.Model.QuyenHan;
import com.example.jpa_webapi_final.Services.ChuDeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/chude")
public class ChuDeController {

    @Autowired
    private ChuDeServices chuDeServices;

    @RequestMapping(value = "addChuDe" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addChuDe(@RequestBody ChuDe chuDe){
        return chuDeServices.addChuDe(chuDe);
    }

    @RequestMapping(value = "remakeChuDe" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeChuDe(@RequestBody ChuDe suaChuDe){
        return chuDeServices.remakeChuDe(suaChuDe);
    }

    @RequestMapping(value = "removeChuDe" , method = RequestMethod.DELETE)
    public String removeChuDe(@RequestParam(value = "chuDeId") int chuDeId){
        return chuDeServices.removeChuDe(chuDeId);
    }

    @RequestMapping(value = "dsChuDe" , method = RequestMethod.GET)
    public List<ChuDe> dsChuDe(){
        return chuDeServices.dsChuDe();
    }
}
