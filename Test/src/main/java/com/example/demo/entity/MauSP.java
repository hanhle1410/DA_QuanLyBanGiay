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
@Table(name = "MauSP")
public class MauSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Mau", length = 50)
    private String mau;

}