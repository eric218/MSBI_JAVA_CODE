package com.hpe.msbireport.controller;

import com.hpe.msbireport.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: Please notice the extension
 * For web resource, please add .html extension to the END.
 * For restful service just leave it as normal.
 * For xlsx view, please add the .xlsx extension to the END.
 * So that the view resolver can recognize the resource which we want to access.
 */
@RestController
@RequestMapping("/api")
public class MsbiReportController {

    @Value("${msbi.app.file.location.monthly}")
    private String monthlyReportPath;

    @Value("${msbi.app.file.location.daily}")
    private String dailyReportPath;

    @Autowired
    MonthReportService monthReportService;

    @Autowired
    PoiExcelService poiExcelService;

    @RequestMapping(value = "/excel/generateSpecificMonthReports", method = RequestMethod.GET)
    public @ResponseBody
    String generateExcelFileToTheFixedPath(Integer monthIndicator) throws Exception {
        return this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, monthlyReportPath);
    }

    @RequestMapping(value = "/excel/generateAllReports", method = RequestMethod.GET)
    public void autoGeneratePastMonthlyReport() throws Exception {
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        for (Integer monthIndicator : availableMonthLists) {
            this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, monthlyReportPath);
        }
    }

    @RequestMapping(value = "/excel/generateLatestMonthReports", method = RequestMethod.GET)
    public void autoDailyGenerateCurrentMonthlyReport() throws Exception {

        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        if (availableMonthLists != null) {
            this.poiExcelService.generateExcelFileToAFixedPath(availableMonthLists.get(0), dailyReportPath);
        }
    }
	
	@RequestMapping(value = "/monthReport/format", method = RequestMethod.GET)
    public @ResponseBody boolean selectAllMonthReport(String month,int size) {
        try {
        	month = "2017-4-18";
        	size = 100;
			return this.monthReportService.formatMonthReportTable(null,month,false, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return false;
    }
	
}
