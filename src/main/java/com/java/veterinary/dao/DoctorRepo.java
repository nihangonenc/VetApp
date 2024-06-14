package com.java.veterinary.dao;


import com.java.veterinary.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByNameAndMail (String name, String mail);
    List<Doctor> findByNameContainingIgnoreCase(String name);
}
