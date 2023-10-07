package com.example.phonemanagement.service;

import com.example.phonemanagement.entity.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);

    SmartPhone update(SmartPhone smartPhone);
}
