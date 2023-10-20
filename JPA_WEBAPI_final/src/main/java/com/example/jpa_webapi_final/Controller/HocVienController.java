package com.example.jpa_webapi_final.Controller;

import com.example.jpa_webapi_final.Model.HocVien;
import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Services.HocVienServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/hocvien")
public class HocVienController {


    @Autowired
    private HocVienServices hocVienServices;



    @RequestMapping(value = "addHocVien" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addLoaiKhoaHoc(@RequestBody String hocvien){

        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext){
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        HocVien hv = gson.fromJson(hocvien, HocVien.class);
        return hocVienServices.themMoiHocVien(hv);
    }

    @RequestMapping(value = "remakeHocVien" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeHocVien(@RequestBody String suaHocVien){
        Gson gson = new Gson();
        HocVien hocVien = gson.fromJson(suaHocVien , HocVien.class);
        return hocVienServices.suaThongTinHocVien(hocVien);
    }

    @RequestMapping(value = "removeHocVien" , method = RequestMethod.DELETE)
    public String removeHocVien(@RequestParam(value = "hocVienId") int hocVienId){
        return hocVienServices.xoaHocVien(hocVienId);
    }

    @RequestMapping(value = "danhSachHocVien" , method = RequestMethod.GET)
    public List<HocVien> danhSachHocVien(){
        return hocVienServices.danhSachHocVien();
    }

    @RequestMapping(value = "timKiemHocVienTheoTenHocVien" , method = RequestMethod.GET)
    public String timKiemHocVienTheoTenHocVien(@RequestParam(value = "tenHocVien") String tenHocVien){
        return hocVienServices.timKiemHocVienByTenHocVien(tenHocVien);
    }

    @RequestMapping(value = "timKiemHocVienTheoEmail" , method = RequestMethod.GET)
    public String timKiemHocVienTheoEmail(@RequestParam(value = "email") String email){
        return hocVienServices.timKiemHocVienByEmail(email);
    }

}
