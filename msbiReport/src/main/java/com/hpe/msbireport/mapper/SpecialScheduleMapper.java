package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.SpecialSchedule;
import com.hpe.msbireport.domain.SpecialScheduleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SpecialScheduleMapper {
    int countByExample(SpecialScheduleExample example);

    int deleteByExample(SpecialScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpecialSchedule record);

    int insertSelective(SpecialSchedule record);

    List<SpecialSchedule> selectByExampleWithRowbounds(SpecialScheduleExample example, RowBounds rowBounds);

    List<SpecialSchedule> selectByExample(SpecialScheduleExample example);

    SpecialSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpecialSchedule record, @Param("example") SpecialScheduleExample example);

    int updateByExample(@Param("record") SpecialSchedule record, @Param("example") SpecialScheduleExample example);

    int updateByPrimaryKeySelective(SpecialSchedule record);

    int updateByPrimaryKey(SpecialSchedule record);

    List<SpecialSchedule> selectAll(Map map);
}