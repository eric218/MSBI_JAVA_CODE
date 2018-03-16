package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.ProcedureCallService;
import com.hpe.msbireport.utils.CommonUtils;
import com.hpe.msbireport.utils.CopyFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-16
 * Time: 2:40 PM
 */
@Service
public class ProcedureCallServiceImpl implements ProcedureCallService {
    @Value("${msbi.app.log.beginDate}")
    private String logBeginDate;
    @Autowired
    private ProcedureCallMapper procedureCallMapper;
    @Autowired
    private FileLoadService fileLoadService;
    @Autowired
    MonthReportService monthReportService;
    private static final Logger log = LoggerFactory.getLogger(ProcedureCallServiceImpl.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("${msbi.app.monthreport.day}")
    private int day;

    @Value("${msbi.app.copyfile.from}")
    private String oldPath;

    @Value("${msbi.app.copyfile.to}")
    private String newPath;

    @Value("${msbi.app.copyfile.from_non}")
    private String oldPathNon;

    @Value("${msbi.app.copyfile.to_non}")
    private String newPathNon;

    @Value("${msbi.app.log.location1}")
    private String logLocation;

    @Value("${msbi.app.log.location_non_prod}")
    private String logLocationNopProd;

    @Value("${msbi.app.file.location.monthly}")
    private String monthlyReportPath;

    @Value("${msbi.app.file.location.daily}")
    private String dailyReportPath;

    private static String reportType_pro="A";

    private static String reportType_non_pro="B";

    @Override
    public void insertFile(Map map) {
        procedureCallMapper.insertFile(map);
    }

    @Override
    public boolean insertLog(List<String> logList, String logLocation,String reportType) {
        Date startDate = new Date(System.currentTimeMillis());
        //操作成功标记
        boolean flag = false;
        Map map = new HashMap();
        //step1.清空 type为2的
        //prod log type 是1
        if(reportType.equals("A")){
            map.put("insertSql", "delete from logtxt WHERE LOG_TYPE=1");
        }
        //non prod log type 是3
        else if(reportType.equals("B")){
            map.put("insertSql", "delete from logtxt WHERE LOG_TYPE=4");
        }

        insertFile(map);

        for (String logs : logList) {
            //从配置有log开始时间,开始插入log数据
            if (logs.contains("newdaily") && Integer.parseInt(logs.split("_")[1]) >= Integer.parseInt(logBeginDate)) {
                //step2.插入每天的log文件
                String inserLogSql = new String();
                inserLogSql = "load data local infile \"" + logLocation + logs + "\" into table logtxt(log)  set LOG_TYPE=1";
                //System.out.println(inserLogSql);
                map.put("insertSql", inserLogSql);
                insertFile(map);
                if(reportType.equals("A")){
                    log.info("@call insert_backup_log_sucessful_procedure(prod) tasks sql: "+ inserLogSql);
                }
                else if(reportType.equals("B")){
                    log.info("@call insert_backup_log_sucessful_procedure(non prod) tasks sql: "+ inserLogSql);
                }
            }
        }

        //step3.call 存储过程
        if(reportType.equals("A")){
            map.put("insertSql", "call insert_backup_log_sucessful_procedure()");
        }
        else if(reportType.equals("B")){
            map.put("insertSql", "call insert_backup_log_non_prod_sucessful_procedure()");
        }

        insertFile(map);
        Date endDate = new Date(System.currentTimeMillis());
        if(reportType.equals("A")){
            log.info("@call insert_backup_log_sucessful_procedure(prod) tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@call insert_backup_log_sucessful_procedure(prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
        } else if(reportType.equals("B")){
            log.info("@call insert_backup_log_sucessful_procedure(non prod) tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@call insert_backup_log_sucessful_procedure(non prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
        }

        //操作成功给标记
        flag = true;
        return flag;
    }


    @Override
    public boolean insertMain(List<String> logList, String logLocation,String reportType) {
        Date startDate = new Date(System.currentTimeMillis());
        boolean flag = false;
        Map map = new HashMap();
        //step1.清空 type为3的
        if(reportType.equals("A")){
            map.put("insertSql", "delete from logtxt where log_type=3");
        }
        else if(reportType.equals("B")){
            map.put("insertSql", "delete from logtxt where log_type=6");
        }

        insertFile(map);
        String main = this.getMainLog(logList,"L");
        if(!StringUtils.isEmpty(main)){
            //System.out.println(main);
            String inserLogSql = "load data local infile \"" + logLocation + main + "\" into table logtxt(log)  set LOG_TYPE=3";
            //System.out.println(inserLogSql);

            if(reportType.equals("A")){
                log.info("@call insert_main_procedure(prod) tasks sql: "+ inserLogSql);
            }
            else if(reportType.equals("B")){
                log.info("@call insert_main_procedure(non prod) tasks sql: "+ inserLogSql);
            }

            map.put("insertSql", inserLogSql);
            insertFile(map);

            //step3.call 存储过程
            if(reportType.equals("A")){
                map.put("insertSql", "call insert_main_procedure()");
            }
            else if(reportType.equals("B")){
                map.put("insertSql", "call insert_main_non_prod_procedure()");
            }
            insertFile(map);
            Date endDate = new Date(System.currentTimeMillis());
            if(reportType.equals("A")){
                log.info("@call insert_main_procedure(prod) tasks complete at:  {}", dateFormat.format(new Date()));
                log.info("@call insert_main_procedure(prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
                log.info("@call insert_main_procedure(prod) tasks sql: "+ inserLogSql);
            }
            else if(reportType.equals("B")){
                log.info("@call insert_main_procedure(non_prod) tasks complete at:  {}", dateFormat.format(new Date()));
                log.info("@call insert_main_procedure(non_prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
                log.info("@call insert_main_procedure(non_prod) tasks sql: "+ inserLogSql);
            }

        }
        flag = true;
        return flag;
    }

    @Override
    public boolean insertSchedule(List<String> logList, String logLocation,String reportType) {
        boolean flag = false;
        Date startDate = new Date(System.currentTimeMillis());
        Map map = new HashMap();
        //step1.清空 type为2的
        if(reportType.equals("A")){
            map.put("insertSql", "delete from logtxt where log_type=2");
        }
        else if(reportType.equals("B")){
            map.put("insertSql", "delete from logtxt where log_type=5");
        }

        insertFile(map);
        String main = this.getMainLog(logList,"S");
        if(!StringUtils.isEmpty(main)){
            //System.out.println(main);
            String inserLogSql = "load data local infile \"" + logLocation + main + "\" into table logtxt(log)  set LOG_TYPE=2";
            //System.out.println(inserLogSql);

            if(reportType.equals("A")){
                log.info("@call insert_schedule_procedure(prod) tasks sql: "+ inserLogSql);
            }
            else if(reportType.equals("B")){
                log.info("@call insert_schedule_procedure(non prod) tasks sql: "+ inserLogSql);
            }

            //step2.插入最新的Schedule文件
            map.put("insertSql", inserLogSql);
            insertFile(map);
            //step3.call 存储过程
            if(reportType.equals("A")){
                map.put("insertSql", "call insert_schedule_procedure()");
            }
            else if(reportType.equals("B")){
                map.put("insertSql", "call insert_schedule_non_prod_procedure()");
            }

            insertFile(map);
            Date endDate = new Date(System.currentTimeMillis());
            if(reportType.equals("A")){
                log.info("@call insert_schedule_procedure(prod) tasks complete at:  {}", dateFormat.format(new Date()));
                log.info("@call insert_schedule_procedure(prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
                log.info("@call insert_schedule_procedure(prod) tasks sql: "+ inserLogSql);
            }
            else if(reportType.equals("B")){
                log.info("@call insert_schedule_procedure(non prod) tasks complete at:  {}", dateFormat.format(new Date()));
                log.info("@call insert_schedule_procedure(non prod) cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
                log.info("@call insert_schedule_procedure(non prod) tasks sql: "+ inserLogSql);
            }

        }
        flag = true;
        return flag;
    }

    @Override
    @Transactional
    public void autoRun(String logLocation,String scheduleLocation,String reportType) throws Exception{
        Date startDate = new Date(System.currentTimeMillis());
        List<String> list = fileLoadService.getInsertFile(logLocation);
        boolean flag1 = this.insertLog(list,logLocation,reportType);
        boolean flag2 = this.insertMain(list,logLocation,reportType);
        List<String> list2 = fileLoadService.getInsertFile(scheduleLocation);
        boolean flag3 = this.insertSchedule(list2,scheduleLocation,reportType);
        if(flag1&flag2&flag3){
            this.insertFile(list,list2,reportType,String reportType);
        }

        if(list==null || list.size()==0){
            if(reportType.equals("A")){
                log.warn("there is no new Log and assoc files(prod)");
            }else if(reportType.equals("B")){
                log.warn("there is no new Log and assoc files(non prod)");
            }

        }

        if(list2==null || list2.size()==0){
            if(reportType.equals("A")){
                log.warn("there is no new schedule files(prod)");
            }else if(reportType.equals("B")){
                log.warn("there is no new schedule files(non prod)");
            }

        }

        Date endDate = new Date(System.currentTimeMillis());
        if(reportType.equals("A")){
            log.info("@call all procedure(prod) tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@@call all procedure(prod) cost totle time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
        }else if(reportType.equals("B")){
            log.info("@call all procedure(non prod) tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@@call all procedure(non prod) cost totle time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
        }

    }

    private void insertFile(List<String> logList, List<String> scheduleList){
        if(logList!=null && logList.size()>=1){
            for(String name : logList){
                fileLoadService.insertFile(name);
            }
        }
        if(scheduleList!=null && scheduleList.size()>=1){
            for(String name : scheduleList){
                fileLoadService.insertFile(name);
            }
        }
    }

    /**
     * Description:选取列表中最大日期的文件
     * @param logList
     * @param type "L",log;"S":schedule
     * @return
     */
    private String getMainLog(List<String> logList,String type) {
        String mainLog = new String();
        Map map = new HashMap();
        List list = new ArrayList();
        for (String log : logList) {
            if (log.contains("newassoc") && type.equals("L")) {
                String date = log.split("_")[1];
                map.put(date, log);
                list.add(date);
            }
            if (log.contains("schedule") && type.equals("S")) {
                String date = log.split("_")[1];
                map.put(date, log);
                list.add(date);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        if(list!=null && list.size()>=1){
            mainLog = (String) map.get((String)list.get(0));
        }
        return mainLog;
    }

    @Override
    public void autoRunDaily() throws Exception {
        //prod report
        this.autoRun(logLocation,newPath,reportType_pro);
        new CopyFileUtils().copy(oldPath,newPath);
        monthReportService.formatMonthReportTableForTask(day,null, false, 0,reportType_pro);
        //non prod report
        new CopyFileUtils().copy(oldPathNon,newPathNon);
        this.autoRun(logLocationNopProd,newPathNon,reportType_non_pro);
        monthReportService.formatMonthReportTableForTask(day,null, false, 0,reportType_non_pro);
        monthReportService.autoDailyGenerate(dailyReportPath);
        monthReportService.autoMonthlyGenerate(monthlyReportPath);


//        this.autoRun(logLocation,scheduleLocation);
//        monthReportService.formatMonthReportTableForTask(day,null, true, 1000);

    }
}

