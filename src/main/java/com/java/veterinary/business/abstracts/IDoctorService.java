package com.java.veterinary.business.abstracts;


import com.java.veterinary.entity.Doctor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDoctorService {
    Doctor get(long id);
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    Page<Doctor> cursor(int page, int pageSize);
    String delete(long id);
    List<Doctor> getDoctorByName(String name);
}
