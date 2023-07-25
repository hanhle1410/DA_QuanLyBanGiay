package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HoaDonCT", schema = "dbo")
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon idHoaDon;


    @Column(name = "SoLuong")
    private BigDecimal soLuong;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;

}