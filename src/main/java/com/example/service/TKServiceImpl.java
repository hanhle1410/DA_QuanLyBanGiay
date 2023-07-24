package com.example.service;

import com.example.entity.TaiKhoan;
import com.example.repository.TKRepository;
import com.example.service.impl.TKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKServiceImpl implements TKService {

    @Autowired
    private TKRepository tkRepository;

    @Override
    public TaiKhoan findByUsernameAndPassword(String username, String password) {
        return tkRepository.findByUsernameAndPassword(username, password);
    }

}
