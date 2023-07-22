package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SanPham", schema = "dbo")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSP idDongSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDeGiay", referencedColumnName = "Id")
    private DeGiay idDeGiay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNSX", referencedColumnName = "Id")
    private NhaSX idNSX;

    @Column(name = "NgayNhapHang")
    private LocalDate ngayNhapHang;

    @Column(name = "GiaNhap", precision = 20)
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", precision = 20)
    private BigDecimal giaBan;

    @Size(max = 50)
    @Nationalized
    @Column(name = "XuatXu", length = 50)
    private String xuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;


//    @OneToMany(mappedBy = "SanPham", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ChiTietSP> chiTietSPList;
//    public SanPham(UUID id, DongSP idDongSP, DeGiay idDeGiay, NhaSX idNSX, LocalDate ngayNhapHang, BigDecimal giaNhap, BigDecimal giaBan, String xuatXu, Integer trangThai) {
//        this.id = id;
//        this.idDongSP = idDongSP;
//        this.idDeGiay = idDeGiay;
//        this.idNSX = idNSX;
//        this.ngayNhapHang = ngayNhapHang;
//        this.giaNhap = giaNhap;
//        this.giaBan = giaBan;
//        this.xuatXu = xuatXu;
//        this.trangThai = trangThai;
//    }
//
//    public SanPham() {
//
//    }

}