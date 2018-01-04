package com.hpe.msbireport.service;

import com.hpe.msbireport.domain.LookupSummary;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 3/1/18
 * Description: ...
 */
public interface LookupSummaryService {
    List<LookupSummary> selectAllLookupSummaryCountByMonth(Integer monthIndicator);
}
