package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.MonthReportExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MonthReportMapper {
    int countByExample(MonthReportExample example);

    int deleteByExample(MonthReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonthReport record);

    int insertSelective(MonthReport record);

    List<MonthReport> selectByExampleWithRowbounds(MonthReportExample example, RowBounds rowBounds);

    List<MonthReport> selectByExample(MonthReportExample example);

    MonthReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonthReport record, @Param("example") MonthReportExample example);

    int updateByExample(@Param("record") MonthReport record, @Param("example") MonthReportExample example);

    int updateByPrimaryKeySelective(MonthReport record);

    int updateByPrimaryKey(MonthReport record);

    List<MonthReport> selectAllMonthReportsByMonth(Integer monthIndicator);

    List<MonthReport> selectAllMonthReportsByMonthForNon_Prod(Integer monthIndicator);

    List<MonthReport> selectAll(Map map);
    
    List<Integer> selectAllAvaiableMonthFromDB();
    
    List<MonthReport> selectAllForUpate(Map map);
    
    void insertBatch(List<MonthReport> list);
    
    void deleteByMonth(Map map);
}