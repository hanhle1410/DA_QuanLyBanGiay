package com.example.service;

import com.example.entity.DongSP;
import com.example.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSP> getAll();

    DongSP getById(UUID id);

    DongSP detail(UUID id);

    void add(DongSP dongSP);

    void update(DongSP dongSP);

    void delete(UUID id);

    interface SanPhamService {

        List<SanPham> layDanhSachSanPham();
        SanPham laySanPham(UUID id);

    }
}
