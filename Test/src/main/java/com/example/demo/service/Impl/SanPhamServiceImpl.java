package com.example.demo.service.Impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham detail(UUID id) {
        return sanPhamRepository.getById(id);
    }

    @Override
    public SanPham getById(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void add(SanPham sanPham) { sanPhamRepository.save(sanPham); }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void delete(UUID id) {
sanPhamRepository.deleteById(id);
    }
}
