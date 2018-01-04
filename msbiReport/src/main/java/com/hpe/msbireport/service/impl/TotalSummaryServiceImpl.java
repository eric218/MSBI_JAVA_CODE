package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.TotalSummary;
import com.hpe.msbireport.mapper.TotalSummaryMapper;
import com.hpe.msbireport.service.TotalSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 3/1/18
 * Description: ...
 */
@Service
public class TotalSummaryServiceImpl implements TotalSummaryService {

    @Autowired
    TotalSummaryMapper totalSummaryMapper;

    @Override
    public List<TotalSummary> selectAllTotalSummaryByMonth(Integer monthIndicator) {
        return this.totalSummaryMapper.selectAllTotalSummaryByMonth(monthIndicator);
    }
}
