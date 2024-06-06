package com.java.veterinary.dao;

import com.java.veterinary.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReportRepo extends JpaRepository<Report,Long> {

    Optional<Report> findByAppointmentId(Long appointmentId);
    Optional<Report> findReportByTitleAndPriceAndAppointmentId(String title, double price, Long appointment_id);
}
