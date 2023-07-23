package com.example.repository;

import com.example.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

    @Query("SELECT c FROM KhachHang c WHERE c.ten = :ten" )
    KhachHang findByTen(@Param("ten") String ten);

}
