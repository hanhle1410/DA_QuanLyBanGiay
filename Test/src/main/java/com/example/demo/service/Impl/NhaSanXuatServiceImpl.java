package com.example.demo.service.Impl;

import com.example.demo.entity.NhaSX;
import com.example.demo.repository.NhaSanXuatRepository;
import com.example.demo.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSX> getAll() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public NhaSX getById(UUID id) {
        return nhaSanXuatRepository.findById(id).orElse(null);
    }

    @Override
    public NhaSX detail(UUID id) {
        return nhaSanXuatRepository.getById(id);
    }

    @Override
    public void add(NhaSX nhaSX) {
nhaSanXuatRepository.save(nhaSX);
    }

    @Override
    public void update(NhaSX nhaSX) {
nhaSanXuatRepository.save(nhaSX);
    }

    @Override
    public void delete(UUID id) {
nhaSanXuatRepository.deleteById(id);
    }
}
