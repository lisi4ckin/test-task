package com.example.services;

import com.example.dto.ReportDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void getXlsFile(List<ReportDto> reportObjects) throws IOException {
        Workbook reportWorkbook = new XSSFWorkbook();
        Sheet sheet = reportWorkbook.createSheet("report");
        Row headers = sheet.createRow(0);
        Cell headerCell = headers.createCell(0);
        headerCell.setCellValue("District");

        headerCell = headers.createCell(1);
        headerCell.setCellValue("Phone seller");


        headerCell = headers.createCell(2);
        headerCell.setCellValue("Phone buyer");


        headerCell = headers.createCell(3);
        headerCell.setCellValue("Incoming");

        for (int i = 1; i < reportObjects.size() + 1; i++){
            Row dataRow = sheet.createRow(i);
            Cell dataCell = dataRow.createCell(0);
            dataCell.setCellValue(reportObjects.get(i - 1).district);

            dataCell = dataRow.createCell(1);
            dataCell.setCellValue(reportObjects.get(i - 1).sellerPhone);

            dataCell = dataRow.createCell(2);
            dataCell.setCellValue(reportObjects.get(i - 1).buyerPhone);

            dataCell = dataRow.createCell(3);
            dataCell.setCellValue(reportObjects.get(i - 1).income);
        }
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        reportWorkbook.write(outputStream);
    }
}
