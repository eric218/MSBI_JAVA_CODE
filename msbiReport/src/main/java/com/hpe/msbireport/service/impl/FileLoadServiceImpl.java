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
public class FileLoadServiceImpl implements FileLoadService{
    @Autowired
    FilesLoadMapper filesLoadMapper;
    @Override
    public List<String> getInsertFile(String logLocation) throws IOException {
        List<String> autoInsertList = new ArrayList();
        Map dbMap = new HashMap();
        List<FilesLoad> DBList = filesLoadMapper.selectByExample(null);
        for(FilesLoad file : DBList){
            dbMap.put(file.getFileName(),file.getFileName());
        }

        //比对 assoc 和 newdaily 文件夹
        List<String> list = FileUtils.getfilesInFolder(logLocation);
        for(String fileName : list){
            if(fileName.contains("newassoc") || fileName.contains("newdaily")){
                //如果不在数据库里,则放入准备插入的list里
                if((String) dbMap.get(fileName) == null){
                    autoInsertList.add(fileName);
                }
            }
        }
       return autoInsertList;
    }
}
