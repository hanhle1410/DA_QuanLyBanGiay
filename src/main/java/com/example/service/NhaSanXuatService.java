package com.example.service;

import com.example.entity.NhaSX;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSX> getAll();

    NhaSX getById(UUID id);

    NhaSX detail(UUID id);

    void add(NhaSX nhaSX);

    void update(NhaSX nhaSX);

    void delete(UUID id);

}
