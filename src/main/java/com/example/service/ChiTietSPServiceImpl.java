package com.example.service;

import com.example.entity.ChiTietSP;
import com.example.repository.ChiTietSPRepository;
import com.example.service.impl.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {

    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<ChiTietSP> layDanhSachChiTietSP(UUID sanPham) {
        return this.chiTietSPRepository.findBySanPamId(sanPham);
    }
    @Override
    public ChiTietSP layChiTietSP(UUID id) {
        Optional<ChiTietSP> optional = chiTietSPRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Page<ChiTietSP> search(String keyword, Pageable pageable) {
        return chiTietSPRepository.search(keyword, pageable);
    }
    @Override
    public List<ChiTietSP> getALLChiTietSP() {
        return chiTietSPRepository.findAll();
    }
}
