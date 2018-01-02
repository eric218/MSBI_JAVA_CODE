package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.mapper.MonthReportMapper;
import com.hpe.msbireport.service.MonthReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 29/12/17
 * Descripthion: ...
 */
@Service
public class MonthReportServiceImpl implements MonthReportService {

    @Autowired
    MonthReportMapper monthReportMapper;

    @Override
    public List<MonthReport> selectAllMonthReportsByMonth(Integer monthIndicator) {
        return this.monthReportMapper.selectAllMonthReportsByMonth(monthIndicator);
    }
}
