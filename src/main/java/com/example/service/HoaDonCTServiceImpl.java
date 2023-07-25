package com.example.service;


import com.example.entity.HoaDonCT;
import com.example.repository.HoaDonCTRepository;
import com.example.service.impl.HoaDonCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonCTServiceImpl implements HoaDonCTService {

    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;
    @Override
    public void save(HoaDonCT hoaDonCT) {
        this.hoaDonCTRepository.save(hoaDonCT);
    }



}
