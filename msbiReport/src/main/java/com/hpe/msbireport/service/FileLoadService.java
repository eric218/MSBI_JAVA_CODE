package com.hpe.msbireport.service;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-01-30
 * Time: 5:42 PM
 */
public interface FileLoadService {
    public List<String> getInsertFile(String logLocation) throws IOException;
    public void insertFile(String fileName);
}
