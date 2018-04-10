package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.FilesLoad;
import com.hpe.msbireport.mapper.FilesLoadMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-30
 * Time: 5:47 PM
 */
@Service
public class FileLoadServiceImpl implements FileLoadService {
    @Autowired
    FilesLoadMapper filesLoadMapper;

    @Override
    public List<String> getInsertFile(String logLocation, String reportType) throws IOException {
        List<String> autoInsertList = new ArrayList();
        Map dbMap = new HashMap();
        List<FilesLoad> DBList = null;
        if("A".equals(reportType)){
            DBList = filesLoadMapper.selectByExample(null);
        }else if("B".equals(reportType)){
            DBList = filesLoadMapper.selectByExampleNonProd(null);
        }

        for (FilesLoad file : DBList) {
            dbMap.put(file.getFileName(), file.getFileName());
        }

        //比对 assoc 和 newdaily 文件夹
        List<String> list = FileUtils.getfilesInFolder(logLocation);
        for (String fileName : list) {
            //如果不在数据库里,则放入准备插入的list里,不包含原始的newclient_schedules
            if ((String) dbMap.get(fileName) == null && !fileName.contains("newclient_schedules")) {
                autoInsertList.add(fileName);
            }
        }
        return autoInsertList;
    }

    @Override
    public void insertFile(String fileName, String reportType) {
        FilesLoad file = new FilesLoad();
        file.setFileName(fileName);
        if("A".equals(reportType)){
            filesLoadMapper.insertSelective(file);
        }else if("B".equals(reportType)){
            filesLoadMapper.insertSelectiveNonProd(file);
        }

    }

    @Override
    public void deleteLaterRecord(String reportType) {
        Map map = new HashMap();
        if("A".equals(reportType)){
            map.put("files_load_table","files_load");
        }else if("B".equals(reportType)){
            map.put("files_load_table","files_load_non_prod");
        }
        filesLoadMapper.deleteLaterRecord(map);
    }
}
