package com.hpe.msbireport.controller;

import com.hpe.msbireport.domain.*;
import com.hpe.msbireport.service.*;
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
@RequestMapping("/api")
public class MsbiReportController {

    @Autowired
    LookupService lookupService;

    @Autowired
    MonthReportService monthReportService;

    @Autowired
    TotalTitleService totalTitleService;

    @Autowired
    TotalSummaryService totalSummaryService;

    @Autowired
    LookupSummaryService lookupSummaryService;

    @Autowired
    PoiExcelService poiExcelService;


    /*
     *
     * export .xlsx file, user can download it to their local machine.
     *
     * */
    @RequestMapping(value = "/export.xlsx", method = RequestMethod.GET)
    public String downloadSelectedMonthReportFromBrowser(Model model) {

        model.addAttribute("month", "20170201");
        model.addAttribute("lookups", this.lookupService.selectAllLookup());
        model.addAttribute("monthReports", this.monthReportService.selectAllMonthReportsByMonth(201702));
        model.addAttribute("totalSummaries", this.totalSummaryService.selectAllTotalSummaryByMonth(201702));
        model.addAttribute("lookupSummaries", this.lookupSummaryService.selectAllLookupSummaryCountByMonth(201702));

        return "";
    }

    /*
     *
     * write excel file to a fixed path location.
     *
     * */
    @RequestMapping(value = "/excel/autoGenerate", method = RequestMethod.GET)
    public @ResponseBody
    String generateExcelFileToTheFixedPath(Integer monthIndicator) throws Exception {

        return this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, "/Users/liuke/Downloads/");

    }

    /*
     *
     * prepare data.
     *
     * */
    @RequestMapping(value = "/lookup/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<com.hpe.msbireport.domain.Lookup> selectAllLookup() {
        return this.lookupService.selectAllLookup();
    }


    /*
     *
     * prepare data.
     *
     * */
    @RequestMapping(value = "/lookupSummaryCount/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<LookupSummary> selectAllLookupSummaryCount(Integer month) {
        return this.lookupSummaryService.selectAllLookupSummaryCountByMonth(month);
    }

    /*
     *
     * prepare main report content data.
     *
     * */
    @RequestMapping(value = "/monthReport/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<MonthReport> selectAllMonthReport(Integer month) {
        return this.monthReportService.selectAllMonthReportsByMonth(month);
    }

    /*
     *
     * total summary category.
     *
     * */
    @RequestMapping(value = "/totalTitle/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<TotalTitle> selectAllTotalTitle() {
        return this.totalTitleService.selectAllTotalTitle();
    }

    /*
     *
     * total summary category.
     *
     * */
    @RequestMapping(value = "/totalSummary/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<TotalSummary> selectAllTotalSummary(Integer month) {
        return this.totalSummaryService.selectAllTotalSummaryByMonth(month);
    }

    /**
     * query all available month from DB,
     *
     * @return List[Integer] format: 201801,201802,201803
     */
    @RequestMapping(value = "/allAvailableMonth/fetch", method = RequestMethod.GET)
    public @ResponseBody
    List<Integer> selectAllAvailableMonthFromDB() {
        return this.monthReportService.selectAllAvaiableMonthFromDB();
    }

}
