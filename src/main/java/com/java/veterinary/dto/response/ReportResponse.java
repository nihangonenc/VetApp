package com.java.veterinary.dto.response;

import com.java.veterinary.entity.Appointment;
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
    private List<Appointment> appointmentList;
}
