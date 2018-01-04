package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.LookupSummary;
import com.hpe.msbireport.mapper.LookupSummaryMapper;
import com.hpe.msbireport.service.LookupSummaryService;
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
public class LookupSummaryServiceImpl implements LookupSummaryService {

    @Autowired
    LookupSummaryMapper lookupSummaryMapper;

    @Override
    public List<LookupSummary> selectAllLookupSummaryCountByMonth(Integer monthIndicator) {
        return this.lookupSummaryMapper.selectAllLookupSummaryCountByMonth(monthIndicator);
    }
}
