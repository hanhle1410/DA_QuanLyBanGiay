package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ChiTietSP", schema = "dbo")

public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSP", referencedColumnName = "Id")
    private MauSP idMauSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKichCo", referencedColumnName = "Id")
    private KichCo idKichCo;

    @Column(name = "SoLuong")
    private Integer soLuong;
}