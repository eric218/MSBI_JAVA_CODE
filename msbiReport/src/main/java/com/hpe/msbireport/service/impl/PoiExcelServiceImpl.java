package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.domain.LookupSummary;
import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.TotalSummary;
import com.hpe.msbireport.mapper.LookupMapper;
import com.hpe.msbireport.mapper.MonthReportMapper;
import com.hpe.msbireport.service.PoiExcelService;
import com.hpe.msbireport.utils.CommonUtils;
import com.hpe.msbireport.utils.ExcelUnits;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 5/1/18
 * Descripthion: ...
 */
@Service
public class PoiExcelServiceImpl implements PoiExcelService {

    private static final Logger log = LoggerFactory.getLogger(PoiExcelServiceImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    LookupMapper lookupMapper;

    @Autowired
    MonthReportMapper monthReportMapper;

    ExcelUnits excelUnits = new ExcelUnits();

    @Override
    public String generateExcelFileToAFixedPath(Integer monthIndicator, String path) throws Exception {
        {
            final String[] weekOfDays = {"", "(Monday)", "(Tuesday)", "(Wednesday)", "(Thursday)", "(Friday)", "(Saturday)", "(Sunday)"};
            //Workbook workbook = new HSSFWorkbook();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFPalette customPalette = workbook.getCustomPalette();
            customPalette.setColorAtIndex(HSSFColor.DARK_TEAL.index, (byte) 73, (byte) 131, (byte) 178);
            customPalette.setColorAtIndex(HSSFColor.BRIGHT_GREEN.index, (byte) 41, (byte) 253, (byte) 47);
            customPalette.setColorAtIndex(HSSFColor.AQUA.index, (byte) 74, (byte) 223, (byte) 208);
            customPalette.setColorAtIndex(HSSFColor.CORNFLOWER_BLUE.index, (byte) 102, (byte) 94, (byte) 202);

            CommonUtils commonUtils = new CommonUtils();
            // get month
            String month = monthIndicator.toString() + "01";
            List<Lookup> lookups = this.lookupMapper.selectAllLookup();
            // monthIndicator: 201702
            List<MonthReport> monthReports = this.monthReportMapper.selectAllMonthReportsByMonth(monthIndicator);
            List<TotalSummary> totalSummaries = commonUtils.computeSummaryForMonthReportContent(monthReports); // this.totalSummaryMapper.selectAllTotalSummaryByMonth(monthIndicator);
            List<LookupSummary> lookupSummaries = commonUtils.computeSummaryForMonthReportLookup(monthReports);

            // create excel xls sheet
            Sheet sheet = workbook.createSheet("MonthReport_daily");
            sheet.setDefaultColumnWidth(18);
            //B列40个字符,256是单位
            sheet.setColumnWidth(1, 40 * 256);
            sheet.setColumnWidth(2, 34 * 256);
            sheet.setColumnWidth(7, 13 * 256);
            sheet.setColumnWidth(8, 13 * 256);
            //设置每日的列的宽度
            for(int i = 10;i<72;i++){
                sheet.setColumnWidth(i, 13 * 256);
            }


            // display content data in center
            CellStyle monthReportContentStyle = workbook.createCellStyle();
            monthReportContentStyle.setAlignment(HorizontalAlignment.CENTER);

            CellStyle lookupCode0Style = workbook.createCellStyle();
            lookupCode0Style.setAlignment(HorizontalAlignment.CENTER);
            // background color 0 - RED
            lookupCode0Style.setFillForegroundColor(HSSFColor.RED.index);
            lookupCode0Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode0Style.setBorderTop(BorderStyle.THIN);
            lookupCode0Style.setBorderLeft(BorderStyle.THIN);
            lookupCode0Style.setBorderRight(BorderStyle.THIN);
            lookupCode0Style.setBorderBottom(BorderStyle.THIN);
            lookupCode0Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode0Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode0Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode0Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);

            CellStyle lookupCode1Style = workbook.createCellStyle();
            lookupCode1Style.setAlignment(HorizontalAlignment.CENTER);
            // background color 1 - GREEN
            lookupCode1Style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
            lookupCode1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode1Style.setBorderTop(BorderStyle.THIN);
            lookupCode1Style.setBorderLeft(BorderStyle.THIN);
            lookupCode1Style.setBorderRight(BorderStyle.THIN);
            lookupCode1Style.setBorderBottom(BorderStyle.THIN);
            lookupCode1Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode1Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode1Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode1Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);

            CellStyle lookupCode2Style = workbook.createCellStyle();
            lookupCode2Style.setAlignment(HorizontalAlignment.CENTER);
            // background color 2 - HSSFColor.AQUA
            lookupCode2Style.setFillForegroundColor(HSSFColor.AQUA.index);
            lookupCode2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode2Style.setBorderTop(BorderStyle.THIN);
            lookupCode2Style.setBorderLeft(BorderStyle.THIN);
            lookupCode2Style.setBorderRight(BorderStyle.THIN);
            lookupCode2Style.setBorderBottom(BorderStyle.THIN);
            lookupCode2Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode2Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode2Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode2Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);

            CellStyle lookupCode3Style = workbook.createCellStyle();
            lookupCode3Style.setAlignment(HorizontalAlignment.CENTER);
            // background color 3 - YELLOW
            lookupCode3Style.setFillForegroundColor(HSSFColor.YELLOW.index);
            lookupCode3Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode3Style.setBorderTop(BorderStyle.THIN);
            lookupCode3Style.setBorderLeft(BorderStyle.THIN);
            lookupCode3Style.setBorderRight(BorderStyle.THIN);
            lookupCode3Style.setBorderBottom(BorderStyle.THIN);
            lookupCode3Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode3Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode3Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode3Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);

            CellStyle lookupCode4Style = workbook.createCellStyle();
            lookupCode4Style.setAlignment(HorizontalAlignment.CENTER);
            // background color 4 - HSSFColor.CORNFLOWER_BLUE
            lookupCode4Style.setFillForegroundColor(HSSFColor.CORNFLOWER_BLUE.index);
            lookupCode4Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode4Style.setBorderTop(BorderStyle.THIN);
            lookupCode4Style.setBorderLeft(BorderStyle.THIN);
            lookupCode4Style.setBorderRight(BorderStyle.THIN);
            lookupCode4Style.setBorderBottom(BorderStyle.THIN);
            lookupCode4Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode4Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode4Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode4Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);


            CellStyle lookupCode5Style = workbook.createCellStyle();
            lookupCode5Style.setAlignment(HorizontalAlignment.CENTER);
            // background color
            lookupCode5Style.setFillForegroundColor(HSSFColor.WHITE.index);
            lookupCode5Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            lookupCode5Style.setBorderTop(BorderStyle.THIN);
            lookupCode5Style.setBorderLeft(BorderStyle.THIN);
            lookupCode5Style.setBorderRight(BorderStyle.THIN);
            lookupCode5Style.setBorderBottom(BorderStyle.THIN);
            lookupCode5Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode5Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode5Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupCode5Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);

            CellStyle lookupCountStyle = workbook.createCellStyle();
            lookupCountStyle.setAlignment(HorizontalAlignment.CENTER);


            //main content variables, these variables are used for performing month calculation.
            //-------- Start --------
            //find reference point :  #Content Month Header
            int t = 0;
            Date d;
            SimpleDateFormat dayofweek;
            SimpleDateFormat yyyyMMdd;
            int dayOfWeekIndex;
            String dateCellValueInput;
            int t_year = Integer.parseInt(month.substring(0, 4));
            int t_month = Integer.parseInt(month.substring(4, 6));
            int maxDate = commonUtils.getDaysByYearMonth(t_year, t_month);


            Calendar instance = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date monthInput = sdf.parse(month);
            instance.setTime(monthInput);
            instance.set(Calendar.DAY_OF_MONTH, 0);// start from 1 of this month.
            //
            //main content variables, these variables are used for performing month calculation.
            //-------- End --------
            //

            // title ttyle report title, e.g.. "MonthReport - Daily( 20170401 )"
            // we will customize the HSSFColor.SKY_BLUE color to the title color that

            CellStyle titleStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();
            titleFont.setFontName("Tahoma");
            titleFont.setBold(true);
            titleFont.setFontHeightInPoints((short) 20);
            titleFont.setColor(HSSFColor.DARK_TEAL.index);
            titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            titleStyle.setFont(titleFont);
            // merge cells
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));

            // create title row
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("MonthReport - Daily ( " + month + " )");
            title.getCell(0).setCellStyle(titleStyle);

            int rowCount = 1;
            int lookupSize = lookups.size();

            // lookup column1 fonts
            CellStyle lookupColumn1Style = workbook.createCellStyle();
            Font lookupColumn1Font = workbook.createFont();
            lookupColumn1Font.setFontName("Arial");
            lookupColumn1Font.setColor(HSSFColor.WHITE.index);
            lookupColumn1Font.setFontHeightInPoints((short) 10);
            // background color
            lookupColumn1Style.setFillForegroundColor(HSSFColor.BLACK.index);
            lookupColumn1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // border style and border color
            lookupColumn1Style.setBorderTop(BorderStyle.THIN);
            lookupColumn1Style.setBorderLeft(BorderStyle.THIN);
            lookupColumn1Style.setBorderRight(BorderStyle.THIN);
            lookupColumn1Style.setBorderBottom(BorderStyle.THIN);
            lookupColumn1Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn1Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn1Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn1Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
            // style add font
            lookupColumn1Style.setFont(lookupColumn1Font);

            CellStyle lookupColumn2Style = workbook.createCellStyle();
            lookupColumn2Style.setAlignment(HorizontalAlignment.CENTER);
            lookupColumn2Style.setBorderTop(BorderStyle.THIN);
            lookupColumn2Style.setBorderLeft(BorderStyle.THIN);
            lookupColumn2Style.setBorderRight(BorderStyle.THIN);
            lookupColumn2Style.setBorderBottom(BorderStyle.THIN);
            lookupColumn2Style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn2Style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn2Style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            lookupColumn2Style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);


            CellStyle redRightStyle = excelUnits.setRedRightStyle(workbook);
            CellStyle greenRightStyle = excelUnits.setGreenRightStyle(workbook);
            CellStyle rightIntStyle = excelUnits.setRightIntStyle(workbook);


            for (int i = 0; i < lookupSize; i++) {
                sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 2, 3));
            }

            for (Lookup lookup : lookups) {

                Row lookupRow = sheet.createRow(rowCount++);
                lookupColumn2Style.setFillForegroundColor((short) 9);
                lookupColumn2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                lookupRow.createCell(0).setCellValue(lookup.getTitle());
                lookupRow.createCell(1);
                lookupRow.getCell(0).setCellStyle(lookupColumn1Style);
                lookupRow.getCell(1).setCellStyle(lookupColumn1Style);

                lookupRow.createCell(2).setCellValue(lookup.getCode());
                lookupRow.createCell(3);
                if (lookup.getCode().equalsIgnoreCase("0")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode0Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode0Style);
                } else if (lookup.getCode().equalsIgnoreCase("1")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode1Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode1Style);
                } else if (lookup.getCode().equalsIgnoreCase("2")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode2Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode2Style);
                } else if (lookup.getCode().equalsIgnoreCase("3")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode3Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode3Style);
                } else if (lookup.getCode().equalsIgnoreCase("4")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode4Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode4Style);
                } else if (lookup.getCode().equalsIgnoreCase("5")) {
                    lookupRow.getCell(2).setCellStyle(lookupCode5Style);
                    lookupRow.getCell(3).setCellStyle(lookupCode5Style);
                }
            }

            // merge cells for top total group rows
            sheet.addMergedRegion(new CellRangeAddress(lookupSize + 2, lookupSize + 2, 0, 8));
            sheet.addMergedRegion(new CellRangeAddress(lookupSize + 3, lookupSize + 3, 0, 8));

            for (int i = 0; i < maxDate; i++) {
                sheet.addMergedRegion(new CellRangeAddress(lookupSize + 2, lookupSize + 2, 10 + t, 11 + t));
                sheet.addMergedRegion(new CellRangeAddress(lookupSize + 3, lookupSize + 3, 10 + t, 11 + t));
                t = t + 2;
            }

            // must reset parameter t to 0.
            t = 0;

            CellStyle totalGroupRowsStyle = workbook.createCellStyle();
            Font totalGroupRowsFont = workbook.createFont();
            totalGroupRowsFont.setFontName("Arial");
            totalGroupRowsFont.setFontHeightInPoints((short) 10);
            totalGroupRowsFont.setColor(HSSFColor.WHITE.index);
            totalGroupRowsStyle.setFillForegroundColor(HSSFColor.TEAL.index);
            totalGroupRowsStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalGroupRowsStyle.setBorderTop(BorderStyle.THIN);
            totalGroupRowsStyle.setBorderLeft(BorderStyle.THIN);
            totalGroupRowsStyle.setBorderRight(BorderStyle.THIN);
            totalGroupRowsStyle.setBorderBottom(BorderStyle.THIN);
            totalGroupRowsStyle.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            totalGroupRowsStyle.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            totalGroupRowsStyle.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            totalGroupRowsStyle.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
            totalGroupRowsStyle.setFont(totalGroupRowsFont);

            // insert first 2 total summaries into the top 2 total row cells.
            Row totalSummaryTopGroupRows;
            totalSummaryTopGroupRows = sheet.createRow(lookupSize + 2);
            totalSummaryTopGroupRows.createCell(0).setCellValue("Total Failed to recover");
            totalSummaryTopGroupRows.getCell(0).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(1);
            totalSummaryTopGroupRows.getCell(1).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(2);
            totalSummaryTopGroupRows.getCell(2).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(3);
            totalSummaryTopGroupRows.getCell(3).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(4);
            totalSummaryTopGroupRows.getCell(4).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(5);
            totalSummaryTopGroupRows.getCell(5).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(6);
            totalSummaryTopGroupRows.getCell(6).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(7);
            totalSummaryTopGroupRows.getCell(7).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(8);
            totalSummaryTopGroupRows.getCell(8).setCellStyle(totalGroupRowsStyle);

            if (totalSummaries.size() > 0) {
                totalSummaryTopGroupRows.createCell(10).setCellValue(totalSummaries.get(0).getDay01());
                totalSummaryTopGroupRows.createCell(12).setCellValue(totalSummaries.get(0).getDay02());
                totalSummaryTopGroupRows.createCell(14).setCellValue(totalSummaries.get(0).getDay03());
                totalSummaryTopGroupRows.createCell(16).setCellValue(totalSummaries.get(0).getDay04());
                totalSummaryTopGroupRows.createCell(18).setCellValue(totalSummaries.get(0).getDay05());
                totalSummaryTopGroupRows.createCell(20).setCellValue(totalSummaries.get(0).getDay06());
                totalSummaryTopGroupRows.createCell(22).setCellValue(totalSummaries.get(0).getDay07());
                totalSummaryTopGroupRows.createCell(24).setCellValue(totalSummaries.get(0).getDay08());
                totalSummaryTopGroupRows.createCell(26).setCellValue(totalSummaries.get(0).getDay09());
                totalSummaryTopGroupRows.createCell(28).setCellValue(totalSummaries.get(0).getDay10());
                totalSummaryTopGroupRows.createCell(30).setCellValue(totalSummaries.get(0).getDay11());
                totalSummaryTopGroupRows.createCell(32).setCellValue(totalSummaries.get(0).getDay12());
                totalSummaryTopGroupRows.createCell(34).setCellValue(totalSummaries.get(0).getDay13());
                totalSummaryTopGroupRows.createCell(36).setCellValue(totalSummaries.get(0).getDay14());
                totalSummaryTopGroupRows.createCell(38).setCellValue(totalSummaries.get(0).getDay15());
                totalSummaryTopGroupRows.createCell(40).setCellValue(totalSummaries.get(0).getDay16());
                totalSummaryTopGroupRows.createCell(42).setCellValue(totalSummaries.get(0).getDay17());
                totalSummaryTopGroupRows.createCell(44).setCellValue(totalSummaries.get(0).getDay18());
                totalSummaryTopGroupRows.createCell(46).setCellValue(totalSummaries.get(0).getDay19());
                totalSummaryTopGroupRows.createCell(48).setCellValue(totalSummaries.get(0).getDay20());
                totalSummaryTopGroupRows.createCell(50).setCellValue(totalSummaries.get(0).getDay21());
                totalSummaryTopGroupRows.createCell(52).setCellValue(totalSummaries.get(0).getDay22());
                totalSummaryTopGroupRows.createCell(54).setCellValue(totalSummaries.get(0).getDay23());
                totalSummaryTopGroupRows.createCell(56).setCellValue(totalSummaries.get(0).getDay24());
                totalSummaryTopGroupRows.createCell(58).setCellValue(totalSummaries.get(0).getDay25());
                totalSummaryTopGroupRows.createCell(60).setCellValue(totalSummaries.get(0).getDay26());
                totalSummaryTopGroupRows.createCell(62).setCellValue(totalSummaries.get(0).getDay27());
                if (totalSummaries.get(0).getDay28() != null) {
                    totalSummaryTopGroupRows.createCell(64).setCellValue(totalSummaries.get(0).getDay28());
                } else {
                    totalSummaryTopGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay29() != null) {
                    totalSummaryTopGroupRows.createCell(66).setCellValue(totalSummaries.get(0).getDay29());
                } else {
                    totalSummaryTopGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay30() != null) {
                    totalSummaryTopGroupRows.createCell(68).setCellValue(totalSummaries.get(0).getDay30());
                } else {
                    totalSummaryTopGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay31() != null) {
                    totalSummaryTopGroupRows.createCell(70).setCellValue(totalSummaries.get(0).getDay31());
                } else {
                    totalSummaryTopGroupRows.createCell(70).setCellValue(" ");
                }
            }

            totalSummaryTopGroupRows = sheet.createRow(lookupSize + 3);
            totalSummaryTopGroupRows.createCell(0).setCellValue("Total Schedule Backup ");
            totalSummaryTopGroupRows.getCell(0).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(1);
            totalSummaryTopGroupRows.getCell(1).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(2);
            totalSummaryTopGroupRows.getCell(2).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(3);
            totalSummaryTopGroupRows.getCell(3).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(4);
            totalSummaryTopGroupRows.getCell(4).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(5);
            totalSummaryTopGroupRows.getCell(5).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(6);
            totalSummaryTopGroupRows.getCell(6).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(7);
            totalSummaryTopGroupRows.getCell(7).setCellStyle(totalGroupRowsStyle);
            totalSummaryTopGroupRows.createCell(8);
            totalSummaryTopGroupRows.getCell(8).setCellStyle(totalGroupRowsStyle);

            if (totalSummaries.size() > 0) {
                totalSummaryTopGroupRows.createCell(10).setCellValue(totalSummaries.get(1).getDay01());
                totalSummaryTopGroupRows.createCell(12).setCellValue(totalSummaries.get(1).getDay02());
                totalSummaryTopGroupRows.createCell(14).setCellValue(totalSummaries.get(1).getDay03());
                totalSummaryTopGroupRows.createCell(16).setCellValue(totalSummaries.get(1).getDay04());
                totalSummaryTopGroupRows.createCell(18).setCellValue(totalSummaries.get(1).getDay05());
                totalSummaryTopGroupRows.createCell(20).setCellValue(totalSummaries.get(1).getDay06());
                totalSummaryTopGroupRows.createCell(22).setCellValue(totalSummaries.get(1).getDay07());
                totalSummaryTopGroupRows.createCell(24).setCellValue(totalSummaries.get(1).getDay08());
                totalSummaryTopGroupRows.createCell(26).setCellValue(totalSummaries.get(1).getDay09());
                totalSummaryTopGroupRows.createCell(28).setCellValue(totalSummaries.get(1).getDay10());
                totalSummaryTopGroupRows.createCell(30).setCellValue(totalSummaries.get(1).getDay11());
                totalSummaryTopGroupRows.createCell(32).setCellValue(totalSummaries.get(1).getDay12());
                totalSummaryTopGroupRows.createCell(34).setCellValue(totalSummaries.get(1).getDay13());
                totalSummaryTopGroupRows.createCell(36).setCellValue(totalSummaries.get(1).getDay14());
                totalSummaryTopGroupRows.createCell(38).setCellValue(totalSummaries.get(1).getDay15());
                totalSummaryTopGroupRows.createCell(40).setCellValue(totalSummaries.get(1).getDay16());
                totalSummaryTopGroupRows.createCell(42).setCellValue(totalSummaries.get(1).getDay17());
                totalSummaryTopGroupRows.createCell(44).setCellValue(totalSummaries.get(1).getDay18());
                totalSummaryTopGroupRows.createCell(46).setCellValue(totalSummaries.get(1).getDay19());
                totalSummaryTopGroupRows.createCell(48).setCellValue(totalSummaries.get(1).getDay20());
                totalSummaryTopGroupRows.createCell(50).setCellValue(totalSummaries.get(1).getDay21());
                totalSummaryTopGroupRows.createCell(52).setCellValue(totalSummaries.get(1).getDay22());
                totalSummaryTopGroupRows.createCell(54).setCellValue(totalSummaries.get(1).getDay23());
                totalSummaryTopGroupRows.createCell(56).setCellValue(totalSummaries.get(1).getDay24());
                totalSummaryTopGroupRows.createCell(58).setCellValue(totalSummaries.get(1).getDay25());
                totalSummaryTopGroupRows.createCell(60).setCellValue(totalSummaries.get(1).getDay26());
                totalSummaryTopGroupRows.createCell(62).setCellValue(totalSummaries.get(1).getDay27());
                if (totalSummaries.get(0).getDay28() != null) {
                    totalSummaryTopGroupRows.createCell(64).setCellValue(totalSummaries.get(1).getDay28());
                } else {
                    totalSummaryTopGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay29() != null) {
                    totalSummaryTopGroupRows.createCell(66).setCellValue(totalSummaries.get(1).getDay29());
                } else {
                    totalSummaryTopGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay30() != null) {
                    totalSummaryTopGroupRows.createCell(68).setCellValue(totalSummaries.get(1).getDay30());
                } else {
                    totalSummaryTopGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(0).getDay31() != null) {
                    totalSummaryTopGroupRows.createCell(70).setCellValue(totalSummaries.get(1).getDay31());
                } else {
                    totalSummaryTopGroupRows.createCell(70).setCellValue(" ");
                }
            }


            // create content header row
            CellStyle contentHeaderStyle = workbook.createCellStyle();
            Font contentHeaderFont = workbook.createFont();
            contentHeaderFont.setFontName("Arial");
            contentHeaderFont.setColor(HSSFColor.BLACK.index);
            contentHeaderFont.setFontHeightInPoints((short) 10);
            contentHeaderStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
            contentHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            contentHeaderStyle.setBorderTop(BorderStyle.THIN);
            contentHeaderStyle.setBorderLeft(BorderStyle.THIN);
            contentHeaderStyle.setBorderRight(BorderStyle.THIN);
            contentHeaderStyle.setBorderBottom(BorderStyle.THIN);
            contentHeaderStyle.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderStyle.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderStyle.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderStyle.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderStyle.setFont(contentHeaderFont);

            CellStyle contentHeaderDateStyle = workbook.createCellStyle();
            contentHeaderDateStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
            contentHeaderDateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            contentHeaderDateStyle.setBorderTop(BorderStyle.THIN);
            contentHeaderDateStyle.setBorderLeft(BorderStyle.THIN);
            contentHeaderDateStyle.setBorderRight(BorderStyle.THIN);
            contentHeaderDateStyle.setBorderBottom(BorderStyle.THIN);
            contentHeaderDateStyle.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderDateStyle.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderDateStyle.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderDateStyle.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
            contentHeaderDateStyle.setAlignment(HorizontalAlignment.CENTER);

            Row contentHeader;
            contentHeader = sheet.createRow(lookupSize + 5);
            contentHeader.createCell(0);
            contentHeader.getCell(0).setCellValue("Server Name");
            contentHeader.getCell(0).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(1);
            contentHeader.getCell(1).setCellValue("Schedule Name");
            contentHeader.getCell(1).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(2);
            contentHeader.getCell(2).setCellValue("Date Of Week");
            contentHeader.getCell(2).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(3);
            contentHeader.getCell(3).setCellValue("Each Month");
            contentHeader.getCell(3).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(4);
            contentHeader.getCell(4).setCellValue("DATE OF MONTH");
            contentHeader.getCell(4).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(5);
            contentHeader.getCell(5).setCellValue("WEEK OF MONTH");
            contentHeader.getCell(5).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(6);
            contentHeader.getCell(6).setCellValue("BSR");
            contentHeader.getCell(6).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(7);
            contentHeader.getCell(7).setCellValue("Total Scheduled");
            contentHeader.getCell(7).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(8);
            contentHeader.getCell(8).setCellValue("Total Successful");
            contentHeader.getCell(8).setCellStyle(contentHeaderStyle);
            contentHeader.createCell(9);
            contentHeader.getCell(9).setCellValue("");
            contentHeader.getCell(9).setCellStyle(contentHeaderStyle);

            /*
             *
             * #Content Month Header
             *
             * */
            for (int i = 0; i < maxDate; i++) {
                instance.add(Calendar.DATE, 1);
                d = instance.getTime();
                dayofweek = new SimpleDateFormat("u");
                yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
                dayOfWeekIndex = Integer.parseInt(dayofweek.format(d));
                dateCellValueInput = yyyyMMdd.format(d) + weekOfDays[dayOfWeekIndex];
                sheet.addMergedRegion(new CellRangeAddress(lookupSize + 5, lookupSize + 5, 10 + t, 11 + t));
                contentHeader.createCell(10 + t);
                contentHeader.getCell(10 + t).setCellValue(dateCellValueInput);
                contentHeader.getCell(10 + t).setCellStyle(contentHeaderDateStyle);
                contentHeader.createCell(11 + t);
                contentHeader.getCell(11 + t).setCellStyle(contentHeaderDateStyle);
                t = t + 2;
            }
            // must reset parameter t to 0.
            t = 0;


            rowCount = lookupSize + 6;
            //int monthReportsSize = monthReports.size();

            for (MonthReport monthReport : monthReports) {
                Row monthReportContent = sheet.createRow(rowCount++);
                monthReportContent.createCell(0).setCellValue(monthReport.getServerName());
                monthReportContent.createCell(1).setCellValue(monthReport.getScheduleName());
                monthReportContent.createCell(2).setCellValue(monthReport.getDateOfWeek());
                monthReportContent.createCell(3).setCellValue(monthReport.getEachMonth());
                monthReportContent.createCell(4).setCellValue(monthReport.getDateOfMonth());
                monthReportContent.createCell(5).setCellValue(monthReport.getWeekOfMonth());
                //bsr %
                monthReportContent.createCell(6).setCellValue(Double.parseDouble(monthReport.getBsr())/100);
                monthReportContent.createCell(7).setCellValue(Integer.parseInt(monthReport.getTotalSchedule()));
                monthReportContent.createCell(8).setCellValue(Integer.parseInt(monthReport.getTotalSuccessful()));
                monthReportContent.createCell(9).setCellValue("");
                monthReportContent.createCell(10).setCellValue(monthReport.getDay011());
                monthReportContent.createCell(11).setCellValue(monthReport.getDay012());
                if(!StringUtils.isEmpty(monthReport.getBsr())){
                    Double bsr = Double.parseDouble(monthReport.getBsr());
                    if(bsr.compareTo(100.00)<0){
                        //monthReportContent.getCell(6).setCellStyle(lookupCode0Style);
                        monthReportContent.getCell(6).setCellStyle(redRightStyle);
                    }else{
                        //monthReportContent.getCell(6).setCellStyle(lookupCode1Style);
                        monthReportContent.getCell(6).setCellStyle(greenRightStyle);
                    }
                }
                monthReportContent.getCell(7).setCellStyle(rightIntStyle);
                monthReportContent.getCell(8).setCellStyle(rightIntStyle);
                if (monthReport.getDay011().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay011().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay011().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay011().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay011().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay011().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(10).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(11).setCellStyle(lookupCode5Style);
                }

                monthReportContent.createCell(12).setCellValue(monthReport.getDay021());
                monthReportContent.createCell(13).setCellValue(monthReport.getDay022());
                if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay021()!=null && monthReport.getDay021().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(12).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(13).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(14).setCellValue(monthReport.getDay031());
                monthReportContent.createCell(15).setCellValue(monthReport.getDay032());
                if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay031()!=null && monthReport.getDay031().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(14).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(15).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(16).setCellValue(monthReport.getDay041());
                monthReportContent.createCell(17).setCellValue(monthReport.getDay042());
                if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay041()!=null && monthReport.getDay041().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(16).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(17).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(18).setCellValue(monthReport.getDay051());
                monthReportContent.createCell(19).setCellValue(monthReport.getDay052());
                if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay051()!=null && monthReport.getDay051().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(18).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(19).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(20).setCellValue(monthReport.getDay061());
                monthReportContent.createCell(21).setCellValue(monthReport.getDay062());
                if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay061()!=null && monthReport.getDay061().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(20).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(21).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(22).setCellValue(monthReport.getDay071());
                monthReportContent.createCell(23).setCellValue(monthReport.getDay072());
                if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay071()!=null && monthReport.getDay071().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(22).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(23).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(24).setCellValue(monthReport.getDay081());
                monthReportContent.createCell(25).setCellValue(monthReport.getDay082());
                if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay081()!=null && monthReport.getDay081().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(24).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(25).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(26).setCellValue(monthReport.getDay091());
                monthReportContent.createCell(27).setCellValue(monthReport.getDay092());
                if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay091()!=null && monthReport.getDay091().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(26).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(27).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(28).setCellValue(monthReport.getDay101());
                monthReportContent.createCell(29).setCellValue(monthReport.getDay102());
                if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay101()!=null && monthReport.getDay101().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(28).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(29).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(30).setCellValue(monthReport.getDay111());
                monthReportContent.createCell(31).setCellValue(monthReport.getDay112());
                if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay111()!=null && monthReport.getDay111().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(30).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(31).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(32).setCellValue(monthReport.getDay121());
                monthReportContent.createCell(33).setCellValue(monthReport.getDay122());
                if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay121()!=null && monthReport.getDay121().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(32).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(33).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(34).setCellValue(monthReport.getDay131());
                monthReportContent.createCell(35).setCellValue(monthReport.getDay132());
                if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay131()!=null && monthReport.getDay131().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(34).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(35).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(36).setCellValue(monthReport.getDay141());
                monthReportContent.createCell(37).setCellValue(monthReport.getDay142());
                if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay141()!=null && monthReport.getDay141().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(36).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(37).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(38).setCellValue(monthReport.getDay151());
                monthReportContent.createCell(39).setCellValue(monthReport.getDay152());
                if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay151()!=null && monthReport.getDay151().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(38).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(39).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(40).setCellValue(monthReport.getDay161());
                monthReportContent.createCell(41).setCellValue(monthReport.getDay162());
                if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay161()!=null && monthReport.getDay161().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(40).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(41).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(42).setCellValue(monthReport.getDay171());
                monthReportContent.createCell(43).setCellValue(monthReport.getDay172());
                if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay171()!=null && monthReport.getDay171().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(42).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(43).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(44).setCellValue(monthReport.getDay181());
                monthReportContent.createCell(45).setCellValue(monthReport.getDay182());
                if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay181()!=null && monthReport.getDay181().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(44).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(45).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(46).setCellValue(monthReport.getDay191());
                monthReportContent.createCell(47).setCellValue(monthReport.getDay192());
                if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay191()!=null && monthReport.getDay191().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(46).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(47).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(48).setCellValue(monthReport.getDay201());
                monthReportContent.createCell(49).setCellValue(monthReport.getDay202());
                if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay201()!=null && monthReport.getDay201().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(48).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(49).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(50).setCellValue(monthReport.getDay211());
                monthReportContent.createCell(51).setCellValue(monthReport.getDay212());
                if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay211()!=null && monthReport.getDay211().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(50).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(51).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(52).setCellValue(monthReport.getDay221());
                monthReportContent.createCell(53).setCellValue(monthReport.getDay222());
                if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay221()!=null && monthReport.getDay221().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(52).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(53).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(54).setCellValue(monthReport.getDay231());
                monthReportContent.createCell(55).setCellValue(monthReport.getDay232());
                if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay231()!=null && monthReport.getDay231().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(54).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(55).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(56).setCellValue(monthReport.getDay241());
                monthReportContent.createCell(57).setCellValue(monthReport.getDay242());
                if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay241()!=null && monthReport.getDay241().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(56).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(57).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(58).setCellValue(monthReport.getDay251());
                monthReportContent.createCell(59).setCellValue(monthReport.getDay252());
                if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay251()!=null && monthReport.getDay251().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(58).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(59).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(60).setCellValue(monthReport.getDay261());
                monthReportContent.createCell(61).setCellValue(monthReport.getDay262());
                if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay261()!=null && monthReport.getDay261().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(60).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(61).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(62).setCellValue(monthReport.getDay271());
                monthReportContent.createCell(63).setCellValue(monthReport.getDay272());
                if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(63).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(63).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(63).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(62).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(63).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay271()!=null && monthReport.getDay271().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(62).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(63).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(64).setCellValue(monthReport.getDay281());
                monthReportContent.createCell(65).setCellValue(monthReport.getDay282());
                if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay281()!=null && monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(64).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(65).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(66).setCellValue(monthReport.getDay291());
                monthReportContent.createCell(67).setCellValue(monthReport.getDay292());
                if (monthReport.getDay291()!=null && monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay291()!=null && monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay291()!=null && monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(66).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(67).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(68).setCellValue(monthReport.getDay301());
                monthReportContent.createCell(69).setCellValue(monthReport.getDay302());
                if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(68).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(69).setCellStyle(lookupCode5Style);
                }
                monthReportContent.createCell(70).setCellValue(monthReport.getDay311());
                monthReportContent.createCell(71).setCellValue(monthReport.getDay312());
                if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("0")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode0Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode0Style);
                } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("1")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode1Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode1Style);
                } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("2")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode2Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode2Style);
                } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("3")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode3Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode3Style);
                } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("4")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode4Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode4Style);
                } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("5")) {
                    monthReportContent.getCell(70).setCellStyle(lookupCode5Style);
                    monthReportContent.getCell(71).setCellStyle(lookupCode5Style);
                }

            }

            // merge cells for bottom total group rows
            sheet.addMergedRegion(new CellRangeAddress(rowCount + 1, rowCount + 1, 0, 8));
            sheet.addMergedRegion(new CellRangeAddress(rowCount + 2, rowCount + 2, 0, 8));
            sheet.addMergedRegion(new CellRangeAddress(rowCount + 3, rowCount + 3, 0, 8));
            sheet.addMergedRegion(new CellRangeAddress(rowCount + 4, rowCount + 4, 0, 8));

            for (int i = 0; i < maxDate; i++) {
                sheet.addMergedRegion(new CellRangeAddress(rowCount + 1, rowCount + 1, 10 + t, 11 + t));
                sheet.addMergedRegion(new CellRangeAddress(rowCount + 2, rowCount + 2, 10 + t, 11 + t));
                sheet.addMergedRegion(new CellRangeAddress(rowCount + 3, rowCount + 3, 10 + t, 11 + t));
                sheet.addMergedRegion(new CellRangeAddress(rowCount + 4, rowCount + 4, 10 + t, 11 + t));
                t = t + 2;
            }

            Row totalBottomGroupRows;
            totalBottomGroupRows = sheet.createRow(rowCount + 1);
            totalBottomGroupRows.createCell(0).setCellValue("Total Backups (where we exclude the no schedule)");

            if (totalSummaries.size() > 0) {

                totalBottomGroupRows.createCell(10).setCellValue(totalSummaries.get(2).getDay01());
                totalBottomGroupRows.createCell(12).setCellValue(totalSummaries.get(2).getDay02());
                totalBottomGroupRows.createCell(14).setCellValue(totalSummaries.get(2).getDay03());
                totalBottomGroupRows.createCell(16).setCellValue(totalSummaries.get(2).getDay04());
                totalBottomGroupRows.createCell(18).setCellValue(totalSummaries.get(2).getDay05());
                totalBottomGroupRows.createCell(20).setCellValue(totalSummaries.get(2).getDay06());
                totalBottomGroupRows.createCell(22).setCellValue(totalSummaries.get(2).getDay07());
                totalBottomGroupRows.createCell(24).setCellValue(totalSummaries.get(2).getDay08());
                totalBottomGroupRows.createCell(26).setCellValue(totalSummaries.get(2).getDay09());
                totalBottomGroupRows.createCell(28).setCellValue(totalSummaries.get(2).getDay10());
                totalBottomGroupRows.createCell(30).setCellValue(totalSummaries.get(2).getDay11());
                totalBottomGroupRows.createCell(32).setCellValue(totalSummaries.get(2).getDay12());
                totalBottomGroupRows.createCell(34).setCellValue(totalSummaries.get(2).getDay13());
                totalBottomGroupRows.createCell(36).setCellValue(totalSummaries.get(2).getDay14());
                totalBottomGroupRows.createCell(38).setCellValue(totalSummaries.get(2).getDay15());
                totalBottomGroupRows.createCell(40).setCellValue(totalSummaries.get(2).getDay16());
                totalBottomGroupRows.createCell(42).setCellValue(totalSummaries.get(2).getDay17());
                totalBottomGroupRows.createCell(44).setCellValue(totalSummaries.get(2).getDay18());
                totalBottomGroupRows.createCell(46).setCellValue(totalSummaries.get(2).getDay19());
                totalBottomGroupRows.createCell(48).setCellValue(totalSummaries.get(2).getDay20());
                totalBottomGroupRows.createCell(50).setCellValue(totalSummaries.get(2).getDay21());
                totalBottomGroupRows.createCell(52).setCellValue(totalSummaries.get(2).getDay22());
                totalBottomGroupRows.createCell(54).setCellValue(totalSummaries.get(2).getDay23());
                totalBottomGroupRows.createCell(56).setCellValue(totalSummaries.get(2).getDay24());
                totalBottomGroupRows.createCell(58).setCellValue(totalSummaries.get(2).getDay25());
                totalBottomGroupRows.createCell(60).setCellValue(totalSummaries.get(2).getDay26());
                totalBottomGroupRows.createCell(62).setCellValue(totalSummaries.get(2).getDay27());
                if (totalSummaries.get(2).getDay28() != null) {
                    totalBottomGroupRows.createCell(64).setCellValue(totalSummaries.get(2).getDay28());
                } else {
                    totalBottomGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(2).getDay29() != null) {
                    totalBottomGroupRows.createCell(66).setCellValue(totalSummaries.get(2).getDay29());
                } else {
                    totalBottomGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(2).getDay30() != null) {
                    totalBottomGroupRows.createCell(68).setCellValue(totalSummaries.get(2).getDay30());
                } else {
                    totalBottomGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(2).getDay31() != null) {
                    totalBottomGroupRows.createCell(70).setCellValue(totalSummaries.get(2).getDay31());
                } else {
                    totalBottomGroupRows.createCell(70).setCellValue(" ");
                }
            }

            totalBottomGroupRows = sheet.createRow(rowCount + 2);
            totalBottomGroupRows.createCell(0).setCellValue("Total backups success on 1st Run (only counts the number of \"1\")");
            if (totalSummaries.size() > 0) {
                totalBottomGroupRows.createCell(10).setCellValue(totalSummaries.get(3).getDay01());
                totalBottomGroupRows.createCell(12).setCellValue(totalSummaries.get(3).getDay02());
                totalBottomGroupRows.createCell(14).setCellValue(totalSummaries.get(3).getDay03());
                totalBottomGroupRows.createCell(16).setCellValue(totalSummaries.get(3).getDay04());
                totalBottomGroupRows.createCell(18).setCellValue(totalSummaries.get(3).getDay05());
                totalBottomGroupRows.createCell(20).setCellValue(totalSummaries.get(3).getDay06());
                totalBottomGroupRows.createCell(22).setCellValue(totalSummaries.get(3).getDay07());
                totalBottomGroupRows.createCell(24).setCellValue(totalSummaries.get(3).getDay08());
                totalBottomGroupRows.createCell(26).setCellValue(totalSummaries.get(3).getDay09());
                totalBottomGroupRows.createCell(28).setCellValue(totalSummaries.get(3).getDay10());
                totalBottomGroupRows.createCell(30).setCellValue(totalSummaries.get(3).getDay11());
                totalBottomGroupRows.createCell(32).setCellValue(totalSummaries.get(3).getDay12());
                totalBottomGroupRows.createCell(34).setCellValue(totalSummaries.get(3).getDay13());
                totalBottomGroupRows.createCell(36).setCellValue(totalSummaries.get(3).getDay14());
                totalBottomGroupRows.createCell(38).setCellValue(totalSummaries.get(3).getDay15());
                totalBottomGroupRows.createCell(40).setCellValue(totalSummaries.get(3).getDay16());
                totalBottomGroupRows.createCell(42).setCellValue(totalSummaries.get(3).getDay17());
                totalBottomGroupRows.createCell(44).setCellValue(totalSummaries.get(3).getDay18());
                totalBottomGroupRows.createCell(46).setCellValue(totalSummaries.get(3).getDay19());
                totalBottomGroupRows.createCell(48).setCellValue(totalSummaries.get(3).getDay20());
                totalBottomGroupRows.createCell(50).setCellValue(totalSummaries.get(3).getDay21());
                totalBottomGroupRows.createCell(52).setCellValue(totalSummaries.get(3).getDay22());
                totalBottomGroupRows.createCell(54).setCellValue(totalSummaries.get(3).getDay23());
                totalBottomGroupRows.createCell(56).setCellValue(totalSummaries.get(3).getDay24());
                totalBottomGroupRows.createCell(58).setCellValue(totalSummaries.get(3).getDay25());
                totalBottomGroupRows.createCell(60).setCellValue(totalSummaries.get(3).getDay26());
                totalBottomGroupRows.createCell(62).setCellValue(totalSummaries.get(3).getDay27());
                if (totalSummaries.get(3).getDay28() != null) {
                    totalBottomGroupRows.createCell(64).setCellValue(totalSummaries.get(3).getDay28());
                } else {
                    totalBottomGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(3).getDay29() != null) {
                    totalBottomGroupRows.createCell(66).setCellValue(totalSummaries.get(3).getDay29());
                } else {
                    totalBottomGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(3).getDay30() != null) {
                    totalBottomGroupRows.createCell(68).setCellValue(totalSummaries.get(3).getDay30());
                } else {
                    totalBottomGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(3).getDay31() != null) {
                    totalBottomGroupRows.createCell(70).setCellValue(totalSummaries.get(3).getDay31());
                } else {
                    totalBottomGroupRows.createCell(70).setCellValue(" ");
                }
            }

            totalBottomGroupRows = sheet.createRow(rowCount + 3);
            totalBottomGroupRows.createCell(0).setCellValue("Total Backup failed on 1st Run (total backups minus success on 1st run)");

            if (totalSummaries.size() > 0) {

                totalBottomGroupRows.createCell(10).setCellValue(totalSummaries.get(4).getDay01());
                totalBottomGroupRows.createCell(12).setCellValue(totalSummaries.get(4).getDay02());
                totalBottomGroupRows.createCell(14).setCellValue(totalSummaries.get(4).getDay03());
                totalBottomGroupRows.createCell(16).setCellValue(totalSummaries.get(4).getDay04());
                totalBottomGroupRows.createCell(18).setCellValue(totalSummaries.get(4).getDay05());
                totalBottomGroupRows.createCell(20).setCellValue(totalSummaries.get(4).getDay06());
                totalBottomGroupRows.createCell(22).setCellValue(totalSummaries.get(4).getDay07());
                totalBottomGroupRows.createCell(24).setCellValue(totalSummaries.get(4).getDay08());
                totalBottomGroupRows.createCell(26).setCellValue(totalSummaries.get(4).getDay09());
                totalBottomGroupRows.createCell(28).setCellValue(totalSummaries.get(4).getDay10());
                totalBottomGroupRows.createCell(30).setCellValue(totalSummaries.get(4).getDay11());
                totalBottomGroupRows.createCell(32).setCellValue(totalSummaries.get(4).getDay12());
                totalBottomGroupRows.createCell(34).setCellValue(totalSummaries.get(4).getDay13());
                totalBottomGroupRows.createCell(36).setCellValue(totalSummaries.get(4).getDay14());
                totalBottomGroupRows.createCell(38).setCellValue(totalSummaries.get(4).getDay15());
                totalBottomGroupRows.createCell(40).setCellValue(totalSummaries.get(4).getDay16());
                totalBottomGroupRows.createCell(42).setCellValue(totalSummaries.get(4).getDay17());
                totalBottomGroupRows.createCell(44).setCellValue(totalSummaries.get(4).getDay18());
                totalBottomGroupRows.createCell(46).setCellValue(totalSummaries.get(4).getDay19());
                totalBottomGroupRows.createCell(48).setCellValue(totalSummaries.get(4).getDay20());
                totalBottomGroupRows.createCell(50).setCellValue(totalSummaries.get(4).getDay21());
                totalBottomGroupRows.createCell(52).setCellValue(totalSummaries.get(4).getDay22());
                totalBottomGroupRows.createCell(54).setCellValue(totalSummaries.get(4).getDay23());
                totalBottomGroupRows.createCell(56).setCellValue(totalSummaries.get(4).getDay24());
                totalBottomGroupRows.createCell(58).setCellValue(totalSummaries.get(4).getDay25());
                totalBottomGroupRows.createCell(60).setCellValue(totalSummaries.get(4).getDay26());
                totalBottomGroupRows.createCell(62).setCellValue(totalSummaries.get(4).getDay27());
                if (totalSummaries.get(4).getDay28() != null) {
                    totalBottomGroupRows.createCell(64).setCellValue(totalSummaries.get(4).getDay28());
                } else {
                    totalBottomGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(4).getDay29() != null) {
                    totalBottomGroupRows.createCell(66).setCellValue(totalSummaries.get(4).getDay29());
                } else {
                    totalBottomGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(4).getDay30() != null) {
                    totalBottomGroupRows.createCell(68).setCellValue(totalSummaries.get(4).getDay30());
                } else {
                    totalBottomGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(4).getDay31() != null) {
                    totalBottomGroupRows.createCell(70).setCellValue(totalSummaries.get(4).getDay31());
                } else {
                    totalBottomGroupRows.createCell(70).setCellValue(" ");
                }
            }

            totalBottomGroupRows = sheet.createRow(rowCount + 4);
            totalBottomGroupRows.createCell(0).setCellValue("Total Backup success on 2nd run(count those with 2)");

            if (totalSummaries.size() > 0) {

                totalBottomGroupRows.createCell(10).setCellValue(totalSummaries.get(5).getDay01());
                totalBottomGroupRows.createCell(12).setCellValue(totalSummaries.get(5).getDay02());
                totalBottomGroupRows.createCell(14).setCellValue(totalSummaries.get(5).getDay03());
                totalBottomGroupRows.createCell(16).setCellValue(totalSummaries.get(5).getDay04());
                totalBottomGroupRows.createCell(18).setCellValue(totalSummaries.get(5).getDay05());
                totalBottomGroupRows.createCell(20).setCellValue(totalSummaries.get(5).getDay06());
                totalBottomGroupRows.createCell(22).setCellValue(totalSummaries.get(5).getDay07());
                totalBottomGroupRows.createCell(24).setCellValue(totalSummaries.get(5).getDay08());
                totalBottomGroupRows.createCell(26).setCellValue(totalSummaries.get(5).getDay09());
                totalBottomGroupRows.createCell(28).setCellValue(totalSummaries.get(5).getDay10());
                totalBottomGroupRows.createCell(30).setCellValue(totalSummaries.get(5).getDay11());
                totalBottomGroupRows.createCell(32).setCellValue(totalSummaries.get(5).getDay12());
                totalBottomGroupRows.createCell(34).setCellValue(totalSummaries.get(5).getDay13());
                totalBottomGroupRows.createCell(36).setCellValue(totalSummaries.get(5).getDay14());
                totalBottomGroupRows.createCell(38).setCellValue(totalSummaries.get(5).getDay15());
                totalBottomGroupRows.createCell(40).setCellValue(totalSummaries.get(5).getDay16());
                totalBottomGroupRows.createCell(42).setCellValue(totalSummaries.get(5).getDay17());
                totalBottomGroupRows.createCell(44).setCellValue(totalSummaries.get(5).getDay18());
                totalBottomGroupRows.createCell(46).setCellValue(totalSummaries.get(5).getDay19());
                totalBottomGroupRows.createCell(48).setCellValue(totalSummaries.get(5).getDay20());
                totalBottomGroupRows.createCell(50).setCellValue(totalSummaries.get(5).getDay21());
                totalBottomGroupRows.createCell(52).setCellValue(totalSummaries.get(5).getDay22());
                totalBottomGroupRows.createCell(54).setCellValue(totalSummaries.get(5).getDay23());
                totalBottomGroupRows.createCell(56).setCellValue(totalSummaries.get(5).getDay24());
                totalBottomGroupRows.createCell(58).setCellValue(totalSummaries.get(5).getDay25());
                totalBottomGroupRows.createCell(60).setCellValue(totalSummaries.get(5).getDay26());
                totalBottomGroupRows.createCell(62).setCellValue(totalSummaries.get(5).getDay27());
                if (totalSummaries.get(5).getDay28() != null) {
                    totalBottomGroupRows.createCell(64).setCellValue(totalSummaries.get(5).getDay28());
                } else {
                    totalBottomGroupRows.createCell(64).setCellValue(" ");
                }
                if (totalSummaries.get(5).getDay29() != null) {
                    totalBottomGroupRows.createCell(66).setCellValue(totalSummaries.get(5).getDay29());
                } else {
                    totalBottomGroupRows.createCell(66).setCellValue(" ");
                }
                if (totalSummaries.get(5).getDay30() != null) {
                    totalBottomGroupRows.createCell(68).setCellValue(totalSummaries.get(5).getDay30());
                } else {
                    totalBottomGroupRows.createCell(68).setCellValue(" ");
                }
                if (totalSummaries.get(5).getDay31() != null) {
                    totalBottomGroupRows.createCell(70).setCellValue(totalSummaries.get(5).getDay31());
                } else {
                    totalBottomGroupRows.createCell(70).setCellValue(" ");
                }
            }

            // insert value for total bottom group. for()

            sheet.addMergedRegion(new CellRangeAddress(rowCount + 6, rowCount + 6, 0, 1));
            sheet.addMergedRegion(new CellRangeAddress(rowCount + 6, rowCount + 6, 2, 3));
            Row lookupBottomTitleRow = sheet.createRow(rowCount + 6);
            lookupBottomTitleRow.createCell(0).setCellValue("Details");
            lookupBottomTitleRow.createCell(2).setCellValue("Legend");
            lookupBottomTitleRow.createCell(4).setCellValue("Count");

            // create bottom lookup table.
            for (int i = 0; i < lookupSize; i++) {
                sheet.addMergedRegion(new CellRangeAddress(i + rowCount + 7, i + rowCount + 7, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(i + rowCount + 7, i + rowCount + 7, 2, 3));
            }

            rowCount = rowCount + 7;
            int tempIndicator = 0;
            for (Lookup lookupBottom : lookups) {

                Row lookupBottomRow = sheet.createRow(rowCount++);
                lookupColumn2Style.setFillForegroundColor((short) 9);
                lookupColumn2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                lookupBottomRow.createCell(0).setCellValue(lookupBottom.getTitle());
                lookupBottomRow.getCell(0).setCellStyle(lookupColumn1Style);
                lookupBottomRow.createCell(1);
                lookupBottomRow.getCell(1).setCellStyle(lookupColumn1Style);

                lookupBottomRow.createCell(2).setCellValue(lookupBottom.getCode());
                lookupBottomRow.createCell(3);
                if (lookupBottom.getCode().equalsIgnoreCase("0")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode0Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode0Style);
                } else if (lookupBottom.getCode().equalsIgnoreCase("1")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode1Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode1Style);
                } else if (lookupBottom.getCode().equalsIgnoreCase("2")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode2Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode2Style);
                } else if (lookupBottom.getCode().equalsIgnoreCase("3")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode3Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode3Style);
                } else if (lookupBottom.getCode().equalsIgnoreCase("4")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode4Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode4Style);
                } else if (lookupBottom.getCode().equalsIgnoreCase("5")) {
                    lookupBottomRow.getCell(2).setCellStyle(lookupCode5Style);
                    lookupBottomRow.getCell(3).setCellStyle(lookupCode5Style);
                } else {

                }
                if (lookupSummaries.size() > 0) {
                    lookupBottomRow.createCell(4).setCellValue(lookupSummaries.get(tempIndicator).getCount());
                    lookupBottomRow.getCell(4).setCellStyle(lookupCountStyle);
                    tempIndicator++;
                }
            }

            try {
                log.info("### ATTENTION PLEASE LOG INFO : EXCEL GENERATION START AT:  {}", dateFormat.format(new Date()));
                FileOutputStream out = new FileOutputStream(path + month + "_MonthReport_daily.xls");
                workbook.write(out);
                out.close();
                log.info("### ATTENTION PLEASE LOG INFO : Excel GENERATION COMPLETED SUCCESSFULLY:  {}", dateFormat.format(new Date()));
                return "200";
            } catch (Exception e) {
                log.error("### ATTENTION PLEASE LOG INFO : Excel GENERATION FAILED:  {}", dateFormat.format(new Date()));
                return "505";
            }
        }
    }
}
