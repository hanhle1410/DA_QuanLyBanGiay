package com.example.repository;


import com.example.entity.GioHangCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangCTRepository extends JpaRepository<GioHangCT , UUID> {



}
