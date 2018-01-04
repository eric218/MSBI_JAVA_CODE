package com.hpe.msbireport.service;

import com.hpe.msbireport.domain.MonthReport;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 29/12/17
 * Description: ...
 */
public interface MonthReportService {

    List<MonthReport> selectAllMonthReportsByMonth(Integer monthIndicator);
    
    public boolean formatMonthReportTable(String currentDate) throws Exception;
    
    List<Integer> selectAllAvaiableMonthFromDB();
}
