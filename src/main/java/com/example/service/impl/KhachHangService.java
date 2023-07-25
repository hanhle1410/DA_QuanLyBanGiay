package com.example.service.impl;

import com.example.entity.KhachHang;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface KhachHangService {

    KhachHang findBySdt(@Param("sdt") String sdt);

    public void addKH(KhachHang khachHang);

}
