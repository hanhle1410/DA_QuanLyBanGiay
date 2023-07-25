package com.example.service;

import com.example.entity.TaiKhoan;
import com.example.repository.TKRepository;
import com.example.repository.TaiKhoanRepository;
import com.example.service.impl.TKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKServiceImpl implements TKService {

    @Autowired
    private TKRepository tkRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan findByUsernameAndPassword(String username, String password) {
        return tkRepository.findByUsernameAndPassword(username, password);
    }

    public TaiKhoan authenticate(String username, String password) {
        TaiKhoan user = taiKhoanRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
