package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "LichLamViec", schema = "dbo")
public class LichLamViec {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private SanPham idNV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCaLam", referencedColumnName = "Id")
    private MauSP idCaLam;

}
