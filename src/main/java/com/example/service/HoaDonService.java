package com.example.service;

import com.example.entity.HoaDon;
import com.example.entity.HoaDonCT;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HoaDonService {
    public HoaDon findById(UUID id);
    public void add(HoaDon hoaDon);
    public List<HoaDon> getallHoaDon();
    String getNextMa();
    public List<HoaDon> getAllHoaDonByNgayTaoAndTrangThai();

    public HoaDon findByMa(String maHoaDon);

}
