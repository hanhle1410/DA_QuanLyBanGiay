package com.example.service;

import com.example.entity.GioHangCT;
import com.example.entity.HoaDonCT;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface HoaDonCTService {

    public void save(HoaDonCT hoaDonCT);

    public void add(HoaDonCT hoaDonCT);
    public List<HoaDonCT> getAllItems();
    public int getCount();
    public BigDecimal getAmount();

    public HoaDonCT update(UUID id , int soLuong);
    public void clear();
    public void remove(UUID id);

}
