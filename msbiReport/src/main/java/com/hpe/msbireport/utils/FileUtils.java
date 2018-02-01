package com.hpe.msbireport.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-30
 * Time: 4:44 PM
 */
public  class FileUtils {
    public static List<String> getfilesInFolder(String logLocation) throws IOException {
        List<String> list = new ArrayList();
        File file = new File(logLocation);
        File[] fileList = file.listFiles();
        for(File fileTemp : fileList){
            if(fileTemp.isFile()){
                list.add(fileTemp.getName());
            }
        }
        return list;
    }
}
