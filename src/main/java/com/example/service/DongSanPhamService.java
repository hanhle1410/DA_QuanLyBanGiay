package com.example.service;

import com.example.entity.DongSP;

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
