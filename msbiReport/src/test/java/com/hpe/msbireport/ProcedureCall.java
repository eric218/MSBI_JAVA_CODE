package com.hpe.msbireport;

import com.hpe.msbireport.mapper.ProcedureCallMapper;
import com.hpe.msbireport.service.ProcedureCallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private ProcedureCallService procedureCallService;
    @Test
    @Transactional
    public void num(){
        Map map = new HashMap();
        map.put("insertSql","load data local infile \"C:/MSBI/log/log_2017_03_30.txt_20170406_200\" into table logtxt(log)  set LOG_TYPE=1;");
        procedureCallService.insertFile(map);
        map.put("insertSql","delete from logtxt WHERE LOG_TYPE=1;");
        procedureCallService.insertFile(map);
    }
}
