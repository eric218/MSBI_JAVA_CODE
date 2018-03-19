package com.hpe.msbireport.schedule;

import com.hpe.msbireport.service.ProcedureCallService;
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
    @Autowired
    private ProcedureCallService procedureCallService;
    //每天调用
    @Scheduled(cron = "${msbi.app.scheduled.autoRun.daily}")
    public void autoRunDaily() throws Exception {
        procedureCallService.autoRunDaily();

    }
}
