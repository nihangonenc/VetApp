package com.java.veterinary.dto.request.report;


import com.java.veterinary.entity.Appointment;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportSaveRequest {
    @NotNull(message = "Title is required")
    private String title;
    private double price;
    private Appointment appointment;
}
