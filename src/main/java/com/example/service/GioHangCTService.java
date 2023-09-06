package com.example.service;

import com.example.entity.GioHangCT;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface GioHangCTService {

    public void add(GioHangCT item);
    public List<GioHangCT> getAllItems();
    public int getCount();
    public BigDecimal getAmount();

    public GioHangCT update(UUID id , int soLuong);
    public void clear();
    public void remove(UUID id);
}
