package com.example.demo.service;

import com.example.demo.entity.DongSP;
import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSP> getAll();

    DongSP getById(UUID id);

    DongSP detail(UUID id);

    void add(DongSP dongSP);

    void update(DongSP dongSP);

    void delete(UUID id);

}
