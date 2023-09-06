package com.example.service.Impl;

import com.example.entity.KichCo;
import com.example.repository.KichCoRepository;
import com.example.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichCoServiceImpl implements KichCoService {

    @Autowired
    private KichCoRepository kichCoRepository;

    @Override
    public List<KichCo> getAll() {
        return kichCoRepository.findAll();
    }

    @Override
    public KichCo getById(UUID id) {
        return kichCoRepository.findById(id).orElse(null);
    }

    @Override
    public KichCo detail(UUID id) {
        return kichCoRepository.getById(id);
    }

    @Override
    public void add(KichCo kichCo) {
kichCoRepository.save(kichCo);
    }

    @Override
    public void update(KichCo kichCo) {
        kichCoRepository.save(kichCo);
    }

    @Override
    public void delete(UUID id) {
kichCoRepository.deleteById(id);
    }
}
