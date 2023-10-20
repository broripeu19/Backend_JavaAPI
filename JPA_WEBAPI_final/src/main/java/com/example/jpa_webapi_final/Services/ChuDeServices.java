package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.ChuDe;
import com.example.jpa_webapi_final.Repository.ChuDeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuDeServices implements  IChuDe{
    @Autowired
    private ChuDeRepo chuDeRepo;


    @Override
    public String addChuDe(ChuDe chuDe) {
        chuDeRepo.save(chuDe);
        return "Thêm mới chủ đề thành công";
    }

    @Override
    public String remakeChuDe(ChuDe suaChuDe) {
        Optional<ChuDe> chuDe =  chuDeRepo.findById(suaChuDe.getChuDeId());
        if(chuDe.isEmpty()){
            return "Id chủ đề không tồn tại ";
        }

        ChuDe cd =  chuDe.get();
        cd.setTenChuDe(suaChuDe.getTenChuDe());
        cd.setNoiDung(suaChuDe.getNoiDung());
        cd.setLoaiBaiVietId(suaChuDe.getLoaiBaiVietId());
        chuDeRepo.save(cd);

        return "Sửa chủ đề thành công!!!";
    }

    @Override
    public String removeChuDe(int chuDeId) {
        Optional<ChuDe> chuDe = chuDeRepo.findById(chuDeId);
        if (chuDe.isEmpty()){
            return "Id chủ đề không tồn tại ";
        }
        chuDeRepo.delete(chuDe.get());
        return "Đã xóa chủ đề id : "+ chuDeId;
    }

    @Override
    public List<ChuDe> dsChuDe() {
        return chuDeRepo.findAll();
    }
}
