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
//    public void num() throws Exception{
//        Map tableMap = new HashMap();
//        tableMap.put("month_report_table","month_report_non_prod");
//        tableMap.put("backup_log_table","backup_log_non_prod");
//        tableMap.put("schedule_table","schedule_newest_non_prod");
//        tableMap.put("main_table","main_non_prod");
//        tableMap.put("special_schedule_table","special_schedule_non_prod");
//        //max day 间隔0天
//        tableMap.put("interval_days",0);
//        monthReportService.formatMonthReportTableForTask(day,null, false, 0,"B");
//    }

    @Test
    public void test3() throws Exception{
        procedureCallService.autoRunDaily();
    }

}
