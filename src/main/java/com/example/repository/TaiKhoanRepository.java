package com.example.repository;

import com.example.entity.KhachHang;
import com.example.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, UUID> {

    @Query("SELECT c FROM TaiKhoan c WHERE c.username = :username" )
    TaiKhoan findByUsername(@Param("username") String username);

}
