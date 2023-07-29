package com.example.service;

import com.example.entity.GioHang;
import com.example.entity.GioHangCT;
import com.example.entity.HoaDon;
import com.example.entity.HoaDonCT;
import com.example.repository.GioHangRepository;
import com.example.repository.HoaDonRepository;
import com.example.service.impl.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;



//    @Override
//    public void thanhToan(GioHang gioHang) {
//        HoaDon hoaDon = new HoaDon();
//        hoaDon.setIdKH(gioHang.getIdKH());
//        hoaDon.setIdNV(gioHang.getIdNV());
//        hoaDon.setNgayTao(LocalDate.now());
//        hoaDon.setTrangThai(0);
//
//        BigDecimal tongTien = BigDecimal.ZERO;
//        for (GioHangCT gioHangCT : gioHang.getGioHangCTList()) {
//            HoaDonCT hoaDonCT = new HoaDonCT();
//          //  hoaDonCT.setIdSP(gioHangCT.getIdSP());
//            hoaDonCT.setSoLuong(BigDecimal.valueOf(gioHangCT.getSoLuong()));
//            hoaDonCT.setDonGia(gioHangCT.getDonGia());
//            hoaDonCT.setIdHoaDon(hoaDon);
//            hoaDon.getHoaDonCTList().add(hoaDonCT);
//
//            tongTien = tongTien.add(gioHangCT.getDonGia().multiply(new BigDecimal(gioHangCT.getSoLuong())));
//        }
//
//        hoaDon.setTongTien(tongTien);
//        hoaDonRepository.save(hoaDon);
//        gioHangRepository.delete(gioHang);
//    }


}
