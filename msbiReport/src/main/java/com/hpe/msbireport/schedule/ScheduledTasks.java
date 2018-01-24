package com.hpe.msbireport.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.PoiExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    MonthReportService monthReportService;

    @Autowired
    PoiExcelService poiExcelService;

    @Value("${msbi.app.file.location.monthly}")
    private String monthlyReportPath;

    @Value("${msbi.app.file.location.daily}")
    private String dailyReportPath;

    //0 59 23 1 1/1 *  = every 1st day of each month at 23:59 PM
    @Scheduled(cron = "${msbi.app.scheduled.time.monthly}")
    public void autoGeneratePastMonthlyReport() throws Exception {
        log.info("@Scheduled Task: AutoGeneratePastMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        for (Integer monthIndicator : availableMonthLists) {
            this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, monthlyReportPath);
        }
        log.info("@Scheduled Task: AutoGeneratePastMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }

    // every day at 02:00 AM
    @Scheduled(cron = "${msbi.app.scheduled.time.daily}")
    public void autoDailyGenerateCurrentMonthlyReport() throws Exception {
        log.info("@Scheduled Task: AutoDailyGenerateCurrentMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        if (availableMonthLists != null) {
            this.poiExcelService.generateExcelFileToAFixedPath(availableMonthLists.get(0), dailyReportPath);
        }
        log.info("@Scheduled Task: AutoDailyGenerateCurrentMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }
}
