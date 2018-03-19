package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.FilesLoad;
import com.hpe.msbireport.domain.FilesLoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FilesLoadMapper {
    int countByExample(FilesLoadExample example);

    int deleteByExample(FilesLoadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FilesLoad record);

    int insertSelective(FilesLoad record);

    int insertSelectiveNonProd(FilesLoad record);

    List<FilesLoad> selectByExampleWithRowbounds(FilesLoadExample example, RowBounds rowBounds);

    List<FilesLoad> selectByExample(FilesLoadExample example);

    List<FilesLoad> selectByExampleNonProd(FilesLoadExample example);

    FilesLoad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FilesLoad record, @Param("example") FilesLoadExample example);

    int updateByExample(@Param("record") FilesLoad record, @Param("example") FilesLoadExample example);

    int updateByPrimaryKeySelective(FilesLoad record);

    int updateByPrimaryKey(FilesLoad record);
}