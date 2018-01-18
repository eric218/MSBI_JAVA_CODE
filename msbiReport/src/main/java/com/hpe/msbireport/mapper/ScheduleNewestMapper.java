package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.ScheduleNewest;

public interface ScheduleNewestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleNewest record);

    int insertSelective(ScheduleNewest record);

    ScheduleNewest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScheduleNewest record);

    int updateByPrimaryKey(ScheduleNewest record);
}