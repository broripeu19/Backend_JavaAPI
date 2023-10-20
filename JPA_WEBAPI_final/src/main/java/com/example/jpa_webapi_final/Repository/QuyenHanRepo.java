package com.example.jpa_webapi_final.Repository;

import com.example.jpa_webapi_final.Model.QuyenHan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan, Integer> {
}
