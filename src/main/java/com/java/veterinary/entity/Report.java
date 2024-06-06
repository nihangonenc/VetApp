package com.java.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table (name = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "report_id", nullable = false)
    private long id;

    @Column (name = "report_title")
    private String title;

    @Column (name = "report_price")
    private double price;

    @OneToMany (mappedBy = "report", cascade = CascadeType.REMOVE)
    @JsonIgnore //toStringte döngüye girmemesi için
    private List<Vaccine> vaccineList;

    @OneToOne
    @JoinColumn (name = "appointment_id")
    private Appointment appointment;

}
