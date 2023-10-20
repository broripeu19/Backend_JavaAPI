package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.LoaiBaiViet;
import com.example.jpa_webapi_final.Repository.LoaiBaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiBaiVietServices implements ILoaiBaiViet{

    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;

    @Override
    public String addLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        loaiBaiVietRepo.save(loaiBaiViet);

        return "Thêm mới loại bài viết thành công";
    }

    @Override
    public String remakeLoaiBaiViet(LoaiBaiViet suaLoaiBaiViet) {
        Optional<LoaiBaiViet> loaiBaiViet  = loaiBaiVietRepo.findById(suaLoaiBaiViet.getLoaiBaiVietId());
        if(loaiBaiViet.isEmpty()){
            return "Không tồn tại id loại bài viết trên ";
        }
        LoaiBaiViet lbv = loaiBaiViet.get();
        lbv.setTenLoai(suaLoaiBaiViet.getTenLoai());
        loaiBaiVietRepo.save(lbv);
        return "Sửa loại bài viết thành công";
    }
    @Override
    public String removeLoaiBaiViet(int loaiBaiVietId) {
        Optional<LoaiBaiViet> loaiBaiViet  = loaiBaiVietRepo.findById(loaiBaiVietId);
        if(loaiBaiViet.isEmpty()){
            return "Không tồn tại id loại bài viết trên";
        }
        loaiBaiVietRepo.delete(loaiBaiViet.get());
        return "Xoá bài viết thành công";
    }

    @Override
    public List<LoaiBaiViet> dsLoaiBaiViet() {
        return loaiBaiVietRepo.findAll();
    }
}
