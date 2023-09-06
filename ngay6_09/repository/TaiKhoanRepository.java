package com.example.repository;

import com.example.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
}
