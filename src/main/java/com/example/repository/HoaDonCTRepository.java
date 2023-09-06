package com.example.repository;

import com.example.entity.HoaDonCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonCT, UUID> {


}
