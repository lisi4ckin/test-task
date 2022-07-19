package com.example.services;

import com.example.dto.ReportDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReportService {
    @Inject
    EntityManager em;

    public List<ReportDto> getReport(){
        Query query = em.createQuery("SELECT d.districtName as district, s.phone as sellerphone, b.buyerPhone as buyerphone, (b.maxPrice - s.housePrice) " +
                "AS income FROM Sellers s, Buyers b, BuyersDistricts bd, Districts d WHERE " +
                "b.id = bd.buyer.id AND d.id = bd.district.id AND s.sellerDistrict.id = d.id AND " +
                "b.houseAreaLTE <= s.houseArea AND b.houseAreaGTE >= s.houseArea AND b.maxPrice > s.housePrice ORDER BY " +
                "income DESC");
        List<Object[]> queryResult = query.getResultList();
        List<ReportDto> reportList = new ArrayList<>();
        for(Object[] objarr : queryResult){
            ReportDto reportDto = new ReportDto();
            reportDto.district = (String) objarr[0];
            reportDto.sellerPhone = (String) objarr[1];
            reportDto.buyerPhone = (String) objarr[2];
            reportDto.income = (Float) objarr[3];
            reportList.add(reportDto);
        }
        return reportList;

    }
}
