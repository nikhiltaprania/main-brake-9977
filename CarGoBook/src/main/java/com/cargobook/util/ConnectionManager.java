package com.cargobook.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
    private static final String persistenceUnitName = "Connected";
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            }
            return emf.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create EntityManager", e.getCause());
        }
    }
}