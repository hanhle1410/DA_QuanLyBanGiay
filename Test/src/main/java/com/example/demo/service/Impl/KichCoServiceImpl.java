package com.example.demo.service.Impl;

import com.example.demo.entity.KichCo;
import com.example.demo.repository.KichCoRepository;
import com.example.demo.service.KichCoService;
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
}
