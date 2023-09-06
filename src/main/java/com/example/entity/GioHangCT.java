package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHangCT", schema = "dbo")
public class GioHangCT {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGioHang")
    private GioHang idGioHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP idChiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong ;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;
}