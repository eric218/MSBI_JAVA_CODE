package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.service.ProcedureCallService;
import com.hpe.msbireport.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProcedureCallMapper procedureCallMapper;
    @Autowired
    private FileLoadService fileLoadService;
    private static final Logger log = LoggerFactory.getLogger(ProcedureCallServiceImpl.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void insertFile(Map map) {
        procedureCallMapper.insertFile(map);
    }

    @Override
    public boolean insertLog(List<String> logList, String logLocation) {
        Date startDate = new Date(System.currentTimeMillis());
        //操作成功标记
        boolean flag = false;
        Map map = new HashMap();
        //step1.清空 type为2的
        map.put("insertSql", "delete from logtxt WHERE LOG_TYPE=1");
        insertFile(map);

        for (String logs : logList) {
            if (logs.contains("newdaily")) {
                //step2.插入每天的log文件
                String inserLogSql = new String();
                inserLogSql = "load data local infile \"" + logLocation + logs + "\" into table logtxt(log)  set LOG_TYPE=1";
                //System.out.println(inserLogSql);
                map.put("insertSql", inserLogSql);
                insertFile(map);
                log.info("@call insert_main_procedure() tasks sql: "+ inserLogSql);
            }
        }

        //step3.call 存储过程
        map.put("insertSql", "call insert_backup_log_sucessful_procedure()");
        insertFile(map);
        Date endDate = new Date(System.currentTimeMillis());
        log.info("@call insert_backup_log_sucessful_procedure() tasks complete at:  {}", dateFormat.format(new Date()));
        log.info("@call insert_backup_log_sucessful_procedure() cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
        //操作成功给标记
        flag = true;
        return flag;
    }


    @Override
    public boolean insertMain(List<String> logList, String logLocation) {
        Date startDate = new Date(System.currentTimeMillis());
        boolean flag = false;
        Map map = new HashMap();
        //step1.清空 type为3的
        map.put("insertSql", "delete from logtxt where log_type=3");
        insertFile(map);
        String main = this.getMainLog(logList,"L");
        if(!StringUtils.isEmpty(main)){
            //System.out.println(main);
            String inserLogSql = "load data local infile \"" + logLocation + main + "\" into table logtxt(log)  set LOG_TYPE=3";
            System.out.println(inserLogSql);
            //step2.插入最新的main文件
            map.put("insertSql", inserLogSql);
            insertFile(map);

            //step3.call 存储过程
            map.put("insertSql", "call insert_main_procedure()");
            insertFile(map);
            Date endDate = new Date(System.currentTimeMillis());
            log.info("@call insert_main_procedure() tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@call insert_main_procedure() cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
            log.info("@call insert_main_procedure() tasks sql: "+ inserLogSql);
        }
        flag = true;
        return flag;
    }

    @Override
    public boolean insertSchedule(List<String> logList, String logLocation) {
        boolean flag = false;
        Date startDate = new Date(System.currentTimeMillis());
        Map map = new HashMap();
        //step1.清空 type为2的
        map.put("insertSql", "delete from logtxt where log_type=2");
        insertFile(map);
        String main = this.getMainLog(logList,"S");
        if(!StringUtils.isEmpty(main)){
            //System.out.println(main);
            String inserLogSql = "load data local infile \"" + logLocation + main + "\" into table logtxt(log)  set LOG_TYPE=2";
            System.out.println(inserLogSql);
            //step2.插入最新的Schedule文件
            map.put("insertSql", inserLogSql);
            insertFile(map);
            //step3.call 存储过程
            map.put("insertSql", "call insert_schedule_procedure()");
            insertFile(map);
            Date endDate = new Date(System.currentTimeMillis());
            log.info("@call insert_schedule_procedure() tasks complete at:  {}", dateFormat.format(new Date()));
            log.info("@call insert_schedule_procedure() cost time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
            log.info("@call insert_schedule_procedure() tasks sql: "+ inserLogSql);
        }
        flag = true;
        return flag;
    }

    @Override
    @Transactional
    public void autoRun(String logLocation,String scheduleLocation) throws Exception{
        Date startDate = new Date(System.currentTimeMillis());
        List<String> list = fileLoadService.getInsertFile(logLocation);
        boolean flag1 = this.insertLog(list,logLocation);
        boolean flag2 = this.insertMain(list,logLocation);
        List<String> list2 = fileLoadService.getInsertFile(scheduleLocation);
        boolean flag3 = this.insertSchedule(list2,scheduleLocation);
        if(flag1&flag2&flag3){
            this.insertFile(list,list2);
        }

        if(list==null || list.size()==0){
            log.warn("there is no new Log and assoc files");
        }

        if(list2==null || list2.size()==0){
            log.warn("there is no new schedule files");
        }

        Date endDate = new Date(System.currentTimeMillis());
        log.info("@call all procedure() tasks complete at:  {}", dateFormat.format(new Date()));
        log.info("@@call all procedure() cost totle time: "+ CommonUtils.getTimeIntervalFormat1(startDate,endDate));
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
}

