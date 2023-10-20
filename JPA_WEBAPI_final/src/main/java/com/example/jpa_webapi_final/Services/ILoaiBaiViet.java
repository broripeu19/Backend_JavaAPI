package com.example.jpa_webapi_final.Services;

import com.example.jpa_webapi_final.Model.LoaiBaiViet;

import java.util.List;

public interface ILoaiBaiViet {
    public String addLoaiBaiViet(LoaiBaiViet loaiBaiViet);
    public String remakeLoaiBaiViet(LoaiBaiViet suaLoaiBaiViet);
    public String removeLoaiBaiViet(int loaiBaiVietId);
    public List<LoaiBaiViet> dsLoaiBaiViet();
}
