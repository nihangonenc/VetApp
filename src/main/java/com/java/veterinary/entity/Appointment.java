package com.java.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "appointment_id", nullable = false)
    private long id;

    @Column (name = "appointment_date")
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn (name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn (name = "doctor_id")
    private Doctor doctor;

    @OneToOne (mappedBy = "appointment")
    @JsonIgnore
    private Report report;
}
