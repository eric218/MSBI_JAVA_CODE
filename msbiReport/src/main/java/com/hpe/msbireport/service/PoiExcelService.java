package com.hpe.msbireport.service;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 5/1/18
 * Description: ...
 */
public interface PoiExcelService {
    
    public String generateExcelFileToAFixedPath(Integer monthIndicator, String path,String type) throws Exception;

}
