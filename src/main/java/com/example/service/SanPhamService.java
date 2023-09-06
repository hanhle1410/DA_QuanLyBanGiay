package com.example.service;

import com.example.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham detail(UUID id);

    SanPham getById(UUID id);

    void add(SanPham sanPham);

    void update(SanPham sanPham);

    void delete(UUID id);

}
