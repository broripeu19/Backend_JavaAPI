package com.example.jpa_webapi_final.Services;


import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import com.example.jpa_webapi_final.Repository.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiKhoaHocServices implements  ILoaiKhoaHoc{

    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;


    @Override
    public LoaiKhoaHoc addLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        loaiKhoaHocRepo.save(loaiKhoaHoc);
        return loaiKhoaHoc;
    }

    @Override
    public LoaiKhoaHoc remakeLoaiKhoaHoc(LoaiKhoaHoc suaLoaiKhoaHoc) {
        Optional<LoaiKhoaHoc> loaiKhoaHoc = loaiKhoaHocRepo.findById(suaLoaiKhoaHoc.getLoaiKhoaHocId());

        if(loaiKhoaHoc.isEmpty()){
            return null;
        }
        LoaiKhoaHoc lkh = loaiKhoaHoc.get();
        lkh.setTenLoai(suaLoaiKhoaHoc.getTenLoai());
        loaiKhoaHocRepo.save(lkh);
        return suaLoaiKhoaHoc;
    }

    @Override
    public LoaiKhoaHoc removeLoaiKhoaHoc(int loaiKhoaHocId) {
        Optional<LoaiKhoaHoc> loaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHocId);

        if(loaiKhoaHoc.isEmpty()){
            return null;
        }
        else{
            loaiKhoaHocRepo.delete(loaiKhoaHoc.get());
            return loaiKhoaHoc.get();
        }
    }
}
