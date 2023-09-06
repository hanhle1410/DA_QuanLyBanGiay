package com.example.repository;


import com.example.entity.HoaDon;
import com.example.entity.KhachHang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

    @Query("SELECT MAX(hd.ma) FROM HoaDon hd")
    String getBiggestMa();

    @Query("SELECT hd FROM HoaDon hd WHERE hd.ngayTao = :ngayTao AND hd.trangThai = :trangThai ORDER BY hd.ma DESC")
    List<HoaDon> findAllByNgayTaoAndTrangThai(@Param("ngayTao") LocalDate ngayTao, @Param("trangThai") Integer trangThai);

    HoaDon findByMa(String maHoaDon);

}
