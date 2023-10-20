package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.BaiViet;
import com.example.jpa_webapi_final.Model.KhoaHoc;
import com.example.jpa_webapi_final.Repository.BaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietServices implements IBaiViet{

    @Autowired
    private BaiVietRepo baiVietRepo;

    @Override
    public String addBaiViet(BaiViet baiViet) {

        LocalDate current =  LocalDate.now();
        baiViet.setThoiGianTao(current);
        baiVietRepo.save(baiViet);
        return "Thêm mới bài viết thành công!!!";
    }

    @Override
    public String remakeBaiViet(BaiViet suaSuaBaiViet) {
        LocalDate current =  LocalDate.now();
        Optional<BaiViet> baiViet = baiVietRepo.findById(suaSuaBaiViet.getBaiVietId());
        if(baiViet.isEmpty()){
            return "Id bài viết không tồn tại";
        }
        BaiViet bv = baiViet.get();
        bv.setTenBaiViet(suaSuaBaiViet.getTenBaiViet());
        bv.setThoiGianTao(current);
        bv.setTenTacGia(suaSuaBaiViet.getTenTacGia());
        bv.setNoiDung(suaSuaBaiViet.getNoiDung());
        bv.setNoiDungNgan(suaSuaBaiViet.getNoiDungNgan());
        bv.setChuDeId(suaSuaBaiViet.getChuDeId());
        bv.setTaiKhoanId(suaSuaBaiViet.getTaiKhoanId());

        baiVietRepo.save(bv);

        return "Sửa bài viết thành công!!!";
    }

    @Override
    public String removeBaiViet(int baiVietId) {
        Optional<BaiViet> baiViet = baiVietRepo.findById(baiVietId);
        if(baiViet.isEmpty()){
            return "Id bài viết không tồn tại";
        }

        baiVietRepo.delete(baiViet.get());
        return "Xóa bài viết thành công";
    }

    @Override
    public List<BaiViet> dsBaiViet() {
        return baiVietRepo.findAll();
    }

    @Override
    public String timKiemBaiVietByTenBaiViet(String baiViet) {
        List<BaiViet> danhSachBaiViet = baiVietRepo.findAll();
        List<BaiViet> baiVietList = new ArrayList<>();
        for (BaiViet bv : danhSachBaiViet) {
            if(bv.getTenBaiViet().toLowerCase().contains(baiViet.toLowerCase())){
                baiVietList.add(bv);
            }
        }
        if(baiVietList.isEmpty()){
            return "Không có bài viết nào trùng tên : "+ baiViet;
        }

        StringBuilder strBaiViet = new StringBuilder();
        for (BaiViet bv : baiVietList ) {
            strBaiViet.append("Id bài viết: ").append(bv.getBaiVietId()).append("\n")
                    .append("Tên bài viết: ").append(bv.getTenBaiViet()).append("\n")
                    .append("Thời gian tạo bài viết: ").append(bv.getThoiGianTao()).append("\n")
                    .append("Tên tác giả: ").append(bv.getTenTacGia()).append("\n")
                    .append("Nội dung: ").append(bv.getNoiDung()).append("\n")
                    .append("Nội dung ngắn: ").append(bv.getNoiDungNgan()).append("\n")
                    .append("Id chủ đề : ").append(bv.getChuDeId()).append("\n")
                    .append("Id tài khoản: ").append(bv.getTaiKhoanId()).append("\n").append("\n");

        }
        return "Tìm kiếm bài viết thành công "+"\n"+
                strBaiViet.toString();

    }
}
