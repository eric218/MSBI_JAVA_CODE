package com.hpe.msbireport.view;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.domain.MonthReport;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
//import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: ...
 */
public class ExcelView extends AbstractXlsxStreamingView {

    final String[] weekOfDays = {"", "(Monday)", "(Tuesday)", "(Wednesday)", "(Thursday)", "(Friday)", "(Saturday)", "(Sunday)"};

    public static int getDaysByYearMonth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    /*
     * Main Section to generate a mbsi report excel file.
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        // change the file name to MonthReport_daily11.xlsx
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"MonthReport_daily11.xlsx\"");

        @SuppressWarnings("unchecked")
        List<Lookup> lookups = (List<Lookup>) map.get("lookups");
        @SuppressWarnings("unchecked")
        List<MonthReport> monthReports = (List<MonthReport>) map.get("monthReports");


        // get month
        String month = (String) map.get("month");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("MonthReport_daily");
        //sheet.setDefaultColumnWidth(18);

        // create style for header cells
//        CellStyle style = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short) 10);
//        style.setFillForegroundColor(HSSFColor.DARK_BLUE.index);
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        font.setBold(true);
//        font.setColor(HSSFColor.WHITE.index);
//        style.setFont(font);

        // title ttyle report title, e.g.. "MonthReport - Daily( 20170401 )"
        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setFontName("Tahoma");
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setColor(HSSFColor.SKY_BLUE.index);
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
        lookupColumn1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        lookupColumn1Style.setFillForegroundColor(HSSFColor.BLACK.index);
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

        for (int i = 0; i < lookupSize; i++) {
            sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 0, 1));
            sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 2, 3));
        }

        for (Lookup lookup : lookups) {

            Row lookupRow = sheet.createRow(rowCount++);
            lookupColumn2Style.setFillForegroundColor((short) 9);
            lookupColumn2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            lookupRow.createCell(0).setCellValue(lookup.getTitle());
            lookupRow.getCell(0).setCellStyle(lookupColumn1Style);
            lookupRow.createCell(1);
            lookupRow.getCell(1).setCellStyle(lookupColumn1Style);

            lookupRow.createCell(2).setCellValue(lookup.getCode());
            lookupRow.getCell(2).setCellStyle(lookupColumn2Style);
            lookupRow.createCell(3);
            lookupRow.getCell(3).setCellStyle(lookupColumn2Style);
        }

        // merge cells for total group rows
        sheet.addMergedRegion(new CellRangeAddress(lookupSize + 2, lookupSize + 2, 0, 8));
        sheet.addMergedRegion(new CellRangeAddress(lookupSize + 3, lookupSize + 3, 0, 8));
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

        Row totalGroupRows;
        totalGroupRows = sheet.createRow(lookupSize + 2);

        totalGroupRows.createCell(0).setCellValue("Total Failed to recover");
        totalGroupRows.getCell(0).setCellStyle(totalGroupRowsStyle);

        totalGroupRows.createCell(1);
        totalGroupRows.getCell(1).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(2);
        totalGroupRows.getCell(2).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(3);
        totalGroupRows.getCell(3).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(4);
        totalGroupRows.getCell(4).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(5);
        totalGroupRows.getCell(5).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(6);
        totalGroupRows.getCell(6).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(7);
        totalGroupRows.getCell(7).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(8);
        totalGroupRows.getCell(8).setCellStyle(totalGroupRowsStyle);


        totalGroupRows = sheet.createRow(lookupSize + 3);
        totalGroupRows.createCell(0).setCellValue("Total Schedule Backup ");
        totalGroupRows.getCell(0).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(1);
        totalGroupRows.getCell(1).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(2);
        totalGroupRows.getCell(2).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(3);
        totalGroupRows.getCell(3).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(4);
        totalGroupRows.getCell(4).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(5);
        totalGroupRows.getCell(5).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(6);
        totalGroupRows.getCell(6).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(7);
        totalGroupRows.getCell(7).setCellStyle(totalGroupRowsStyle);
        totalGroupRows.createCell(8);
        totalGroupRows.getCell(8).setCellStyle(totalGroupRowsStyle);


        // create content header row
        CellStyle contentHeaderStyle = workbook.createCellStyle();
        Font contentHeaderFont = workbook.createFont();
        contentHeaderFont.setFontName("Arial");
        contentHeaderFont.setColor(HSSFColor.BLACK.index);
        contentHeaderFont.setFontHeightInPoints((short) 10);
        contentHeaderStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
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
        contentHeaderDateStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
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

        int t = 0;
        Date d;
        SimpleDateFormat dayofweek;
        SimpleDateFormat yyyyMMdd;
        int dayOfWeekIndex;
        String dateCellValueInput;

        int t_year = Integer.parseInt(month.substring(0, 4));
        int t_month = Integer.parseInt(month.substring(4, 6));
        int maxDate = getDaysByYearMonth(t_year, t_month);
        System.out.println("The input month date: " + maxDate);

        Calendar instance = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date monthInput = sdf.parse(month);
        instance.setTime(monthInput);
        instance.set(Calendar.DAY_OF_MONTH, 0);// start from 1 of this month.

        for (int i = 0; i < maxDate; i++) {
            instance.add(Calendar.DATE, 1);
            d = instance.getTime();
            dayofweek = new SimpleDateFormat("u");
            yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
            dayOfWeekIndex = Integer.parseInt(dayofweek.format(d));
            dateCellValueInput = yyyyMMdd.format(d) + weekOfDays[dayOfWeekIndex];
            System.out.println("This is the input value for date cell : " + dateCellValueInput);
            sheet.addMergedRegion(new CellRangeAddress(lookupSize + 5, lookupSize + 5, 10 + t, 11 + t));
            contentHeader.createCell(10 + t);
            contentHeader.getCell(10 + t).setCellValue(dateCellValueInput);
            contentHeader.getCell(10 + t).setCellStyle(contentHeaderDateStyle);
            contentHeader.createCell(11 + t);
            contentHeader.getCell(11 + t).setCellStyle(contentHeaderDateStyle);
            t = t + 2;
        }

        rowCount = lookupSize + 6;
        int monthReportsSize = monthReports.size();

        // display content data in center
        CellStyle monthReportContentStyle = workbook.createCellStyle();
        monthReportContentStyle.setAlignment(HorizontalAlignment.CENTER);


        for (MonthReport monthReport : monthReports) {
            Row monthReportContent = sheet.createRow(rowCount++);
            monthReportContent.createCell(0).setCellValue(monthReport.getServerName());
            monthReportContent.createCell(1).setCellValue(monthReport.getScheduleName());
            monthReportContent.createCell(2).setCellValue(monthReport.getDateOfWeek());
            monthReportContent.createCell(3).setCellValue(monthReport.getEachMonth());
            monthReportContent.createCell(4).setCellValue(monthReport.getDateOfMonth());
            monthReportContent.createCell(5).setCellValue(monthReport.getWeekOfMonth());
            monthReportContent.createCell(6).setCellValue(monthReport.getBsr());
            monthReportContent.createCell(7).setCellValue(monthReport.getTotalSchedule());
            monthReportContent.createCell(8).setCellValue(monthReport.getTotalSuccessful());
            monthReportContent.createCell(9).setCellValue("");
            monthReportContent.createCell(10).setCellValue(monthReport.getDay011());
            monthReportContent.getCell(10).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(11).setCellValue(monthReport.getDay012());
            monthReportContent.getCell(11).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(12).setCellValue(monthReport.getDay021());
            monthReportContent.getCell(12).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(13).setCellValue(monthReport.getDay022());
            monthReportContent.getCell(13).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(14).setCellValue(monthReport.getDay031());
            monthReportContent.getCell(14).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(15).setCellValue(monthReport.getDay032());
            monthReportContent.getCell(15).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(16).setCellValue(monthReport.getDay041());
            monthReportContent.getCell(16).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(17).setCellValue(monthReport.getDay042());
            monthReportContent.getCell(17).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(18).setCellValue(monthReport.getDay051());
            monthReportContent.getCell(18).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(19).setCellValue(monthReport.getDay052());
            monthReportContent.getCell(19).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(20).setCellValue(monthReport.getDay061());
            monthReportContent.getCell(20).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(21).setCellValue(monthReport.getDay062());
            monthReportContent.getCell(21).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(22).setCellValue(monthReport.getDay071());
            monthReportContent.getCell(22).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(23).setCellValue(monthReport.getDay072());
            monthReportContent.getCell(23).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(24).setCellValue(monthReport.getDay081());
            monthReportContent.getCell(24).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(25).setCellValue(monthReport.getDay082());
            monthReportContent.getCell(25).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(26).setCellValue(monthReport.getDay091());
            monthReportContent.getCell(26).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(27).setCellValue(monthReport.getDay092());
            monthReportContent.getCell(27).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(28).setCellValue(monthReport.getDay101());
            monthReportContent.getCell(28).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(29).setCellValue(monthReport.getDay102());
            monthReportContent.getCell(29).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(30).setCellValue(monthReport.getDay111());
            monthReportContent.getCell(30).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(31).setCellValue(monthReport.getDay112());
            monthReportContent.getCell(31).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(32).setCellValue(monthReport.getDay121());
            monthReportContent.getCell(32).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(33).setCellValue(monthReport.getDay122());
            monthReportContent.getCell(33).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(34).setCellValue(monthReport.getDay131());
            monthReportContent.getCell(34).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(35).setCellValue(monthReport.getDay132());
            monthReportContent.getCell(35).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(36).setCellValue(monthReport.getDay141());
            monthReportContent.getCell(36).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(37).setCellValue(monthReport.getDay142());
            monthReportContent.getCell(37).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(38).setCellValue(monthReport.getDay151());
            monthReportContent.getCell(38).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(39).setCellValue(monthReport.getDay152());
            monthReportContent.getCell(39).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(40).setCellValue(monthReport.getDay161());
            monthReportContent.getCell(40).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(41).setCellValue(monthReport.getDay162());
            monthReportContent.getCell(41).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(42).setCellValue(monthReport.getDay171());
            monthReportContent.getCell(42).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(43).setCellValue(monthReport.getDay172());
            monthReportContent.getCell(43).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(44).setCellValue(monthReport.getDay181());
            monthReportContent.getCell(44).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(45).setCellValue(monthReport.getDay182());
            monthReportContent.getCell(45).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(46).setCellValue(monthReport.getDay191());
            monthReportContent.getCell(46).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(47).setCellValue(monthReport.getDay192());
            monthReportContent.getCell(47).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(48).setCellValue(monthReport.getDay201());
            monthReportContent.getCell(48).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(49).setCellValue(monthReport.getDay202());
            monthReportContent.getCell(49).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(50).setCellValue(monthReport.getDay211());
            monthReportContent.getCell(50).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(51).setCellValue(monthReport.getDay212());
            monthReportContent.getCell(51).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(52).setCellValue(monthReport.getDay221());
            monthReportContent.getCell(52).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(53).setCellValue(monthReport.getDay222());
            monthReportContent.getCell(53).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(54).setCellValue(monthReport.getDay231());
            monthReportContent.getCell(54).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(55).setCellValue(monthReport.getDay232());
            monthReportContent.getCell(55).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(56).setCellValue(monthReport.getDay241());
            monthReportContent.getCell(56).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(57).setCellValue(monthReport.getDay242());
            monthReportContent.getCell(57).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(58).setCellValue(monthReport.getDay251());
            monthReportContent.getCell(58).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(59).setCellValue(monthReport.getDay252());
            monthReportContent.getCell(59).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(60).setCellValue(monthReport.getDay261());
            monthReportContent.getCell(60).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(61).setCellValue(monthReport.getDay262());
            monthReportContent.getCell(61).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(62).setCellValue(monthReport.getDay271());
            monthReportContent.getCell(62).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(63).setCellValue(monthReport.getDay272());
            monthReportContent.getCell(63).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(64).setCellValue(monthReport.getDay281());
            monthReportContent.getCell(64).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(65).setCellValue(monthReport.getDay282());
            monthReportContent.getCell(65).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(66).setCellValue(monthReport.getDay291());
            monthReportContent.getCell(66).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(67).setCellValue(monthReport.getDay292());
            monthReportContent.getCell(67).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(68).setCellValue(monthReport.getDay301());
            monthReportContent.getCell(68).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(69).setCellValue(monthReport.getDay302());
            monthReportContent.getCell(69).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(70).setCellValue(monthReport.getDay311());
            monthReportContent.getCell(70).setCellStyle(monthReportContentStyle);
            monthReportContent.createCell(71).setCellValue(monthReport.getDay312());
            monthReportContent.getCell(71).setCellStyle(monthReportContentStyle);

        }

        rowCount = rowCount + monthReportsSize + 2;
        System.out.println(" Current rows : " + rowCount);





    }

}
