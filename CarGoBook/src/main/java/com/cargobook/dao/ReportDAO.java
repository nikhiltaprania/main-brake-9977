package com.cargobook.dao;

import com.cargobook.model.Report;

import java.time.LocalDate;
import java.util.List;

public interface ReportDAO {
    void addReport(Report report);

    void updateReport(Report report);

    void deleteReport(Long reportId);

    Report findReportById(Long reportId);

    List<Report> getReportsByDateRange(LocalDate startDate, LocalDate endDate);

    List<Report> getAllReports();
}