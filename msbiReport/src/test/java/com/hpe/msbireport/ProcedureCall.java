package com.hpe.msbireport;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.ProcedureCallService;
import com.hpe.msbireport.utils.CopyFileUtils;
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
    MonthReportService monthReportService;
    @Autowired
    private FileLoadService fileLoadService;
    @Value("${msbi.app.file.location.monthly}")
    private String monthlyReportPath;

    @Value("${msbi.app.file.location.daily}")
    private String dailyReportPath;

    @Value("${msbi.app.monthreport.day}")
    private int day;

//    @Test
//    @Transactional
//    public void num(){
//        Map map = new HashMap();
//        map.put("insertSql","load data local infile \"C:/MSBI/log/log_2017_03_30.txt_20170406_200\" into table logtxt(log)  set LOG_TYPE=1;");
//        procedureCallService.insertFile(map);
//        map.put("insertSql","delete from logtxt WHERE LOG_TYPE=1;");
//        procedureCallService.insertFile(map);
//    }


    @Test
    public void test3() throws Exception{
        procedureCallService.autoRunDaily();
    }

}
