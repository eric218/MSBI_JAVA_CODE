package com.hpe.msbireport.utils;

import com.hpe.msbireport.domain.LookupSummary;
import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.TotalSummary;

import java.util.*;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 4/1/18
 * Description: ...
 */
public class CommonUtils {

    public int getDaysByYearMonth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }


    public List<TotalSummary> computeSummaryForMonthReportContent(List<MonthReport> monthReportList) {
        TotalSummary totalSummaryCode1 = new TotalSummary();
        TotalSummary totalSummaryCode2 = new TotalSummary();
        TotalSummary totalSummaryCode3 = new TotalSummary();
        TotalSummary totalSummaryCode4 = new TotalSummary();
        TotalSummary totalSummaryCode5 = new TotalSummary();
        TotalSummary totalSummaryCdoe6 = new TotalSummary();

        List<TotalSummary> totalSummaries = new ArrayList<TotalSummary>();

        totalSummaryCode1.setId(1);
        totalSummaryCode2.setId(2);
        totalSummaryCode3.setId(3);
        totalSummaryCode4.setId(4);
        totalSummaryCode5.setId(5);
        totalSummaryCdoe6.setId(6);

        int code01_0 = 0;
        int code01_1 = 0;
        int code01_2 = 0;
        int code01_3 = 0;
        int code01_4 = 0;
        int code01_5 = 0;

        int code02_0 = 0;
        int code02_1 = 0;
        int code02_2 = 0;
        int code02_3 = 0;
        int code02_4 = 0;
        int code02_5 = 0;

        int code03_0 = 0;
        int code03_1 = 0;
        int code03_2 = 0;
        int code03_3 = 0;
        int code03_4 = 0;
        int code03_5 = 0;

        int code04_0 = 0;
        int code04_1 = 0;
        int code04_2 = 0;
        int code04_3 = 0;
        int code04_4 = 0;
        int code04_5 = 0;

        int code05_0 = 0;
        int code05_1 = 0;
        int code05_2 = 0;
        int code05_3 = 0;
        int code05_4 = 0;
        int code05_5 = 0;

        int code06_0 = 0;
        int code06_1 = 0;
        int code06_2 = 0;
        int code06_3 = 0;
        int code06_4 = 0;
        int code06_5 = 0;

        int code07_0 = 0;
        int code07_1 = 0;
        int code07_2 = 0;
        int code07_3 = 0;
        int code07_4 = 0;
        int code07_5 = 0;

        int code08_0 = 0;
        int code08_1 = 0;
        int code08_2 = 0;
        int code08_3 = 0;
        int code08_4 = 0;
        int code08_5 = 0;

        int code09_0 = 0;
        int code09_1 = 0;
        int code09_2 = 0;
        int code09_3 = 0;
        int code09_4 = 0;
        int code09_5 = 0;

        int code10_0 = 0;
        int code10_1 = 0;
        int code10_2 = 0;
        int code10_3 = 0;
        int code10_4 = 0;
        int code10_5 = 0;

        int code11_0 = 0;
        int code11_1 = 0;
        int code11_2 = 0;
        int code11_3 = 0;
        int code11_4 = 0;
        int code11_5 = 0;

        int code12_0 = 0;
        int code12_1 = 0;
        int code12_2 = 0;
        int code12_3 = 0;
        int code12_4 = 0;
        int code12_5 = 0;

        int code13_0 = 0;
        int code13_1 = 0;
        int code13_2 = 0;
        int code13_3 = 0;
        int code13_4 = 0;
        int code13_5 = 0;

        int code14_0 = 0;
        int code14_1 = 0;
        int code14_2 = 0;
        int code14_3 = 0;
        int code14_4 = 0;
        int code14_5 = 0;

        int code15_0 = 0;
        int code15_1 = 0;
        int code15_2 = 0;
        int code15_3 = 0;
        int code15_4 = 0;
        int code15_5 = 0;

        int code16_0 = 0;
        int code16_1 = 0;
        int code16_2 = 0;
        int code16_3 = 0;
        int code16_4 = 0;
        int code16_5 = 0;

        int code17_0 = 0;
        int code17_1 = 0;
        int code17_2 = 0;
        int code17_3 = 0;
        int code17_4 = 0;
        int code17_5 = 0;

        int code18_0 = 0;
        int code18_1 = 0;
        int code18_2 = 0;
        int code18_3 = 0;
        int code18_4 = 0;
        int code18_5 = 0;

        int code19_0 = 0;
        int code19_1 = 0;
        int code19_2 = 0;
        int code19_3 = 0;
        int code19_4 = 0;
        int code19_5 = 0;

        int code20_0 = 0;
        int code20_1 = 0;
        int code20_2 = 0;
        int code20_3 = 0;
        int code20_4 = 0;
        int code20_5 = 0;

        int code21_0 = 0;
        int code21_1 = 0;
        int code21_2 = 0;
        int code21_3 = 0;
        int code21_4 = 0;
        int code21_5 = 0;

        int code22_0 = 0;
        int code22_1 = 0;
        int code22_2 = 0;
        int code22_3 = 0;
        int code22_4 = 0;
        int code22_5 = 0;

        int code23_0 = 0;
        int code23_1 = 0;
        int code23_2 = 0;
        int code23_3 = 0;
        int code23_4 = 0;
        int code23_5 = 0;

        int code24_0 = 0;
        int code24_1 = 0;
        int code24_2 = 0;
        int code24_3 = 0;
        int code24_4 = 0;
        int code24_5 = 0;

        int code25_0 = 0;
        int code25_1 = 0;
        int code25_2 = 0;
        int code25_3 = 0;
        int code25_4 = 0;
        int code25_5 = 0;

        int code26_0 = 0;
        int code26_1 = 0;
        int code26_2 = 0;
        int code26_3 = 0;
        int code26_4 = 0;
        int code26_5 = 0;

        int code27_0 = 0;
        int code27_1 = 0;
        int code27_2 = 0;
        int code27_3 = 0;
        int code27_4 = 0;
        int code27_5 = 0;

        int code28_0 = 0;
        int code28_1 = 0;
        int code28_2 = 0;
        int code28_3 = 0;
        int code28_4 = 0;
        int code28_5 = 0;

        int code29_0 = 0;
        int code29_1 = 0;
        int code29_2 = 0;
        int code29_3 = 0;
        int code29_4 = 0;
        int code29_5 = 0;

        int code30_0 = 0;
        int code30_1 = 0;
        int code30_2 = 0;
        int code30_3 = 0;
        int code30_4 = 0;
        int code30_5 = 0;

        int code31_0 = 0;
        int code31_1 = 0;
        int code31_2 = 0;
        int code31_3 = 0;
        int code31_4 = 0;
        int code31_5 = 0;


        for (MonthReport monthReport : monthReportList) {
            // day 1
            if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("0")) {
                code01_0++;
            } else if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("1")) {
                code01_1++;
            } else if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("2")) {
                code01_2++;
            } else if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("3")) {
                code01_3++;
            } else if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("4")) {
                code01_4++;
            } else if (monthReport.getDay011() != null && monthReport.getDay011().equalsIgnoreCase("5")) {
                code01_5++;
            }
            // day 2
            if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("0")) {
                code02_0++;
            } else if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("1")) {
                code02_1++;
            } else if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("2")) {
                code02_2++;
            } else if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("3")) {
                code02_3++;
            } else if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("4")) {
                code02_4++;
            } else if (monthReport.getDay021() != null && monthReport.getDay021().equalsIgnoreCase("5")) {
                code02_5++;
            }
            // day 3
            if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("0")) {
                code03_0++;
            } else if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("1")) {
                code03_1++;
            } else if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("2")) {
                code03_2++;
            } else if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("3")) {
                code03_3++;
            } else if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("4")) {
                code03_4++;
            } else if (monthReport.getDay031() != null && monthReport.getDay031().equalsIgnoreCase("5")) {
                code03_5++;
            }
            // day 4
            if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("0")) {
                code04_0++;
            } else if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("1")) {
                code04_1++;
            } else if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("2")) {
                code04_2++;
            } else if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("3")) {
                code04_3++;
            } else if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("4")) {
                code04_4++;
            } else if (monthReport.getDay041() != null && monthReport.getDay041().equalsIgnoreCase("5")) {
                code04_5++;
            }
            // day 5
            if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("0")) {
                code05_0++;
            } else if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("1")) {
                code05_1++;
            } else if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("2")) {
                code05_2++;
            } else if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("3")) {
                code05_3++;
            } else if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("4")) {
                code05_4++;
            } else if (monthReport.getDay051() != null && monthReport.getDay051().equalsIgnoreCase("5")) {
                code05_5++;
            }
            // day 6
            if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("0")) {
                code06_0++;
            } else if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("1")) {
                code06_1++;
            } else if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("2")) {
                code06_2++;
            } else if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("3")) {
                code06_3++;
            } else if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("4")) {
                code06_4++;
            } else if (monthReport.getDay061() != null && monthReport.getDay061().equalsIgnoreCase("5")) {
                code06_5++;
            }
            // day 7
            if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("0")) {
                code07_0++;
            } else if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("1")) {
                code07_1++;
            } else if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("2")) {
                code07_2++;
            } else if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("3")) {
                code07_3++;
            } else if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("4")) {
                code07_4++;
            } else if (monthReport.getDay071() != null && monthReport.getDay071().equalsIgnoreCase("5")) {
                code07_5++;
            }
            // day 8
            if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("0")) {
                code08_0++;
            } else if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("1")) {
                code08_1++;
            } else if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("2")) {
                code08_2++;
            } else if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("3")) {
                code08_3++;
            } else if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("4")) {
                code08_4++;
            } else if (monthReport.getDay081() != null && monthReport.getDay081().equalsIgnoreCase("5")) {
                code08_5++;
            }
            // day 9
            if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("0")) {
                code09_0++;
            } else if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("1")) {
                code09_1++;
            } else if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("2")) {
                code09_2++;
            } else if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("3")) {
                code09_3++;
            } else if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("4")) {
                code09_4++;
            } else if (monthReport.getDay091() != null && monthReport.getDay091().equalsIgnoreCase("5")) {
                code09_5++;
            }
            // day 10
            if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("0")) {
                code10_0++;
            } else if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("1")) {
                code10_1++;
            } else if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("2")) {
                code10_2++;
            } else if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("3")) {
                code10_3++;
            } else if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("4")) {
                code10_4++;
            } else if (monthReport.getDay101() != null && monthReport.getDay101().equalsIgnoreCase("5")) {
                code10_5++;
            }
            // day 11m
            if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("0")) {
                code11_0++;
            } else if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("1")) {
                code11_1++;
            } else if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("2")) {
                code11_2++;
            } else if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("3")) {
                code11_3++;
            } else if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("4")) {
                code11_4++;
            } else if (monthReport.getDay111() != null && monthReport.getDay111().equalsIgnoreCase("5")) {
                code11_5++;
            }

            if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("0")) {
                code12_0++;
            } else if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("1")) {
                code12_1++;
            } else if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("2")) {
                code12_2++;
            } else if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("3")) {
                code12_3++;
            } else if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("4")) {
                code12_4++;
            } else if (monthReport.getDay121() != null && monthReport.getDay121().equalsIgnoreCase("5")) {
                code12_5++;
            }

            if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("0")) {
                code13_0++;
            } else if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("1")) {
                code13_1++;
            } else if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("2")) {
                code13_2++;
            } else if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("3")) {
                code13_3++;
            } else if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("4")) {
                code13_4++;
            } else if (monthReport.getDay131() != null && monthReport.getDay131().equalsIgnoreCase("5")) {
                code13_5++;
            }

            if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("0")) {
                code14_0++;
            } else if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("1")) {
                code14_1++;
            } else if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("2")) {
                code14_2++;
            } else if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("3")) {
                code14_3++;
            } else if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("4")) {
                code14_4++;
            } else if (monthReport.getDay141() != null && monthReport.getDay141().equalsIgnoreCase("5")) {
                code14_5++;
            }

            if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("0")) {
                code15_0++;
            } else if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("1")) {
                code15_1++;
            } else if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("2")) {
                code15_2++;
            } else if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("3")) {
                code15_3++;
            } else if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("4")) {
                code15_4++;
            } else if (monthReport.getDay151() != null && monthReport.getDay151().equalsIgnoreCase("5")) {
                code15_5++;
            }

            if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("0")) {
                code16_0++;
            } else if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("1")) {
                code16_1++;
            } else if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("2")) {
                code16_2++;
            } else if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("3")) {
                code16_3++;
            } else if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("4")) {
                code16_4++;
            } else if (monthReport.getDay161() != null && monthReport.getDay161().equalsIgnoreCase("5")) {
                code16_5++;
            }

            if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("0")) {
                code17_0++;
            } else if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("1")) {
                code17_1++;
            } else if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("2")) {
                code17_2++;
            } else if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("3")) {
                code17_3++;
            } else if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("4")) {
                code17_4++;
            } else if (monthReport.getDay171() != null && monthReport.getDay171().equalsIgnoreCase("5")) {
                code17_5++;
            }

            if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("0")) {
                code18_0++;
            } else if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("1")) {
                code18_1++;
            } else if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("2")) {
                code18_2++;
            } else if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("3")) {
                code18_3++;
            } else if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("4")) {
                code18_4++;
            } else if (monthReport.getDay181() != null && monthReport.getDay181().equalsIgnoreCase("5")) {
                code18_5++;
            }

            if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("0")) {
                code19_0++;
            } else if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("1")) {
                code19_1++;
            } else if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("2")) {
                code19_2++;
            } else if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("3")) {
                code19_3++;
            } else if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("4")) {
                code19_4++;
            } else if (monthReport.getDay191() != null && monthReport.getDay191().equalsIgnoreCase("5")) {
                code19_5++;
            }

            if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("0")) {
                code10_0++;
            } else if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("1")) {
                code10_1++;
            } else if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("2")) {
                code10_2++;
            } else if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("3")) {
                code10_3++;
            } else if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("4")) {
                code10_4++;
            } else if (monthReport.getDay201() != null && monthReport.getDay201().equalsIgnoreCase("5")) {
                code10_5++;
            }


            if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("0")) {
                code21_0++;
            } else if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("1")) {
                code21_1++;
            } else if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("2")) {
                code21_2++;
            } else if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("3")) {
                code21_3++;
            } else if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("4")) {
                code21_4++;
            } else if (monthReport.getDay211() != null && monthReport.getDay211().equalsIgnoreCase("5")) {
                code21_5++;
            }

            if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("0")) {
                code22_0++;
            } else if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("1")) {
                code22_1++;
            } else if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("2")) {
                code22_2++;
            } else if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("3")) {
                code22_3++;
            } else if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("4")) {
                code22_4++;
            } else if (monthReport.getDay221() != null && monthReport.getDay221().equalsIgnoreCase("5")) {
                code22_5++;
            }

            if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("0")) {
                code23_0++;
            } else if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("1")) {
                code23_1++;
            } else if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("2")) {
                code23_2++;
            } else if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("3")) {
                code23_3++;
            } else if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("4")) {
                code23_4++;
            } else if (monthReport.getDay231() != null && monthReport.getDay231().equalsIgnoreCase("5")) {
                code23_5++;
            }

            if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("0")) {
                code24_0++;
            } else if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("1")) {
                code24_1++;
            } else if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("2")) {
                code24_2++;
            } else if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("3")) {
                code24_3++;
            } else if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("4")) {
                code24_4++;
            } else if (monthReport.getDay241() != null && monthReport.getDay241().equalsIgnoreCase("5")) {
                code24_5++;
            }

            if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("0")) {
                code25_0++;
            } else if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("1")) {
                code25_1++;
            } else if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("2")) {
                code25_2++;
            } else if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("3")) {
                code25_3++;
            } else if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("4")) {
                code25_4++;
            } else if (monthReport.getDay251() != null && monthReport.getDay251().equalsIgnoreCase("5")) {
                code25_5++;
            }

            if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("0")) {
                code26_0++;
            } else if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("1")) {
                code26_1++;
            } else if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("2")) {
                code26_2++;
            } else if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("3")) {
                code26_3++;
            } else if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("4")) {
                code26_4++;
            } else if (monthReport.getDay261() != null && monthReport.getDay261().equalsIgnoreCase("5")) {
                code26_5++;
            }

            if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("0")) {
                code27_0++;
            } else if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("1")) {
                code27_1++;
            } else if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("2")) {
                code27_2++;
            } else if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("3")) {
                code27_3++;
            } else if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("4")) {
                code27_4++;
            } else if (monthReport.getDay271() != null && monthReport.getDay271().equalsIgnoreCase("5")) {
                code27_5++;
            }

            if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("0")) {
                code28_0++;
            } else if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("1")) {
                code28_1++;
            } else if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("2")) {
                code28_2++;
            } else if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("3")) {
                code28_3++;
            } else if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("4")) {
                code28_4++;
            } else if (monthReport.getDay281() != null && monthReport.getDay281().equalsIgnoreCase("5")) {
                code28_5++;
            }

            if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("0")) {
                code29_0++;
            } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("1")) {
                code29_1++;
            } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("2")) {
                code29_2++;
            } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("3")) {
                code29_3++;
            } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("4")) {
                code29_4++;
            } else if (monthReport.getDay291() != null && monthReport.getDay291().equalsIgnoreCase("5")) {
                code29_5++;
            }

            if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("0")) {
                code30_0++;
            } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("1")) {
                code30_1++;
            } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("2")) {
                code30_2++;
            } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("3")) {
                code30_3++;
            } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("4")) {
                code30_4++;
            } else if (monthReport.getDay301() != null && monthReport.getDay301().equalsIgnoreCase("5")) {
                code30_5++;
            }

            if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("0")) {
                code31_0++;
            } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("1")) {
                code31_1++;
            } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("2")) {
                code31_2++;
            } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("3")) {
                code31_3++;
            } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("4")) {
                code31_4++;
            } else if (monthReport.getDay311() != null && monthReport.getDay311().equalsIgnoreCase("5")) {
                code31_5++;
            }

        }


        totalSummaryCode1.setDay01(code01_0 + code01_5);
        totalSummaryCode2.setDay01(code01_0 + code01_1 + code01_2);
        totalSummaryCode3.setDay01(code01_0 + code01_1 + code01_2);
        totalSummaryCode4.setDay01(code01_1);
        totalSummaryCode5.setDay01(code01_3 - code01_4);
        totalSummaryCdoe6.setDay01(code01_2);

        totalSummaryCode1.setDay02(code02_0 + code02_5);
        totalSummaryCode2.setDay02(code02_0 + code02_1 + code02_2);
        totalSummaryCode3.setDay02(code02_0 + code02_1 + code02_2);
        totalSummaryCode4.setDay02(code02_1);
        totalSummaryCode5.setDay02(code02_3 - code02_4);
        totalSummaryCdoe6.setDay02(code02_2);

        totalSummaryCode1.setDay03(code03_0 + code03_5);
        totalSummaryCode2.setDay03(code03_0 + code03_1 + code03_2);
        totalSummaryCode3.setDay03(code03_0 + code03_1 + code03_2);
        totalSummaryCode4.setDay03(code03_1);
        totalSummaryCode5.setDay03(code03_3 - code03_4);
        totalSummaryCdoe6.setDay03(code03_2);

        totalSummaryCode1.setDay04(code04_0 + code04_5);
        totalSummaryCode2.setDay04(code04_0 + code04_1 + code04_2);
        totalSummaryCode3.setDay04(code04_0 + code04_1 + code04_2);
        totalSummaryCode4.setDay04(code04_1);
        totalSummaryCode5.setDay04(code04_3 - code04_4);
        totalSummaryCdoe6.setDay04(code04_2);

        totalSummaryCode1.setDay05(code05_0 + code05_5);
        totalSummaryCode2.setDay05(code05_0 + code05_1 + code05_2);
        totalSummaryCode3.setDay05(code05_0 + code05_1 + code05_2);
        totalSummaryCode4.setDay05(code05_1);
        totalSummaryCode5.setDay05(code05_3 - code05_4);
        totalSummaryCdoe6.setDay05(code05_2);

        totalSummaryCode1.setDay06(code06_0 + code06_5);
        totalSummaryCode2.setDay06(code06_0 + code06_1 + code06_2);
        totalSummaryCode3.setDay06(code06_0 + code06_1 + code06_2);
        totalSummaryCode4.setDay06(code06_1);
        totalSummaryCode5.setDay06(code06_3 - code06_4);
        totalSummaryCdoe6.setDay06(code06_2);

        totalSummaryCode1.setDay07(code07_0 + code07_5);
        totalSummaryCode2.setDay07(code07_0 + code07_1 + code07_2);
        totalSummaryCode3.setDay07(code07_0 + code07_1 + code07_2);
        totalSummaryCode4.setDay07(code07_1);
        totalSummaryCode5.setDay07(code07_3 - code07_4);
        totalSummaryCdoe6.setDay07(code07_2);

        totalSummaryCode1.setDay08(code08_0 + code08_5);
        totalSummaryCode2.setDay08(code08_0 + code08_1 + code08_2);
        totalSummaryCode3.setDay08(code08_0 + code08_1 + code08_2);
        totalSummaryCode4.setDay08(code08_1);
        totalSummaryCode5.setDay08(code08_3 - code08_4);
        totalSummaryCdoe6.setDay08(code08_2);

        totalSummaryCode1.setDay09(code09_0 + code09_5);
        totalSummaryCode2.setDay09(code09_0 + code09_1 + code09_2);
        totalSummaryCode3.setDay09(code09_0 + code09_1 + code09_2);
        totalSummaryCode4.setDay09(code09_1);
        totalSummaryCode5.setDay09(code09_3 - code09_4);
        totalSummaryCdoe6.setDay09(code09_2);

        totalSummaryCode1.setDay10(code10_0 + code10_5);
        totalSummaryCode2.setDay10(code10_0 + code10_1 + code10_2);
        totalSummaryCode3.setDay10(code10_0 + code10_1 + code10_2);
        totalSummaryCode4.setDay10(code10_1);
        totalSummaryCode5.setDay10(code10_3 - code10_4);
        totalSummaryCdoe6.setDay10(code10_2);

        totalSummaryCode1.setDay11(code11_0 + code11_5);
        totalSummaryCode2.setDay11(code11_0 + code11_1 + code11_2);
        totalSummaryCode3.setDay11(code11_0 + code11_1 + code11_2);
        totalSummaryCode4.setDay11(code11_1);
        totalSummaryCode5.setDay11(code11_3 - code11_4);
        totalSummaryCdoe6.setDay11(code11_2);

        totalSummaryCode1.setDay12(code12_0 + code12_5);
        totalSummaryCode2.setDay12(code12_0 + code12_1 + code12_2);
        totalSummaryCode3.setDay12(code12_0 + code12_1 + code12_2);
        totalSummaryCode4.setDay12(code12_1);
        totalSummaryCode5.setDay12(code12_3 - code12_4);
        totalSummaryCdoe6.setDay12(code12_2);

        totalSummaryCode1.setDay13(code13_0 + code13_5);
        totalSummaryCode2.setDay13(code13_0 + code13_1 + code13_2);
        totalSummaryCode3.setDay13(code13_0 + code13_1 + code13_2);
        totalSummaryCode4.setDay13(code13_1);
        totalSummaryCode5.setDay13(code13_3 - code13_4);
        totalSummaryCdoe6.setDay13(code13_2);

        totalSummaryCode1.setDay14(code14_0 + code14_5);
        totalSummaryCode2.setDay14(code14_0 + code14_1 + code14_2);
        totalSummaryCode3.setDay14(code14_0 + code14_1 + code14_2);
        totalSummaryCode4.setDay14(code14_1);
        totalSummaryCode5.setDay14(code14_3 - code14_4);
        totalSummaryCdoe6.setDay14(code14_2);

        totalSummaryCode1.setDay15(code15_0 + code15_5);
        totalSummaryCode2.setDay15(code15_0 + code15_1 + code15_2);
        totalSummaryCode3.setDay15(code15_0 + code15_1 + code15_2);
        totalSummaryCode4.setDay15(code15_1);
        totalSummaryCode5.setDay15(code15_3 - code15_4);
        totalSummaryCdoe6.setDay15(code15_2);

        totalSummaryCode1.setDay16(code16_0 + code16_5);
        totalSummaryCode2.setDay16(code16_0 + code16_1 + code16_2);
        totalSummaryCode3.setDay16(code16_0 + code16_1 + code16_2);
        totalSummaryCode4.setDay16(code16_1);
        totalSummaryCode5.setDay16(code16_3 - code16_4);
        totalSummaryCdoe6.setDay16(code16_2);

        totalSummaryCode1.setDay17(code17_0 + code17_5);
        totalSummaryCode2.setDay17(code17_0 + code17_1 + code17_2);
        totalSummaryCode3.setDay17(code17_0 + code17_1 + code17_2);
        totalSummaryCode4.setDay17(code17_1);
        totalSummaryCode5.setDay17(code17_3 - code17_4);
        totalSummaryCdoe6.setDay17(code17_2);

        totalSummaryCode1.setDay18(code18_0 + code18_5);
        totalSummaryCode2.setDay18(code18_0 + code18_1 + code18_2);
        totalSummaryCode3.setDay18(code18_0 + code18_1 + code18_2);
        totalSummaryCode4.setDay18(code18_1);
        totalSummaryCode5.setDay18(code18_3 - code18_4);
        totalSummaryCdoe6.setDay18(code18_2);

        totalSummaryCode1.setDay19(code19_0 + code19_5);
        totalSummaryCode2.setDay19(code19_0 + code19_1 + code19_2);
        totalSummaryCode3.setDay19(code19_0 + code19_1 + code19_2);
        totalSummaryCode4.setDay19(code19_1);
        totalSummaryCode5.setDay19(code19_3 - code19_4);
        totalSummaryCdoe6.setDay19(code19_2);

        totalSummaryCode1.setDay20(code20_0 + code20_5);
        totalSummaryCode2.setDay20(code20_0 + code20_1 + code20_2);
        totalSummaryCode3.setDay20(code20_0 + code20_1 + code20_2);
        totalSummaryCode4.setDay20(code20_1);
        totalSummaryCode5.setDay20(code20_3 - code20_4);
        totalSummaryCdoe6.setDay20(code20_2);

        totalSummaryCode1.setDay21(code21_0 + code21_5);
        totalSummaryCode2.setDay21(code21_0 + code21_1 + code21_2);
        totalSummaryCode3.setDay21(code21_0 + code21_1 + code21_2);
        totalSummaryCode4.setDay21(code21_1);
        totalSummaryCode5.setDay21(code21_3 - code21_4);
        totalSummaryCdoe6.setDay21(code21_2);

        totalSummaryCode1.setDay22(code22_0 + code22_5);
        totalSummaryCode2.setDay22(code22_0 + code22_1 + code22_2);
        totalSummaryCode3.setDay22(code22_0 + code22_1 + code22_2);
        totalSummaryCode4.setDay22(code22_1);
        totalSummaryCode5.setDay22(code22_3 - code22_4);
        totalSummaryCdoe6.setDay22(code22_2);

        totalSummaryCode1.setDay23(code23_0 + code23_5);
        totalSummaryCode2.setDay23(code23_0 + code23_1 + code23_2);
        totalSummaryCode3.setDay23(code23_0 + code23_1 + code23_2);
        totalSummaryCode4.setDay23(code23_1);
        totalSummaryCode5.setDay23(code23_3 - code23_4);
        totalSummaryCdoe6.setDay23(code23_2);

        totalSummaryCode1.setDay24(code24_0 + code24_5);
        totalSummaryCode2.setDay24(code24_0 + code24_1 + code24_2);
        totalSummaryCode3.setDay24(code24_0 + code24_1 + code24_2);
        totalSummaryCode4.setDay24(code24_1);
        totalSummaryCode5.setDay24(code24_3 - code24_4);
        totalSummaryCdoe6.setDay24(code24_2);

        totalSummaryCode1.setDay25(code25_0 + code25_5);
        totalSummaryCode2.setDay25(code25_0 + code25_1 + code25_2);
        totalSummaryCode3.setDay25(code25_0 + code25_1 + code25_2);
        totalSummaryCode4.setDay25(code25_1);
        totalSummaryCode5.setDay25(code25_3 - code25_4);
        totalSummaryCdoe6.setDay25(code25_2);

        totalSummaryCode1.setDay26(code26_0 + code26_5);
        totalSummaryCode2.setDay26(code26_0 + code26_1 + code26_2);
        totalSummaryCode3.setDay26(code26_0 + code26_1 + code26_2);
        totalSummaryCode4.setDay26(code26_1);
        totalSummaryCode5.setDay26(code26_3 - code26_4);
        totalSummaryCdoe6.setDay26(code26_2);

        totalSummaryCode1.setDay27(code27_0 + code27_5);
        totalSummaryCode2.setDay27(code27_0 + code27_1 + code27_2);
        totalSummaryCode3.setDay27(code27_0 + code27_1 + code27_2);
        totalSummaryCode4.setDay27(code27_1);
        totalSummaryCode5.setDay27(code27_3 - code27_4);
        totalSummaryCdoe6.setDay27(code27_2);

        totalSummaryCode1.setDay28(code28_0 + code28_5);
        totalSummaryCode2.setDay28(code28_0 + code28_1 + code28_2);
        totalSummaryCode3.setDay28(code28_0 + code28_1 + code28_2);
        totalSummaryCode4.setDay28(code28_1);
        totalSummaryCode5.setDay28(code28_3 - code28_4);
        totalSummaryCdoe6.setDay28(code28_2);

        totalSummaryCode1.setDay29(code29_0 + code29_5);
        totalSummaryCode2.setDay29(code29_0 + code29_1 + code29_2);
        totalSummaryCode3.setDay29(code29_0 + code29_1 + code29_2);
        totalSummaryCode4.setDay29(code29_1);
        totalSummaryCode5.setDay29(code29_3 - code29_4);
        totalSummaryCdoe6.setDay29(code29_2);

        totalSummaryCode1.setDay30(code30_0 + code30_5);
        totalSummaryCode2.setDay30(code30_0 + code30_1 + code30_2);
        totalSummaryCode3.setDay30(code30_0 + code30_1 + code30_2);
        totalSummaryCode4.setDay30(code30_1);
        totalSummaryCode5.setDay30(code30_3 - code30_4);
        totalSummaryCdoe6.setDay30(code30_2);

        totalSummaryCode1.setDay31(code31_0 + code31_5);
        totalSummaryCode2.setDay31(code31_0 + code31_1 + code31_2);
        totalSummaryCode3.setDay31(code31_0 + code31_1 + code31_2);
        totalSummaryCode4.setDay31(code31_1);
        totalSummaryCode5.setDay31(code31_3 - code31_4);
        totalSummaryCdoe6.setDay31(code31_2);

//        totalSummaries
        totalSummaries.add(0, totalSummaryCode1);
        totalSummaries.add(1, totalSummaryCode2);
        totalSummaries.add(2, totalSummaryCode3);
        totalSummaries.add(3, totalSummaryCode4);
        totalSummaries.add(4, totalSummaryCode5);
        totalSummaries.add(5, totalSummaryCdoe6);
        return totalSummaries;

    }


    public Map<List<TotalSummary>, List<LookupSummary>> computeSummaryForMonthReportLookup(List<MonthReport> monthReportList) {
        List<LookupSummary> lookupSummaries;


        return null;

    }
}
