package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.QuyenHan;
import com.example.jpa_webapi_final.Repository.QuyenHanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenHanServices implements IQuyenHan{

    @Autowired
    private QuyenHanRepo quyenHanRepo;

    @Override
    public String addQuyenHan(QuyenHan quyenHan) {

        quyenHanRepo.save(quyenHan);
        return "Thêm mới quyền hạn thành công!!";
    }

    @Override
    public String remakeQuyenHan(QuyenHan suaQuyenHan) {
        Optional<QuyenHan> quyenHan = quyenHanRepo.findById(suaQuyenHan.getQuyenHanId());
        if(quyenHan.isEmpty()){
            return "Không tồn tại id :" +suaQuyenHan.getQuyenHanId()+" quyền hạn";
        }
        QuyenHan qh =  quyenHan.get();
        qh.setTenQuyenHan(suaQuyenHan.getTenQuyenHan());
        quyenHanRepo.save(qh);

        return "Sửa quyền hạn thành công!!!";
    }

    @Override
    public String removeQuyenHan(int quyenHanId) {
        Optional<QuyenHan> quyenHan = quyenHanRepo.findById(quyenHanId);
        if(quyenHan.isEmpty()){
            return "Không tồn tại id :" +quyenHanId+" quyền hạn";
        }
        quyenHanRepo.delete(quyenHan.get());
        return "Xóa quyền hạn id : "+ quyenHanId +" thành công!";
    }

    @Override
    public List<QuyenHan> dsQuyenHan() {
        return quyenHanRepo.findAll();
    }
}
