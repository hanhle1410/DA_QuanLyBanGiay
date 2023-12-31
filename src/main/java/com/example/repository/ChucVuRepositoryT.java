package com.example.repository;

import com.example.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChucVuRepositoryT extends JpaRepository<ChucVu, UUID> {
}
