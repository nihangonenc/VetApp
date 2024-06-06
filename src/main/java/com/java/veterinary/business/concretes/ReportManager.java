package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IReportService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.dao.ReportRepo;
import com.java.veterinary.entity.Doctor;
import com.java.veterinary.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportManager implements IReportService {
    private final ReportRepo reportRepo;

    public ReportManager(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public Report get(long id) {
        return this.reportRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Report save(Report report) {
        Optional<Report> isReportExist = reportRepo.findReportByTitleAndPriceAndAppointmentId(report.getTitle(), report.getPrice(), report.getAppointment().getId());
        if (isReportExist.isEmpty()) {
            return this.reportRepo.save(report);
        }
        throw new RuntimeException("Bu Doktor Sistemde Kayıtlı");
    }

    @Override
    public Report update(Report report) {
        Optional<Report> isReportExist = reportRepo.findById(report.getId());
        if (isReportExist.isEmpty()){
            throw new RuntimeException("Rapor Sistemde Bulunamadı");
        }
        this.get(report.getId());
        return this.reportRepo.save(report);
    }

    @Override
    public Page<Report> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.reportRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Report> isReportExist = reportRepo.findById(id);
        if (isReportExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            reportRepo.delete(isReportExist.get());
            return Msg.OK;
        }
    }
}
