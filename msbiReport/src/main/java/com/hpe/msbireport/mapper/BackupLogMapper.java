package com.hpe.msbireport.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hpe.msbireport.domain.BackupLog;
import com.hpe.msbireport.domain.RunTimeByDate;

public interface BackupLogMapper {
    int deleteByPrimaryKey(String message);

    int insert(BackupLog record);

    int insertSelective(BackupLog record);

    BackupLog selectByPrimaryKey(String message);

    int updateByPrimaryKeySelective(BackupLog record);

    int updateByPrimaryKey(BackupLog record);
    
    List<RunTimeByDate> selectRunTimeByDate(Map map);
    
    BackupLog selectEndDate(Map map);
    
    BackupLog selectStartDate(Map map);
}