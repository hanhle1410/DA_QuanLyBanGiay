package com.example.service;

import com.example.entity.KichCo;
import com.example.entity.MauSP;

import java.util.List;
import java.util.UUID;

public interface KichCoService {

    List<KichCo> getAll();

    KichCo getById(UUID id);

    KichCo detail(UUID id);

    void add(KichCo kichCo);

    void update(KichCo kichCo);

    void delete(UUID id);
}
