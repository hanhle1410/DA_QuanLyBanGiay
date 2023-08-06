package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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