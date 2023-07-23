package com.example.service;

import com.example.entity.SanPham;
import com.example.repository.SanPhamRepository;
import com.example.service.impl.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {


    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> layDanhSachSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham laySanPham(UUID id) {
        Optional<SanPham> optional = sanPhamRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
