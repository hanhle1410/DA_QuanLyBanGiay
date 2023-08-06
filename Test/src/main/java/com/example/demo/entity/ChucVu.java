package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChucVu", schema = "dbo")
public class ChucVu {
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


}