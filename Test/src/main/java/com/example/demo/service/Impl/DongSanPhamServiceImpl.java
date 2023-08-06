package com.example.demo.service.Impl;

import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSanPhamRepository;
import com.example.demo.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSP> getAll() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public DongSP getById(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public DongSP detail(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void add(DongSP dongSP) {
dongSanPhamRepository.save(dongSP);
    }

    @Override
    public void update(DongSP dongSP) {
        dongSanPhamRepository.save(dongSP);
    }

    @Override
    public void delete(UUID id) {
dongSanPhamRepository.deleteById(id);
    }

}
