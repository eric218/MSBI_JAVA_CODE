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

    /**
     * @Author: Wang,Wei
     * @Description: 删除文件夹里的特定文件
     * @Param: [content: 特定文件 logLocation: 文件路径]
     * @return: void
     * @Date: 4/9/2018
     * @time: 4:00 PM
     */
    public static void delteThefiles(String content,String logLocation) throws IOException {
        File file = new File(logLocation);
        File[] fileList = file.listFiles();
        for(File fileTemp : fileList){
            if(fileTemp.isFile() && fileTemp.getName().contains(content)){
                fileTemp.delete();
            }
        }
    }
}
