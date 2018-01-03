package com.hpe.msbireport.controller;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.TotalTitle;
import com.hpe.msbireport.service.LookupService;
import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.TotalTitleService;
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

    @Autowired
    TotalTitleService totalTitleService;


    /*
    *
    * export .xlsx file, user can download it to their local machine.
    *
    * */
    @RequestMapping(value = "/export.xlsx", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("lookups", this.lookupService.selectAllLookup());
        model.addAttribute("month", "20170201");
        model.addAttribute("monthReports", this.monthReportService.selectAllMonthReportsByMonth(201702));
        return "";
    }

    /*
    *
    * prepare data.
    *
    * */
    @RequestMapping(value = "/lookup/fetch", method = RequestMethod.GET)
    public @ResponseBody List<com.hpe.msbireport.domain.Lookup> selectAlllookup() {
        return this.lookupService.selectAllLookup();
    }

    /*
    *
    * prepare main report content data.
    *
    * */
    @RequestMapping(value = "/monthReport/fetch", method = RequestMethod.GET)
    public @ResponseBody List<MonthReport> selectAllMonthReport(Integer month) {
        return this.monthReportService.selectAllMonthReportsByMonth(month);
    }

    /*
    *
    * total summary category.
    *
    * */
    @RequestMapping(value = "/totalTitle/fetch", method = RequestMethod.GET)
    public @ResponseBody List<TotalTitle> selectAllTotalTitle(){
        return this.totalTitleService.selectAllTotalTitle();
    }

    /**
     *
     * query all available month from DB,
     * @return List[Integer] format: 201801,201802,201803
     *
     * */
    @RequestMapping(value = "/allAvaiableMonth/fetch", method = RequestMethod.GET)
    public @ResponseBody List<Integer> selectAllAvaiableMonthFromDB(){
        return this.monthReportService.selectAllAvaiableMonthFromDB();
    }





}
