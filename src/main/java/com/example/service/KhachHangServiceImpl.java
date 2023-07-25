package com.example.service;

import com.example.entity.KhachHang;
import com.example.entity.SanPham;
import com.example.repository.KhachHangRepository;
import com.example.service.impl.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHang findBySdt(String sdt) {
        return khachHangRepository.findBySdt(sdt);
    }

    @Override
    public void addKH(KhachHang khachHang) {
        try {
            this.khachHangRepository.save(khachHang);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
    }
}
