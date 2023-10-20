package com.example.jpa_webapi_final.Repository;

import com.example.jpa_webapi_final.Model.BaiViet;
import com.example.jpa_webapi_final.Model.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc, Integer> {
}
