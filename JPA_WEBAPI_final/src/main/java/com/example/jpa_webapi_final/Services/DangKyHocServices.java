package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.*;
import com.example.jpa_webapi_final.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DangKyHocServices implements IDangKyHoc {

    @Autowired
    private DangKyHocRepo dangKyHocRepo;

    @Autowired
    private KhoaHocRepo khoaHocRepo;

    @Autowired
    private HocVienRepo hocVienRepo;

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;


    @Override
    public String addDangKyHocVien(DangKyHoc dangKyHoc) {
        Optional<KhoaHoc> kh = khoaHocRepo.findById(dangKyHoc.getKhoaHocId());
        Optional<HocVien> hv = hocVienRepo.findById(dangKyHoc.getHocVienId());
        Optional<TaiKhoan> tk = taiKhoanRepo.findById(dangKyHoc.getTaiKhoanId());
        Optional<TinhTrangHoc> tr = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHocId());

        if(kh.isEmpty()){
            if(hv.isEmpty()){
                if(tk.isEmpty()){
                    if(tr.isEmpty()){
                        return "Id tình trạng không tồn tại ";
                    }
                    return "Id tài khoản không tồn tại ";
                }
                return "Id học viên không tồn tại ";
            }
            return "Id Khóa học không tồn tại ";
        }
        KhoaHoc khoaHoc = kh.get();

        LocalDate current  =  LocalDate.now();
        dangKyHoc.setNgayDangKy(current);
        int tinhTrangId = dangKyHoc.getTinhTrangHocId();
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangId).get();
        if(tinhTrangHoc.getTenTinhTrang().toLowerCase().contains("đang học")){
            dangKyHoc.setNgayBatDau(current);
            dangKyHoc.setNgayKetThuc(current.plusMonths(khoaHoc.getThoiGianHoc()));
        }

        //+ them hoc vien vao so luong khoa hoc
        khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() + 1);

        dangKyHocRepo.save(dangKyHoc);
        khoaHocRepo.save(khoaHoc);


        return "Thêm học viên thành công !!!";
    }

    @Override
    public String remakeDangKyHocVien(DangKyHoc suaDangKyKhoaHoc) {
        Optional<DangKyHoc> dangKyHoc = dangKyHocRepo.findById(suaDangKyKhoaHoc.getDangKyHocId());
        Optional<KhoaHoc> kh = khoaHocRepo.findById(suaDangKyKhoaHoc.getKhoaHocId());
        if(dangKyHoc.isEmpty()){
            return "Không tồn tại id đăng ký học viên";
        }

        KhoaHoc khoaHoc = kh.get();

        DangKyHoc dkh = dangKyHoc.get();
        LocalDate current  =  LocalDate.now();
        int tinhTrangId = suaDangKyKhoaHoc.getTinhTrangHocId();
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangId).get();

        if(tinhTrangHoc.getTenTinhTrang().toLowerCase().contains("đang học")){
            dkh.setNgayBatDau(current);
            dkh.setNgayKetThuc(current.plusMonths(khoaHoc.getThoiGianHoc()));
        }

        if(tinhTrangHoc.getTenTinhTrang().toLowerCase().contains("chờ duyệt")){
            dkh.setNgayBatDau(null);
            dkh.setNgayKetThuc(null);
            khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() + 1);
            khoaHocRepo.save(khoaHoc);
        }


        dkh.setHocVienId(suaDangKyKhoaHoc.getHocVienId());
        dkh.setKhoaHocId(suaDangKyKhoaHoc.getKhoaHocId());
        dkh.setTaiKhoanId(suaDangKyKhoaHoc.getTaiKhoanId());

        dkh.setTinhTrangHocId(suaDangKyKhoaHoc.getTinhTrangHocId());


       // dkh.setNgayBatDau(suaDangKyKhoaHoc.getNgayBatDau());
       // dkh.setNgayKetThuc(suaDangKyKhoaHoc.getNgayKetThuc());

        dangKyHocRepo.save(dkh);
        return "Sửa đăng ký học viên thành công";
    }

    @Override
    public String removeDangKyHocVien(int khoaHocId) {

        Optional<DangKyHoc> dangKyHoc = dangKyHocRepo.findById(khoaHocId);
        if(dangKyHoc.isEmpty()){
            return "Không tồn tại id đăng ký học viên";
        }

        dangKyHocRepo.delete(dangKyHoc.get());

        return "Xóa thành công id: "+khoaHocId +" trong bảng đăng ký học viên !!! ";
    }

    @Override
    public List<DangKyHoc> dsDangKyHoc() {
        return dangKyHocRepo.findAll();
    }
}
