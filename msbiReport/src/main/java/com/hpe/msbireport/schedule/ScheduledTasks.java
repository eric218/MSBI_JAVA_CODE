package com.hpe.msbireport.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.PoiExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 5/1/18
 * Description: WTF....
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final String pastReportPath = "/Users/liuke/Downloads/";

    private static final String currentReportPath = "/Users/liuke/Downloads/";

    @Autowired
    MonthReportService monthReportService;

    @Autowired
    PoiExcelService poiExcelService;

    //0 59 23 1 1/1 *  = every 1st day of each month at 23:59 PM
    @Scheduled(cron = "0 06 11 5 1/1 *") // for test purpose.
    public void autoGeneratePastMonthlyReport() throws Exception {
        log.info("AutoGeneratePastMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        for (Integer monthIndicator : availableMonthLists) {
            this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, pastReportPath);
        }
        log.info("ScheAutoGeneratePastMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }

    // every day at 02:00 AM
    @Scheduled(cron = "0 0 2 1/1 * ?")
    public void autoDailyGenerateCurrentMonthlyReport() throws Exception {

        log.info("AutoDailyGenerateCurrentMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        for (Integer monthIndicator : availableMonthLists) {
            this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, currentReportPath);
        }
        log.info("AutoDailyGenerateCurrentMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }
}
