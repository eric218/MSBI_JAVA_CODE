package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.ScheduleMain;

public interface ScheduleMainMapper {
    int deleteByPrimaryKey(String message);

    int insert(ScheduleMain record);

    int insertSelective(ScheduleMain record);

    ScheduleMain selectByPrimaryKey(String message);

    int updateByPrimaryKeySelective(ScheduleMain record);

    int updateByPrimaryKey(ScheduleMain record);
}