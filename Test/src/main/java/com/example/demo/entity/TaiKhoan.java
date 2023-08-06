package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TaiKhoan", schema = "dbo")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Size(max = 50)
    @Nationalized
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private NhanVien idNV;

}