package com.example.repository;

import com.example.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepositoryT extends JpaRepository<NhanVien, UUID> {
}
