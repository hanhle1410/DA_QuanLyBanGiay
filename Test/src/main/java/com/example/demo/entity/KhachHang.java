package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "KhachHang", schema = "dbo")
public class KhachHang {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Size(max = 30)
    @Column(name = "SDT", length = 30)
    private String sdt;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

}