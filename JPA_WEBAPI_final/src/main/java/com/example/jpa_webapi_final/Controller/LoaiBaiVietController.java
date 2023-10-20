package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.ChuDe;
import com.example.jpa_webapi_final.Model.LoaiBaiViet;
import com.example.jpa_webapi_final.Services.LoaiBaiVietServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/loaibaiviet")
public class LoaiBaiVietController {

    @Autowired
    private LoaiBaiVietServices loaiBaiVietServices;


    @RequestMapping(value = "addLoaiBaiViet" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addLoaiBaiViet(@RequestBody LoaiBaiViet loaiBaiViet){
        return loaiBaiVietServices.addLoaiBaiViet(loaiBaiViet);
    }

    @RequestMapping(value = "remakeLoaiBaiViet" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeLoaiBaiViet(@RequestBody LoaiBaiViet suaLoaiBaiViet){
        return loaiBaiVietServices.remakeLoaiBaiViet(suaLoaiBaiViet);
    }

    @RequestMapping(value = "removeLoaiBaiViet" , method = RequestMethod.DELETE)
    public String removeLoaiBaiViet(@RequestParam(value = "loaiBaiVietId") int loaiBaiVietId){
        return loaiBaiVietServices.removeLoaiBaiViet(loaiBaiVietId);
    }

    @RequestMapping(value = "dsLoaiBaiViet" , method = RequestMethod.GET)
    public List<LoaiBaiViet> dsLoaiBaiViet(){
        return loaiBaiVietServices.dsLoaiBaiViet();
    }

}
