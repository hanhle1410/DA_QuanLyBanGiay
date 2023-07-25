package com.example.service;


import com.example.entity.HoaDon;
import com.example.entity.HoaDonCT;
import com.example.repository.HoaDonRepository;
import com.example.service.impl.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;


    public HoaDon findById(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public void add(HoaDon hoaDon) {
        this.hoaDonRepository.save(hoaDon);
    }



    @Override
    public List<HoaDon> getallHoaDon() {
        return hoaDonRepository.findAll();
    }



}
