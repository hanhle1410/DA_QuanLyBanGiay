package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSP idDongSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDeGiay",referencedColumnName = "Id")
    private DeGiay idDeGiay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNSX", referencedColumnName = "Id")
    private NhaSX idNhaSX;

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

}