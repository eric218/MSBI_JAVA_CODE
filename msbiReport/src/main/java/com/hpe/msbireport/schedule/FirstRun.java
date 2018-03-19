package com.hpe.msbireport.schedule;

import com.hpe.msbireport.service.ProcedureCallService;
import com.hpe.msbireport.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:系统启动时自己跑一下程序
 * User: Wang,Wei
 * Date: 2018-03-19
 * Time: 11:28 AM
 */

@Component
@Order(1)
public class FirstRun implements CommandLineRunner {
    @Autowired
    private ProcedureCallService procedureCallService;
    private static final Logger log = LoggerFactory.getLogger(FirstRun.class);
    @Override
    public void run(String... strings) throws Exception {
        Date startDate = new Date(System.currentTimeMillis());
        procedureCallService.autoRunDaily();
        Date endDate = new Date(System.currentTimeMillis());

        log.info("atuo run complete successful");
        log.info("auto run cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
    }
}
