package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.FileLoadService;
import com.hpe.msbireport.service.ProcedureCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Override
    public void insertFile(Map map) {
        procedureCallMapper.insertFile(map);
    }

    @Override
    public int insertLog(List<String> logList, String logLocation) {
        //操作成功标记
        int flag = 0;
        Map map = new HashMap();
        //step1.清空 type为2的
        map.put("insertSql", "delete from logtxt WHERE LOG_TYPE=1");
        insertFile(map);

        for (String log : logList) {
            if (log.contains("newdaily")) {
                //step2.插入每天的log文件
                String inserLogSql = new String();
                inserLogSql = "load data local infile \"" + logLocation + log + "\" into table logtxt(log)  set LOG_TYPE=1";
                //System.out.println(inserLogSql);
                map.put("insertSql", inserLogSql);
                insertFile(map);
            }
        }

        //step3.call 存储过程
        map.put("insertSql", "call insert_backup_log_sucessful_procedure()");
        insertFile(map);
        //操作成功给标记
        flag = 1;
        return flag;
    }


    @Override
    public int insertMain(List<String> logList, String logLocation) {
        int flag = 0;

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

            flag = 1;
        }

        return flag;
    }

    @Override
    public int insertSchedule(List<String> logList, String logLocation) {
        int flag = 0;

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
            System.out.println(inserLogSql);
            //insertFile(map);

            //step3.call 存储过程
            map.put("insertSql", "call insert_schedule_procedure()");
            //insertFile(map);

            flag = 1;
        }

        return flag;
    }

    @Override
    public void autoRun(String logLocation,String scheduleLocation) throws Exception{
        List<String> list = fileLoadService.getInsertFile(logLocation);
        this.insertLog(list,logLocation);
        this.insertMain(list,logLocation);
        list = fileLoadService.getInsertFile(scheduleLocation);
        this.insertSchedule(list,scheduleLocation);
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

