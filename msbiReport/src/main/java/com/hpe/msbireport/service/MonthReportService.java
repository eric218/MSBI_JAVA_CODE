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
    
    /**
     * 
     * @param startDate 开始日期，可为null。null：表示只查询当前日期；Not null：表示从此时间点到当前日期所有数据。
     * @param currentDate 当前日期，不可为null。表示需要更新数据的日期。
     * @param hasHistory 是否查询历史记录，用来判断月份中某些天数是否被修改。true：需要历史；false：不需要历史。
     * @param insertSize 插入数据条数，不可为null。此接口为批量写入接口，需设置每次批量的大小。如：1000，表示1000条写入一次数据库。
     * @return true：成功；false：失败。
     * @throws Exception
     */
    public boolean formatMonthReportTable(String startDate,String currentDate,boolean hasHistory,int insertSize) throws Exception;
    
    List<Integer> selectAllAvaiableMonthFromDB();
}
