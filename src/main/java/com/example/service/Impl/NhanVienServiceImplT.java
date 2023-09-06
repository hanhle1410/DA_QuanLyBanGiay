package com.example.service.ServiceImpl;

import com.example.entity.NhanVien;
import com.example.repository.NhanVienRepositoryT;
import com.example.service.NhanVienServiceT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImplT implements NhanVienServiceT {
    @Autowired
    private NhanVienRepositoryT nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien detail(UUID id) {
        return nhanVienRepository.getById(id);
    }

    @Override
    public NhanVien getById(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }
}
