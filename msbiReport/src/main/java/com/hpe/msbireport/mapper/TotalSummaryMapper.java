package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.TotalSummary;
import com.hpe.msbireport.domain.TotalSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TotalSummaryMapper {
    int countByExample(TotalSummaryExample example);

    int deleteByExample(TotalSummaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalSummary record);

    int insertSelective(TotalSummary record);

    List<TotalSummary> selectByExampleWithRowbounds(TotalSummaryExample example, RowBounds rowBounds);

    List<TotalSummary> selectByExample(TotalSummaryExample example);

    TotalSummary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalSummary record, @Param("example") TotalSummaryExample example);

    int updateByExample(@Param("record") TotalSummary record, @Param("example") TotalSummaryExample example);

    int updateByPrimaryKeySelective(TotalSummary record);

    int updateByPrimaryKey(TotalSummary record);
}