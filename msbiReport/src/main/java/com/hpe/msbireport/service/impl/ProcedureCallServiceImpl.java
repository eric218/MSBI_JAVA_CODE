package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.ProcedureCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Value("${msbi.app.log.location1}")
    private String logLocation;
    @Autowired
    private ProcedureCallMapper procedureCallMapper;

    @Override
    public void insertFile(Map map) {
        procedureCallMapper.insertFile(map);
    }

    @Override
    @Transactional
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
    @Transactional
    public int insertMain(List<String> logList, String logLocation) {
        int flag = 0;

        Map map = new HashMap();
        //step1.清空 type为3的
        map.put("insertSql", "delete from logtxt where log_type=3");
        insertFile(map);
        String main = this.getMainLog(logList);
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
        return flag;
    }

    /**
     * Description:选取列表中最大日期的文件
     * @param logList
     * @return
     */
    private String getMainLog(List<String> logList) {
        String mainLog = new String();
        Map map = new HashMap();
        List list = new ArrayList();
        for (String log : logList) {
            if (log.contains("newassoc")) {
                String date = log.split("_")[1];
                map.put(date, log);
                list.add(date);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        mainLog = (String) map.get((String)list.get(0));
        return mainLog;
    }
}

