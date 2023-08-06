package com.example.demo.service.Impl;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSP detail(UUID id) {
        return chiTietSanPhamRepository.getById(id);
    }

    @Override
    public ChiTietSP getById(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void add(ChiTietSP chiTietSP) {
        chiTietSanPhamRepository.save(chiTietSP);
    }

    @Override
    public void update(ChiTietSP chiTietSP) {
        chiTietSanPhamRepository.save(chiTietSP);
    }

    @Override
    public void delete(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public Page<ChiTietSP> getAll(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

}
