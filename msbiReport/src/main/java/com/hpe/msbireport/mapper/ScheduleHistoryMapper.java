package com.hpe.msbireport.mapper;

import java.util.List;

import com.hpe.msbireport.domain.ScheduleHistory;


public interface ScheduleHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleHistory record);

    int insertSelective(ScheduleHistory record);

    ScheduleHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScheduleHistory record);

    int updateByPrimaryKey(ScheduleHistory record);
    
    List<ScheduleHistory> selectByEnabled(Integer enabled) throws Exception;
}