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
    public int insertLog(List<String> logList,String logLocation);
    public int insertMain(List<String> logList,String logLocation);
}
