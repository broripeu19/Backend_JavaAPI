package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.BaiViet;
import com.example.jpa_webapi_final.Model.ChuDe;

import java.util.List;

public interface IBaiViet {

    public String addBaiViet(BaiViet baiViet);
    public String remakeBaiViet(BaiViet suaSuaBaiViet);
    public String removeBaiViet(int baiVietId);
    public List<BaiViet> dsBaiViet();
    public String timKiemBaiVietByTenBaiViet(String baiViet);
}
