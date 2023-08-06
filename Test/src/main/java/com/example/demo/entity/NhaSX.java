package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Data
@Setter
@Entity
@Table(name = "NhaSX")
public class NhaSX {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

}