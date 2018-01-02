package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.domain.LookupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LookupMapper {

    List<Lookup> selectAllLookup();

    int countByExample(LookupExample example);

    int deleteByExample(LookupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lookup record);

    int insertSelective(Lookup record);

    List<Lookup> selectByExampleWithRowbounds(LookupExample example, RowBounds rowBounds);

    List<Lookup> selectByExample(LookupExample example);

    Lookup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lookup record, @Param("example") LookupExample example);

    int updateByExample(@Param("record") Lookup record, @Param("example") LookupExample example);

    int updateByPrimaryKeySelective(Lookup record);

    int updateByPrimaryKey(Lookup record);
}