package com.java.veterinary.api;

import com.java.veterinary.business.abstracts.IReportService;
import com.java.veterinary.core.config.modelMapper.IModelMapperService;
import com.java.veterinary.core.result.Result;
import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.core.utilies.ResultHelper;
import com.java.veterinary.dto.request.report.ReportSaveRequest;
import com.java.veterinary.dto.request.report.ReportUpdateRequest;
import com.java.veterinary.dto.response.CursorResponse;
import com.java.veterinary.dto.response.ReportResponse;
import com.java.veterinary.entity.Report;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reports")
public class ReportController {
    private final IReportService reportService;
    private final IModelMapperService modelMapper;

    public ReportController(IReportService reportService, IModelMapperService modelMapper) {
        this.reportService = reportService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ReportResponse> save(@Valid @RequestBody ReportSaveRequest reportSaveRequest) {
        Report saveReport = this.modelMapper.forRequest().map(reportSaveRequest, Report.class);
        this.reportService.save(saveReport);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveReport, ReportResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ReportResponse> get(@PathVariable("id") int id) {
        Report report = this.reportService.get(id);
        ReportResponse reportResponse = this.modelMapper.forResponse().map(report, ReportResponse.class);
        return ResultHelper.success(reportResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ReportResponse> update(@Valid @RequestBody ReportUpdateRequest reportUpdateRequest){
        this.reportService.get(reportUpdateRequest.getId());
        Report updateReport = this.modelMapper.forRequest().map(reportUpdateRequest, Report.class);
        this.reportService.update(updateReport);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateReport, ReportResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.reportService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<ReportResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize){

        Page<Report> reportPage = this.reportService.cursor(page,pageSize);
        Page<ReportResponse> reportResponsePage = reportPage
                .map(report -> this.modelMapper.forResponse().map(report, ReportResponse.class));
        return ResultHelper.cursor(reportResponsePage);
    }
}
