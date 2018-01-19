package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.MonthReportExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ProcedureCallMapper {
    void insertFile(Map map);
}