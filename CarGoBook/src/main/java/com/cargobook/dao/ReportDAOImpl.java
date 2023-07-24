package com.cargobook.dao;

import com.cargobook.model.Report;
import com.cargobook.util.ConnectionManager;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ReportDAOImpl implements ReportDAO {
    @Override
    public void addReport(Report report) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(report);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateReport(Report report) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(report);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteReport(Long reportId) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            Report report = em.find(Report.class, reportId);
            if (report != null) {
                em.getTransaction().begin();
                em.remove(report);
                em.getTransaction().commit();
            }
        }
    }

    @Override
    public Report findReportById(Long reportId) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.find(Report.class, reportId);
        }
    }

    @Override
    public List<Report> getReportsByDateRange(LocalDate startDate, LocalDate endDate) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT r FROM Report r WHERE r.date >= :startDate AND r.date <= :endDate", Report.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        }
    }

    @Override
    public List<Report> getAllReports() {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT r FROM Report r", Report.class).getResultList();
        }
    }
}