package com.java.veterinary.business.abstracts;


import com.java.veterinary.entity.Report;
import org.springframework.data.domain.Page;


public interface IReportService {

    Report get(long id);

    Report save(Report report);

    Report update(Report report);

    Page<Report> cursor(int page, int pageSize);

    String delete(long id);

}
