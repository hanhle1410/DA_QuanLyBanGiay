package com.example.service.ServiceImpl;

import com.example.entity.KhachHang;
import com.example.repository.KhachHangRepository;
import com.example.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang detail(UUID id) {
        return khachHangRepository.getById(id);
    }

    @Override
    public KhachHang getById(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }
}
