package com.example.demo.repository;

import com.example.demo.entity.MauSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSP, UUID> {
}
