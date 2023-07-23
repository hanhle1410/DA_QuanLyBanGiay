package com.example.service.impl;

import com.example.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> layDanhSachSanPham();
    SanPham laySanPham(UUID id);

}
