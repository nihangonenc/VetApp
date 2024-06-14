package com.java.veterinary.dto.response;

import com.java.veterinary.entity.Appointment;
import com.java.veterinary.entity.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private long id;
    private String title;
    private double price;
    private Appointment appointment;
    private List<Vaccine> vaccineList;
}
