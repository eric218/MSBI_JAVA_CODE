package com.hpe.msbireport.service;

import com.hpe.msbireport.domain.TotalSummary;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 3/1/18
 * Description: ...
 */
public interface TotalSummaryService {

    List<TotalSummary> selectAllTotalSummaryByMonth(Integer monthIndicator);
}
