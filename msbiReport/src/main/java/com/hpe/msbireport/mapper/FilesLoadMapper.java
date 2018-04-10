package com.hpe.msbireport.mapper;

import com.hpe.msbireport.domain.FilesLoad;
import com.hpe.msbireport.domain.FilesLoadExample;
import java.util.List;
import java.util.Map;

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

    /**
     * @Author: Wang,Wei
     * @Description: 清除客户手动添加的log(防止到了指定日期没跑批),客户手动添加规则,比当前日期大
     * @Param: [map]
     * @return: int
     * @Date: 4/10/2018
     * @time: 3:59 PM
     */
    int deleteLaterRecord(Map map);
}