package com.example.demo.service;

import com.example.demo.entity.MauSP;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSP> getAll();

    MauSP getById(UUID id);

}
