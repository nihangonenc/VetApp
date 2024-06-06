package com.java.veterinary.dto.request.report;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportSaveRequest {

    private String title;
    private double price;
    private Long appointmentId;
}
