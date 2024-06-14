package com.java.veterinary.dto.request.appointment;

import com.java.veterinary.entity.Animal;
import com.java.veterinary.entity.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {

    private LocalDateTime appointmentDate;
    @NotNull(message = "Please choose a animal")
    private Animal animal;
    @NotNull(message = "Please choose a doctor")
    private Doctor doctor;
}
