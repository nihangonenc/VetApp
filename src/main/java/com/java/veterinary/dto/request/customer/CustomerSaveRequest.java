package com.java.veterinary.dto.request.customer;

import com.java.veterinary.entity.Animal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    @NotNull (message = "Name is required")
    private String name;
    private String phone;
    @Email (message = "Please enter a valid e-mail")
    private String mail;
    private String address;
    private String city;

}
