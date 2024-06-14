package com.java.veterinary.dto.request.report;
import com.java.veterinary.entity.Appointment;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportUpdateRequest {

    @Positive(message = "ID pozitif sayı olmalı")
    private long id;
    private String title;
    private double price;
    private Appointment appointment;

}
