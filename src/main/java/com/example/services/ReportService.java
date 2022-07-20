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
        // Любой этаж
        Query queryAllFloors = em.createQuery("SELECT d.districtName as district, s.phone as sellerphone, b.buyerPhone as " +
                "buyerphone, (b.maxPrice - s.housePrice) AS income FROM Sellers s, Buyers b, BuyersDistricts bd, " +
                "Districts d WHERE b.buyerFilters = 0 AND b.id = bd.buyer.id AND d.id = bd.district.id AND s.sellerDistrict.id = d.id AND " +
                "b.houseAreaLTE >= s.houseArea AND b.houseAreaGTE <= s.houseArea AND b.maxPrice > s.housePrice ORDER BY " +
                "income DESC");
        // Не первый и не последний этаж
        Query queryNoLastAndFirstFloor = em.createQuery("SELECT d.districtName as district, s.phone as sellerphone, b.buyerPhone as " +
                "buyerphone, (b.maxPrice - s.housePrice) AS income FROM Sellers s, Buyers b, BuyersDistricts bd, " +
                "Districts d WHERE b.buyerFilters = 1 AND b.id = bd.buyer.id AND d.id = bd.district.id AND s.sellerDistrict.id = d.id AND " +
                "b.houseAreaLTE >= s.houseArea AND b.houseAreaGTE <= s.houseArea AND b.maxPrice > s.housePrice AND s.floorNumber != 1 " +
                "AND s.floorNumber < s.countFloors ORDER BY income DESC");
        List<Object[]> queryAllFloorsResult = queryAllFloors.getResultList();
        List<Object[]> queryNoLastAndFirstFloorResult = queryNoLastAndFirstFloor.getResultList();
        List<ReportDto> reportList = new ArrayList<>();
        for(Object[] objarr : queryAllFloorsResult)
            reportList.add(mapReportDto(objarr));
        for(Object[] objarr : queryNoLastAndFirstFloorResult)
            reportList.add(mapReportDto(objarr));
        return reportList;
    }

    private ReportDto mapReportDto(Object[] objarr){
        ReportDto reportDto = new ReportDto();
        reportDto.district = (String) objarr[0];
        reportDto.sellerPhone = (String) objarr[1];
        reportDto.buyerPhone = (String) objarr[2];
        reportDto.income = (Float) objarr[3];
        return reportDto;
    }
}
