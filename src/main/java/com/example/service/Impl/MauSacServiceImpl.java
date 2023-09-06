package com.example.service.Impl;

import com.example.entity.MauSP;
import com.example.entity.SanPham;
import com.example.repository.MauSacRepository;
import com.example.repository.SanPhamRepository;
import com.example.service.DongSanPhamService;
import com.example.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public MauSP detail(UUID id) {
        return mauSacRepository.getById(id);
    }

    @Override
    public void add(MauSP mauSP) {
        mauSacRepository.save(mauSP);
    }

    @Override
    public void update(MauSP mauSP) {
        mauSacRepository.save(mauSP);
    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public Page<MauSP> getAll(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Service
    public static class SanPhamServiceImpl implements DongSanPhamService.SanPhamService {


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
}
