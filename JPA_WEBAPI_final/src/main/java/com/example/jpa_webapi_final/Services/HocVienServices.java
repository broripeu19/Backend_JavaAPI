package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.HocVien;
import com.example.jpa_webapi_final.Model.KhoaHoc;
import com.example.jpa_webapi_final.Repository.HocVienRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class HocVienServices implements IHocVien {

    @Autowired
    private HocVienRepo hocVienRepo;


    @Override
    public String themMoiHocVien(HocVien hocVien) {

        List<HocVien> dsHocVien = hocVienRepo.findAll();
        for (HocVien hv: dsHocVien) {
            if(hocVien.getSoDienThoai() == hv.getSoDienThoai()){
                return "Số điện thoại đã được sử dụng!!";
            }
            if (hocVien.getEmail().equals(hv.getEmail())){
                return "Email đã được sử dụng!!!";
            }
        }

        hocVienRepo.save(hocVien);
        return "Thêm học viên mới thành công!->Ok";
    }

    @Override
    public String suaThongTinHocVien(HocVien suaHocVien) {
        Optional<HocVien> hocVien = hocVienRepo.findById(suaHocVien.getHocVienId());
        if(hocVien.isEmpty()){
            return "Không tìm thấy học viên ";
        }
        HocVien hv = hocVien.get();
        hv.setHoTen(suaHocVien.getHoTen());
        hv.setHinhAnh(suaHocVien.getHinhAnh()); ;
        hv.setNgaySinh(suaHocVien.getNgaySinh());
        hv.setSoDienThoai(suaHocVien.getSoDienThoai());
        hv.setEmail(suaHocVien.getEmail());
        hv.setTinhThanh(suaHocVien.getTinhThanh());
        hv.setQuanHuyen(suaHocVien.getQuanHuyen());
        hv.setPhuongXa(suaHocVien.getPhuongXa());
        hv.setSoNha(suaHocVien.getSoNha());
        hocVienRepo.save(hv);

        return "Sửa thành công !!!";
    }

    @Override
    public String xoaHocVien(int hocVienId) {
        Optional<HocVien> hvCanXoa = hocVienRepo.findById(hocVienId);
        if(hvCanXoa.isEmpty()){
            return "Không tìm thấy học viên với id: "+hocVienId;
        }
        else {
            hocVienRepo.delete(hvCanXoa.get());
            return "Xóa học viên thành công!";
        }
    }

    @Override
    public List<HocVien> danhSachHocVien() {
        return hocVienRepo.findAll();
    }
    @Override
    public String timKiemHocVienByTenHocVien(String tenHocVien) {

        List<HocVien> danhSachHocVien = hocVienRepo.findAll();
        List<HocVien> dsHocVienMoi = new ArrayList<>();


        for (HocVien hv : danhSachHocVien) {
            if(hv.getHoTen().toLowerCase().contains(tenHocVien.toLowerCase())){
                dsHocVienMoi.add(hv);
            }
        }
        if (dsHocVienMoi.isEmpty()){
            return "Không tìm thấy tên học viên ";
        }
        StringBuilder strHocVien = new StringBuilder();
        for (HocVien hocVien: dsHocVienMoi ) {
            strHocVien.append("Học viên id: ").append(hocVien.getHocVienId()).append("\n")
                      .append("Hình ảnh : ").append(hocVien.getHinhAnh()).append("\n")
                      .append("Họ tên: ").append(hocVien.getHoTen()).append("\n")
                      .append("Ngày sinh: ").append(hocVien.getNgaySinh()).append("\n")
                      .append("Số điện thoại: ").append(hocVien.getSoDienThoai()).append("\n")
                      .append("Email: ").append(hocVien.getEmail()).append("\n")
                      .append("Tỉnh thành: ").append(hocVien.getTinhThanh()).append("\n")
                      .append("Quận huyện: ").append(hocVien.getQuanHuyen()).append("\n")
                      .append("Phường xã: ").append(hocVien.getPhuongXa()).append("\n")
                      .append("Số nhà: ").append(hocVien.getSoNha()).append("\n").append("\n");
        }

        return strHocVien.toString();

    }

    @Override
    public String timKiemHocVienByEmail(String email) {

        List<HocVien> danhSachHocVien = hocVienRepo.findAll();
        List<HocVien> dsHocVienMoi = new ArrayList<>();


        for (HocVien hv : danhSachHocVien) {
            if(hv.getEmail().toLowerCase(Locale.ROOT).contains(email.toLowerCase())){
                dsHocVienMoi.add(hv);
            }
        }
        if (dsHocVienMoi.isEmpty()){
            return "Không tìm thấy tên học viên ";
        }
        StringBuilder strHocVien = new StringBuilder();
        for (HocVien hocVien: dsHocVienMoi ) {
            strHocVien.append("Học viên id: ").append(hocVien.getHocVienId()).append("\n")
                    .append("Hình ảnh : ").append(hocVien.getHinhAnh()).append("\n")
                    .append("Họ tên: ").append(hocVien.getHoTen()).append("\n")
                    .append("Ngày sinh: ").append(hocVien.getNgaySinh()).append("\n")
                    .append("Số điện thoại: ").append(hocVien.getSoDienThoai()).append("\n")
                    .append("Email: ").append(hocVien.getEmail()).append("\n")
                    .append("Tỉnh thành: ").append(hocVien.getTinhThanh()).append("\n")
                    .append("Quận huyện: ").append(hocVien.getQuanHuyen()).append("\n")
                    .append("Phường xã: ").append(hocVien.getPhuongXa()).append("\n")
                    .append("Số nhà: ").append(hocVien.getSoNha()).append("\n").append("\n");
        }

        return strHocVien.toString();

    }

}
