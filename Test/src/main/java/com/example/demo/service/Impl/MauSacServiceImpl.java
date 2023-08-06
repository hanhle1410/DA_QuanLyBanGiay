package com.example.demo.service.Impl;

import com.example.demo.entity.MauSP;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSP> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSP getById(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }
}
