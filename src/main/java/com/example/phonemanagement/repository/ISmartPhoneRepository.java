package com.example.phonemanagement.repository;

import com.example.phonemanagement.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<SmartPhone,Long> {

}
