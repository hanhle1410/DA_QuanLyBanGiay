package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "CaLam", schema = "dbo")
public class CaLam {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenCa", length = 50)
    private String tenCa;
}
