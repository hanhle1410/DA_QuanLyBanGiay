package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang", schema = "dbo")
public class GioHang {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH")
    private KhachHang idKH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV")
    private NhanVien idNV;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Size(max = 30)
    @Column(name = "SDT", length = 30)
    private String sdt;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @OneToMany(mappedBy = "idGioHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GioHangCT> gioHangCTList;


}