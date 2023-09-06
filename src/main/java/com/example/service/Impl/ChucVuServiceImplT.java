package com.example.service.ServiceImpl;

import com.example.entity.ChucVu;
import com.example.repository.ChucVuRepositoryT;
import com.example.service.ChucVuServiceT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImplT implements ChucVuServiceT {
    @Autowired
    private ChucVuRepositoryT chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public void add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void update(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void delete(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu detail(UUID id) {
        return chucVuRepository.getById(id);
    }

    @Override
    public ChucVu getById(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }
}
