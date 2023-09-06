package com.example.service;

import com.example.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    void add(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(UUID id);

    NhanVien detail(UUID id);

    NhanVien getById(UUID id);
}
