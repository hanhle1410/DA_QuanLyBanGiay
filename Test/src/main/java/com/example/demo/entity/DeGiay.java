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
@Data
@Getter
@Setter
@Entity
@Table(name = "DeGiay")
public class DeGiay {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ChatLieu", length = 50)
    private String chatLieu;

}