package com.example.service;

import com.example.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuServiceT {
    List<ChucVu> getAll();

    void add(ChucVu chucVu);

    void update(ChucVu chucVu);

    void delete(UUID id);

    ChucVu detail(UUID id);

    ChucVu getById(UUID id);
}
