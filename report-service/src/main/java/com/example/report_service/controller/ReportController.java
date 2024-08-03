package com.example.report_service.controller;


@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable String reportId) {
        return reportService.getReportById(reportId);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @DeleteMapping("/{reportId}")
    public void deleteReport(@PathVariable String reportId) {
        reportService.deleteReport(reportId);
    }
}
