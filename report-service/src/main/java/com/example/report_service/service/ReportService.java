package com.example.report_service.service;

import com.example.reportservice.model.Report;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class ReportService {

    private List<Report> reports = new ArrayList<>();

    public List<Report> getAllReports() {
        return reports;
    }

    public Report getReportById(String reportId) {
        return reports.stream().filter(r -> r.getId().equals(reportId)).findFirst().orElse(null);
    }

    public Report createReport(Report report) {
        report.setId(UUID.randomUUID().toString());
        reports.add(report);
        return report;
    }

    public void deleteReport(String reportId) {
        reports.removeIf(r -> r.getId().equals(reportId));
    }
}
