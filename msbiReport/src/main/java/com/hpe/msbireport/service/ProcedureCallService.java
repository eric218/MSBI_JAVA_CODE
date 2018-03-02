package com.hpe.msbireport.service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-16
 * Time: 2:40 PM
 */
public interface ProcedureCallService {
    public void insertFile(Map map);
    public boolean insertLog(List<String> logList,String logLocation);
    public boolean insertMain(List<String> logList,String logLocation);
    public boolean insertSchedule(List<String> logList,String logLocation);
    public void autoRun(String logLocation,String scheduleLocation) throws Exception;
    public void autoRunDaily() throws Exception;
}
