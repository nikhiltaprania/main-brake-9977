package com.cargobook.service;

import com.cargobook.dao.ReportDAO;
import com.cargobook.dao.ReportDAOImpl;
import com.cargobook.model.Report;

import java.time.LocalDate;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final ReportDAO reportDAO = new ReportDAOImpl();

    @Override
    public List<Report> generateReports(LocalDate startDate, LocalDate endDate) {
        return reportDAO.getReportsByDateRange(startDate, endDate);
    }
}