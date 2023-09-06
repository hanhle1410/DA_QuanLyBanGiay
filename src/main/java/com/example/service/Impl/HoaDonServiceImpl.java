package com.example.service.impl;


import com.example.entity.HoaDon;
import com.example.repository.HoaDonRepository;
import com.example.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;


    @Override
    public HoaDon findById(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDon.setMa(getNextMa());
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public String getNextMa() {
        String biggestMa = hoaDonRepository.getBiggestMa();
        if (biggestMa == null) {
            return "HD01";
        } else {
            int currentMa = Integer.parseInt(biggestMa.substring(2));
            int nextMa = currentMa + 1;
            String newMa = String.format("HD%02d", nextMa);
            return newMa;
        }
    }

    @Override
    public List<HoaDon> getallHoaDon() {
        return hoaDonRepository.findAll();
    }

    @Override
    public List<HoaDon> getAllHoaDonByNgayTaoAndTrangThai() {
        LocalDate ngayTao = LocalDate.now();
        Integer trangThai = 0;
        return hoaDonRepository.findAllByNgayTaoAndTrangThai(ngayTao, trangThai);
    }

    @Override
    public HoaDon findByMa(String maHoaDon) {
        return hoaDonRepository.findByMa(maHoaDon);
    }

}
