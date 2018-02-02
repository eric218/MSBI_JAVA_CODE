package com.hpe.msbireport;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.service.ProcedureCallService;
import com.hpe.msbireport.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-16
 * Time: 11:03 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcedureCall {
    @Value("${msbi.app.log.location1}")
    private String logLocation;
    @Value("${msbi.app.copyfile.to}")
    private String scheduleLocation;
    @Value("${msbi.app.copyfile.from}")
    private String oldPath;

    @Value("${msbi.app.copyfile.to}")
    private String newPath;
    @Autowired
    private ProcedureCallService procedureCallService;
    @Autowired
    private FileLoadService fileLoadService;
    @Test
    @Transactional
    public void num(){
        Map map = new HashMap();
        map.put("insertSql","load data local infile \"C:/MSBI/log/log_2017_03_30.txt_20170406_200\" into table logtxt(log)  set LOG_TYPE=1;");
        procedureCallService.insertFile(map);
        map.put("insertSql","delete from logtxt WHERE LOG_TYPE=1;");
        procedureCallService.insertFile(map);
    }

    @Test
    public void test2() throws Exception {
//        List<String> list = fileLoadService.getInsertFile(logLocation);
//        procedureCallService.insertLog(list,logLocation);
//        procedureCallService.insertMain(list,logLocation);
//        System.out.println(list.size());
        procedureCallService.autoRun(logLocation,scheduleLocation);
    }

    @Test
    public void test3() throws Exception{

        List<String> oldFileName = new ArrayList<String>();
        List<String> newFileName = new ArrayList<String>();
        Map<String,File> oldFileMap = new HashMap<String, File>();
        //获得源文件
        File oldFiles = new File(oldPath);
        File[] oldArray = oldFiles.listFiles();
        //把符合要求的文件保存为Map，key：文件名 value：File对象
        for (File file : oldArray) {
            if(file.getName().contains("schedules.txt")){
                String a = file.getName().split("_")[2];
                String keyTime = "";
                if(a.length() == 7){
                    String y = a.substring(0, 4);
                    String m = "0"+a.substring(4, 5);
                    String d = a.substring(a.length()-2, a.length());
                    keyTime = y+m+d;
                }else if(a.length() == 8){
                    keyTime = a;
                }else if(a.length() == 6){
                    String y = a.substring(0, 4);
                    String m = "0"+a.substring(4, 5);
                    String d = "0"+a.substring(a.length()-1, a.length());
                    keyTime = y+m+d;
                }

                if("" != keyTime){
                    oldFileMap.put(keyTime, file);
                    oldFileName.add(keyTime);
                }
            }
        }

        //获得已复制的文件名，用来对比
        File newFiles = new File(newPath);
        File[] newArray = newFiles.listFiles();
        for (File file : newArray) {
            String keyName = file.getName().split("_")[1].substring(0,8);
            newFileName.add(keyName);
        }

        //对比源文件和已复制文件名，获得为复制的文件名
        for (String newName : newFileName) {
            for (int i = 0; i < oldFileName.size(); i++) {
                if(newName.equals(oldFileName.get(i))){
                    oldFileName.remove(i);
                }
            }
        }

        for (String name : oldFileName) {
            FileChannel inputChannel = null;
            FileChannel outputChannel = null;
            inputChannel = new FileInputStream(oldFileMap.get(name)).getChannel();
            outputChannel = new FileOutputStream(new File(newPath+"schedule_"+name+".txt")).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            inputChannel.close();
            outputChannel.close();
        }
    }

}
