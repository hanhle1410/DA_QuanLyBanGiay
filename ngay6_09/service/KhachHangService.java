package com.example.service;

import com.example.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    void add(KhachHang khachHang);

    void update(KhachHang khachHang);

    void delete(UUID id);

    KhachHang detail(UUID id);

    KhachHang getById(UUID id);
}
