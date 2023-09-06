package com.example.service;

import com.example.entity.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<ChiTietSP> getAll();

    ChiTietSP detail(UUID id);

    ChiTietSP getById(UUID id);

    void add(ChiTietSP chiTietSP);

    void update(ChiTietSP chiTietSP);

    void delete(UUID id);

    Page<ChiTietSP> getAll(Pageable pageable);

}
