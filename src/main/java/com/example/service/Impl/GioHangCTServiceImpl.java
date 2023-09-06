package com.example.service.impl;




import com.example.entity.GioHangCT;

import com.example.repository.ChiTietSPRepository;
import com.example.repository.GioHangCTRepository;
import com.example.repository.HoaDonCTRepository;
import com.example.service.ChiTietSPService;
import com.example.service.GioHangCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@SessionScope
@Service
public class GioHangCTServiceImpl implements GioHangCTService {

    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private GioHangCTRepository gioHangCTRepository;
    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;

    private final Map<UUID, GioHangCT> maps = new HashMap<>();

    @Override
    public void add(GioHangCT item) {
        UUID id = item.getIdChiTietSP().getId();
        GioHangCT cartItem = maps.get(id);
        if (cartItem == null) {
            maps.put(id, item);
            this.gioHangCTRepository.save(item);
        } else {
            cartItem.setSoLuong(cartItem.getSoLuong() + 1);
            this.gioHangCTRepository.save(cartItem);
        }
    }
    @Override
    public void remove(UUID id) {
        maps.clear();
         gioHangCTRepository.deleteById(id);
    }
    @Override
    public void clear() {
        maps.clear();
        gioHangCTRepository.deleteAll();
    }
    @Override
    public List<GioHangCT> getAllItems() {
        return gioHangCTRepository.findAll();
    }
    @Override
    public GioHangCT update(UUID id, int soLuong) {
        GioHangCT cartItem = gioHangCTRepository.findById(id).orElse(null);
        if (cartItem != null) {
            cartItem.setSoLuong(soLuong);
            gioHangCTRepository.save(cartItem);
        }
        return cartItem;
    }
    @Override
    public int getCount() {
        List<GioHangCT> cartItems = getAllItems();
        if (cartItems != null) {
            return cartItems.size();
        }
        return 0;
    }
    @Override
    public BigDecimal getAmount() {
        Map<UUID, GioHangCT> gioHangCTMap = gioHangCTRepository.findAll().stream()
                .collect(Collectors.toMap(GioHangCT::getId, gioHangCT -> gioHangCT));
        BigDecimal totalAmount = gioHangCTMap.values().stream()
                .map(item -> item.getDonGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAmount;
    }

}
