package com.hpe.msbireport.utils;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-03-06
 * Time: 10:38 AM
 */
public class ExcelUnits {
    public CellStyle setRedRightStyle(HSSFWorkbook workbook){
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        // background color 0 - RED
        style.setFillForegroundColor(HSSFColor.RED.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
        //设置百分比
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        return style;
    }

    public CellStyle setGreenRightStyle(HSSFWorkbook workbook){
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        // background color 0 - RED
        style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setTopBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setBottomBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_25_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_25_PERCENT.index);
        //设置百分比
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        return style;
    }

    public CellStyle setRightStyle(HSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        return style;
    }

    public CellStyle setRightIntStyle(HSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,#0"));
        return style;
    }
}
