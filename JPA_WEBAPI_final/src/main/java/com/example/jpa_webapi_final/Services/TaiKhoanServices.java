package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.TaiKhoan;
import com.example.jpa_webapi_final.Repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TaiKhoanServices implements ITaiKhoan{

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;


    @Override
    public String addNewTaiKhoan(TaiKhoan taiKhoan) {
        List<TaiKhoan> listTaiKhoan = taiKhoanRepo.findAll();

        for (TaiKhoan tk: listTaiKhoan ) {
            if(taiKhoan.getTaiKhoan().equals(tk.getTaiKhoan())){
                return "Đã tồn tại tài khoản ! Vui lòng nhập một tài khoản khác!";
            }
        }
        if(!isValidPassword(taiKhoan.getMatKhau())){
            return "Mật khẩu phải có ít nhất một số và kí tự đặc biệt";
        }
        taiKhoanRepo.save(taiKhoan);
        return "Thêm mới tài khoản thành công!!!";
    }

    @Override
    public String remakeTaiKhoan(TaiKhoan suaTaiKhoan) {
        Optional<TaiKhoan> taiKhoan = taiKhoanRepo.findById(suaTaiKhoan.getTaiKhoanId());
        if(taiKhoan.isEmpty()){
            return "Không tồn tại id tài khoản để sửa!!";
        }
        TaiKhoan tk = taiKhoan.get();
        if(suaTaiKhoan.getTaiKhoan() != null){
            return "không được sửa tài khoản";
        }

        if(!isValidPassword(suaTaiKhoan.getMatKhau())){
            return "Mật khẩu phải có ít nhất một số và kí tự đặc biệt";
        }
        tk.setMatKhau(suaTaiKhoan.getMatKhau());
        tk.setQuyenHan(suaTaiKhoan.getQuyenHan());
        tk.setTenNguoiDung(suaTaiKhoan.getTenNguoiDung());

        taiKhoanRepo.save(tk);

        return "Sửa tài khoản thành công!!!";
    }

    @Override
    public String removeTaiKhoan(int taiKhoanId) {
        Optional<TaiKhoan> taiKhoan = taiKhoanRepo.findById(taiKhoanId);
        if(taiKhoan.isEmpty()){
            return "không tồn tại id :" +taiKhoanId +" để xóa!!";
        }
        TaiKhoan tk =  taiKhoan.get();
        taiKhoanRepo.delete(taiKhoan.get());
        return "Xóa tài khoản: "+ tk.getTaiKhoan()+" thành công!!" ;
    }

    @Override
    public String timTaiKhoanByTenTaiKhoan(String tenTaiKhoan) {
        List<TaiKhoan> dsTaiKhoan = taiKhoanRepo.findAll();
        List<TaiKhoan> dsTaiKhoanByTenTaiKhoan = new ArrayList<>();

        for (TaiKhoan taiKhoan : dsTaiKhoan) {
            if(taiKhoan.getTaiKhoan().toLowerCase().contains(tenTaiKhoan.toLowerCase())){
                dsTaiKhoanByTenTaiKhoan.add(taiKhoan);
            }
        }

        StringBuilder strTaiKhoan = new StringBuilder();
        for (TaiKhoan taiKhoan: dsTaiKhoanByTenTaiKhoan) {
            strTaiKhoan.append("Tài khoản id: ").append(taiKhoan.getTaiKhoanId()).append("\n")
                       .append("Tên tài khoản: ").append(taiKhoan.getTaiKhoan()).append("\n")
                       .append("Mật khẩu : ").append(taiKhoan.getMatKhau()).append("\n")
                       .append("Quyền hạn : ").append(taiKhoan.getQuyenHanId()).append("\n")
                       .append("Tên người dùng : ").append(taiKhoan.getTenNguoiDung()).append("\n").append("\n");
        }
        if(dsTaiKhoanByTenTaiKhoan.isEmpty()){
            return "Không tìm thấy tài khoản !!!";
        }
        else{
            return "Tìm kiếm thành công "+"\n"
                    + strTaiKhoan;
        }
    }

    @Override
    public List<TaiKhoan> dsTaiKhoan() {
        return taiKhoanRepo.findAll();
    }

    public static boolean isValidPassword(String password) {
        // Biểu thức chính quy để kiểm tra mật khẩu
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$";

        // Tạo đối tượng Pattern từ biểu thức chính quy
        Pattern pattern = Pattern.compile(regex);

        // Tạo đối tượng Matcher để so khớp mật khẩu với biểu thức chính quy
        Matcher matcher = pattern.matcher(password);

        // Kiểm tra xem mật khẩu có khớp với biểu thức chính quy không
        return matcher.matches();
    }
}
