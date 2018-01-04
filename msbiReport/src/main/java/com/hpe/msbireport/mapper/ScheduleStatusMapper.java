package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.ScheduleStatus;
import com.hpe.msbireport.domain.ScheduleStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ScheduleStatusMapper {
    int countByExample(ScheduleStatusExample example);

    int deleteByExample(ScheduleStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleStatus record);

    int insertSelective(ScheduleStatus record);

    List<ScheduleStatus> selectByExampleWithRowbounds(ScheduleStatusExample example, RowBounds rowBounds);

    List<ScheduleStatus> selectByExample(ScheduleStatusExample example);

    ScheduleStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheduleStatus record, @Param("example") ScheduleStatusExample example);

    int updateByExample(@Param("record") ScheduleStatus record, @Param("example") ScheduleStatusExample example);

    int updateByPrimaryKeySelective(ScheduleStatus record);

    int updateByPrimaryKey(ScheduleStatus record);
}