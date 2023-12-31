package com.example.repository;

import com.example.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSP, UUID> {
}
