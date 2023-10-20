package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.TinhTrangHoc;
import com.example.jpa_webapi_final.Repository.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TinhTrangHocServices implements ITinhTrangHoc{

    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;


    @Override
    public String addTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        tinhTrangHocRepo.save(tinhTrangHoc);
        return "Thêm mới tình trạng học thành công!!";
    }

    @Override
    public String remakeTinhTrangHoc(TinhTrangHoc suaTinhTrangHoc) {
        Optional<TinhTrangHoc> tinhTrangHoc = tinhTrangHocRepo.findById(suaTinhTrangHoc.getTinhTrangHocId());

        TinhTrangHoc tth = tinhTrangHoc.get();
        tth.setTenTinhTrang(suaTinhTrangHoc.getTenTinhTrang());
        tinhTrangHocRepo.save(tth);
        return "Sửa tình trạng học thành công";
    }

    @Override
    public String removeTinhTrangHoc(int tinhTrangHocId) {
        Optional<TinhTrangHoc> tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHocId);

        if(tinhTrangHoc.isEmpty()){
            return "Không tìm thấy id: "+tinhTrangHocId+" tình trạng học";
        }
        tinhTrangHocRepo.delete(tinhTrangHoc.get());
        return "Xóa tình trạng học thành công";
    }
}
