package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.TotalTitle;
import com.hpe.msbireport.domain.TotalTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TotalTitleMapper {

    List<TotalTitle> selectAllTotalTitle();

    int countByExample(TotalTitleExample example);

    int deleteByExample(TotalTitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalTitle record);

    int insertSelective(TotalTitle record);

    List<TotalTitle> selectByExampleWithRowbounds(TotalTitleExample example, RowBounds rowBounds);

    List<TotalTitle> selectByExample(TotalTitleExample example);

    TotalTitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalTitle record, @Param("example") TotalTitleExample example);

    int updateByExample(@Param("record") TotalTitle record, @Param("example") TotalTitleExample example);

    int updateByPrimaryKeySelective(TotalTitle record);

    int updateByPrimaryKey(TotalTitle record);
}