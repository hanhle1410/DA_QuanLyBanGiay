package com.example.service.impl;


import com.example.entity.HoaDonCT;
import com.example.repository.HoaDonCTRepository;
import com.example.service.HoaDonCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HoaDonCTServiceImpl implements HoaDonCTService {

    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;

    private final Map<UUID, HoaDonCT> maps = new HashMap<>();

    @Override
    public void save(HoaDonCT hoaDonCT) {
        this.hoaDonCTRepository.save(hoaDonCT);
    }

    @Override
    public void add(HoaDonCT hoaDonCT) {
        UUID id = hoaDonCT.getIdChiTietSP().getId();
        HoaDonCT cartItem = maps.get(id);
        if (cartItem == null) {
            maps.put(id, hoaDonCT);
            this.hoaDonCTRepository.save(hoaDonCT);
        } else {
            cartItem.setSoLuong(cartItem.getSoLuong() + 1);
            this.hoaDonCTRepository.save(cartItem);
        }
    }

    @Override
    public List<HoaDonCT> getAllItems() {
        return hoaDonCTRepository.findAll();
    }

    @Override
    public int getCount() {
        List<HoaDonCT> cartItems = getAllItems();
        if (cartItems != null) {
            return cartItems.size();
        }
        return 0;
    }

    @Override
    public BigDecimal getAmount() {
        Map<UUID, HoaDonCT> hoaDonCTMap = hoaDonCTRepository.findAll().stream()
                .collect(Collectors.toMap(HoaDonCT::getId, hoaDonCT -> hoaDonCT));
        BigDecimal totalAmount = hoaDonCTMap.values().stream()
                .map(item -> item.getDonGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAmount;
    }

    @Override
    public HoaDonCT update(UUID id, int soLuong) {
        HoaDonCT cartItem = hoaDonCTRepository.findById(id).orElse(null);
        if (cartItem != null) {
            cartItem.setSoLuong(soLuong);
            hoaDonCTRepository.save(cartItem);
        }
        return cartItem;
    }

    @Override
    public void clear() {
        maps.clear();
        hoaDonCTRepository.deleteAll();
    }

    @Override
    public void remove(UUID id) {
        maps.clear();
        hoaDonCTRepository.deleteById(id);
    }


}
