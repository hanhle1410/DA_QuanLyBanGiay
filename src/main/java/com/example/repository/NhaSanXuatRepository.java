package com.example.repository;

import com.example.entity.NhaSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSX, UUID> {
}
