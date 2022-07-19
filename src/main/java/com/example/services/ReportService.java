package com.example.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class ReportService {
    @Inject
    EntityManager em;

    /*public List<Object> getReport(){
        Query query = em.createQuery("SELECT FROM Sellers sel, Buyers buy, ");
    }*/
}
