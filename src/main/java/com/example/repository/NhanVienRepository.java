package com.example.repository;

import com.example.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query("SELECT c FROM NhanVien c WHERE c.email = :email" )
    NhanVien findByEmail(@Param("email") String email);

}
