package com.example.service;

import com.example.entity.NhanVien;
import com.example.entity.TaiKhoan;

import java.util.List;
import java.util.UUID;

public interface TaiKhoanService {
    List<TaiKhoan> getAll();

    void add(TaiKhoan TaiKhoan);

    void update(TaiKhoan TaiKhoan);

    TaiKhoan detail(UUID id);

    TaiKhoan getById(UUID id);
}
