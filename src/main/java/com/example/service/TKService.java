package com.example.service;

import com.example.entity.TaiKhoan;
import org.springframework.data.repository.query.Param;

public interface TKService {

    TaiKhoan findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    TaiKhoan authenticate(String username, String password);
}
