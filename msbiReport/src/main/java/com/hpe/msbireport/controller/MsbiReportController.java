package com.hpe.msbireport.controller;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.service.LookupService;
import com.hpe.msbireport.service.MonthReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/api/")
public class MsbiReportController {

    @Autowired
    LookupService lookupService;

    @Autowired
    MonthReportService monthReportService;

    @RequestMapping(value = "/export.xlsx", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("lookups", this.lookupService.selectAllLookup());
        model.addAttribute("month", "20170201");
        model.addAttribute("monthReports", this.monthReportService.selectAllMonthReportsByMonth(201702));
        return "";
    }

    @RequestMapping(value = "/lookup/fetch", method = RequestMethod.GET)
    public @ResponseBody List<com.hpe.msbireport.domain.Lookup> selectAlllookup() {
        return this.lookupService.selectAllLookup();
    }

    @RequestMapping(value = "/monthReport/fetch", method = RequestMethod.GET)
    public @ResponseBody List<MonthReport> selectAllMonthReport(Integer month) {
        return this.monthReportService.selectAllMonthReportsByMonth(month);
    }

}
