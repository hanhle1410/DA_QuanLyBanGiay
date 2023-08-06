package com.example.demo.service;

import com.example.demo.entity.DeGiay;

import java.util.List;
import java.util.UUID;

public interface DeGiayService {

    List<DeGiay> getAll();

    DeGiay getById(UUID id);

    DeGiay detail(UUID id);

    void add(DeGiay deGiay);

    void update(DeGiay deGiay);

    void delete(UUID id);

}
