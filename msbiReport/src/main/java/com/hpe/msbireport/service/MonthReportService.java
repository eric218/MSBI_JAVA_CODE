package com.hpe.msbireport.service;

import com.hpe.msbireport.domain.MonthReport;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * @param currentDate 当前日期，可为null。null:表示更新当前日期。
     * @param hasHistory 是否查询历史记录，用来判断月份中某些天数是否被修改。true：需要历史；false：不需要历史。
     * @param insertSize 插入数据条数，0:表示不设置写入条数。此接口为批量写入接口，需设置每次批量的大小。如：1000，表示1000条写入一次数据库。
     * @return true：成功；false：失败。
     * @throws Exception
     */
    public boolean formatMonthReportTable(String startDate,String currentDate,boolean hasHistory,int insertSize,Map tableMap) throws Exception;
    
    /**
     * 
     * @param day 以currentDate为起点，向前推几天
     * @param currentDate 当前日期
     * @param hasHistory 是否需要历史
     * @param insertSize 写入记录条数大小
     * @return
     * @throws Exception
     */
    public boolean formatMonthReportTableForTask(int day,String currentDate,boolean hasHistory,int insertSize,String reportType) throws Exception;
    
    List<Integer> selectAllAvaiableMonthFromDB();
    
    /**
     * 从backup_log表中获得最大时间，用来做更新monthreport表的current时间
     * @return
     */
    Date getEndDate(Map map);
    
    /**
     * 从backup_log表中获得开始时间，初始化monthreport表
     * @return
     */
    Date getStartDate(Map map);

    /**
     * 查询所有schedule 列表
     * @return
     */
    List<MonthReport> selectAll(Map map);

    public void autoDailyGenerate(String dailyReportPath,String dailyHistoryReportPath)throws Exception;
    public void autoMonthlyGenerate(String monthlyReportPath)throws Exception;
}
