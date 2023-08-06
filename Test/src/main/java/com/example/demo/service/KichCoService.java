package com.example.demo.service;

import com.example.demo.entity.KichCo;

import java.util.List;
import java.util.UUID;

public interface KichCoService {

    List<KichCo> getAll();

    KichCo getById(UUID id);

}
