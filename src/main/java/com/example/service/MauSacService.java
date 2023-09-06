package com.example.service;

import com.example.entity.ChiTietSP;
import com.example.entity.DeGiay;
import com.example.entity.MauSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSP> getAll();

    MauSP getById(UUID id);

    MauSP detail(UUID id);

    void add(MauSP mauSP);

    void update(MauSP mauSP);

    void delete(UUID id);

    Page<MauSP> getAll(Pageable pageable);

}
