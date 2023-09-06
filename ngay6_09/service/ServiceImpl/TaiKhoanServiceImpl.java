package com.example.service.ServiceImpl;

import com.example.entity.NhanVien;
import com.example.entity.TaiKhoan;
import com.example.repository.TaiKhoanRepository;
import com.example.service.NhanVienService;
import com.example.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private NhanVienService nhanVienService;

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public void add(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public void update(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public TaiKhoan detail(UUID id) {
        NhanVien nhanVien = nhanVienService.detail(id);
        return null;
    }

    @Override
    public TaiKhoan getById(UUID id) {
        return null;
    }
}
