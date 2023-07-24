package com.cargobook.service;

import com.cargobook.model.Report;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    List<Report> generateReports(LocalDate startDate, LocalDate endDate);
}