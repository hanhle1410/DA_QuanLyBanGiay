package com.example.repository;

import com.example.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepositoryT extends JpaRepository<KhachHang, UUID> {
}
