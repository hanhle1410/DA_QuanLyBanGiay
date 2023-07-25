package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HoaDon", schema = "dbo")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH", referencedColumnName = "Id")
    private KhachHang idKH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private NhanVien idNV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdVoucher", referencedColumnName = "Id")
    private Voucher idVoucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham idSP;


    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "TongTien", precision = 20)
    private BigDecimal tongTien;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "idHoaDon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonCT> hoaDonCTList;
}