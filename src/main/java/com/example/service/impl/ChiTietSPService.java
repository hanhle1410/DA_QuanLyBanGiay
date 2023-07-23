package com.example.service.impl;

import com.example.entity.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> layDanhSachChiTietSP(UUID idSanPham);

    ChiTietSP layChiTietSP(UUID id);
    public void addToCart(ChiTietSP chiTietSP, int soLuong);

    public Page<ChiTietSP> search(String keyword, Pageable pageable);
    List<ChiTietSP> getALLChiTietSP();
}
