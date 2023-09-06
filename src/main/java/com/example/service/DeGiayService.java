package com.example.service;

import com.example.entity.DeGiay;

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
