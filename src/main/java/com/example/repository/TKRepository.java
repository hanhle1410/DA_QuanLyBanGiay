package com.example.repository;

import com.example.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TKRepository extends JpaRepository<TaiKhoan, UUID> {

    @Query("SELECT c FROM TaiKhoan c WHERE c.username = :username AND c.password = :password")
    TaiKhoan findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
