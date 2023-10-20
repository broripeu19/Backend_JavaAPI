package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.KhoaHoc;
import com.example.jpa_webapi_final.Repository.KhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangKhoaHocServices implements IBangKhoaHoc {

    @Autowired
    private KhoaHocRepo khoaHocRepo;


    @Override
    public List<KhoaHoc> hienThiDanhSachKhoaHoc() {
        return khoaHocRepo.findAll();
    }

    @Override
    public KhoaHoc timKiemKhoaHocByTenKhoaHoc(String tenKhoaHoc) {

        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepo.findAll();
        int idKhoa=0;
        for (KhoaHoc kh : danhSachKhoaHoc) {
            if(kh.getTenKhoaHoc().contains(tenKhoaHoc)){
                idKhoa = kh.getKhoaHocId();
                break;
            }
        }
        if(idKhoa == 0){
            return null;
        }
        else {
            KhoaHoc kh = khoaHocRepo.findById(idKhoa).get();
            return kh;
        }

    }
}
