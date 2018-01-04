package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.LookupSummary;
import com.hpe.msbireport.domain.LookupSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LookupSummaryMapper {
    int countByExample(LookupSummaryExample example);

    int deleteByExample(LookupSummaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LookupSummary record);

    int insertSelective(LookupSummary record);

    List<LookupSummary> selectByExampleWithRowbounds(LookupSummaryExample example, RowBounds rowBounds);

    List<LookupSummary> selectByExample(LookupSummaryExample example);

    LookupSummary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LookupSummary record, @Param("example") LookupSummaryExample example);

    int updateByExample(@Param("record") LookupSummary record, @Param("example") LookupSummaryExample example);

    int updateByPrimaryKeySelective(LookupSummary record);

    int updateByPrimaryKey(LookupSummary record);

    List<LookupSummary> selectAllLookupSummaryCountByMonth(Integer monthIndicator);
}