package com.hpe.msbireport.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.RunTimeByDate;
import com.hpe.msbireport.domain.ScheduleHistory;
import com.hpe.msbireport.mapper.BackupLogMapper;
import com.hpe.msbireport.mapper.MonthReportMapper;
import com.hpe.msbireport.mapper.ScheduleHistoryMapper;
import com.hpe.msbireport.service.MonthReportService;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 29/12/17
 * Descripthion: ...
 */
@Service
public class MonthReportServiceImpl implements MonthReportService {

    @Autowired
    MonthReportMapper monthReportMapper;
    
    @Autowired
    BackupLogMapper backupLogMapper;
    
    @Autowired
    ScheduleHistoryMapper scheduleHistoryMapper;
    
    private final static Map<String, Integer> PERUNITS = new HashMap<String, Integer>();
    private final static Map<String, Integer> Day = new HashMap<String, Integer>();
    private final static Map<String, Integer> Week = new HashMap<String, Integer>();
    
    @Override
    public List<MonthReport> selectAllMonthReportsByMonth(Integer monthIndicator) {
        return this.monthReportMapper.selectAllMonthReportsByMonth(monthIndicator);
    }
    
    @Override
    public boolean formatMonthReportTable(String startDate,String currentDate,boolean hasHistory,int insertSize) throws Exception{
    	boolean result = false;
    	PERUNITS.put("HOURS", 24);
		PERUNITS.put("DAYS", 1);
		PERUNITS.put("ONE TIME", 1);
		Day.put("Monday", 0);
		Day.put("Tuesday", 1);
		Day.put("Wednesday", 2);
		Day.put("Thursday", 3);
		Day.put("Friday", 4);
		Day.put("Saturday", 5);
		Day.put("Sunday", 6);
		Day.put("Mon", 0);
		Day.put("Tue", 1);
		Day.put("Wed", 2);
		Day.put("Thu", 3);
		Day.put("Fri", 4);
		Day.put("Sat", 5);
		Day.put("Sun", 6);
		
		//查询所有最新scheduleName数据
		List<MonthReport> list = monthReportMapper.selectAllForUpate();
		
		//历史记录 hasHistory为true ， 则查询历史
		Map<String,List<ScheduleHistory>> hisMap = new HashMap<String,List<ScheduleHistory>>();
		if(hasHistory){
			List<ScheduleHistory> hisList = scheduleHistoryMapper.selectByEnabled(1);
			List<ScheduleHistory> repeatHisList = new ArrayList<ScheduleHistory>();
			for (ScheduleHistory scheduleHistory : hisList) {
				if(hisMap.containsKey(scheduleHistory.getScheduleName())){
					repeatHisList.add(scheduleHistory);
					Collections.sort(repeatHisList, new Comparator<ScheduleHistory>() {
						
						@Override
						public int compare(ScheduleHistory o1, ScheduleHistory o2) {
							if(o1.getInsertDate().getTime() > o2.getInsertDate().getTime()){
								return 1;
							}
							if(o1.getInsertDate().getTime() == o2.getInsertDate().getTime()){
								return 0;
							}
							return -1;
						}
					});
					hisMap.put(scheduleHistory.getScheduleName(), repeatHisList);
				}else{
					repeatHisList = new ArrayList<ScheduleHistory>();
					repeatHisList.add(scheduleHistory);
					Collections.sort(repeatHisList, new Comparator<ScheduleHistory>() {
						
						@Override
						public int compare(ScheduleHistory o1, ScheduleHistory o2) {
							if(o1.getInsertDate().getTime() > o2.getInsertDate().getTime()){
								return 1;
							}
							if(o1.getInsertDate().getTime() == o2.getInsertDate().getTime()){
								return 0;
							}
							return -1;
						}
					});
					hisMap.put(scheduleHistory.getScheduleName(), repeatHisList);
				}
			}
		}
		
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if("" == currentDate || null == currentDate){
    		currentDate = sdf.format(new Date());
    	}
    	Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);//当前日期
    	if("" != startDate && null != startDate){
    		if(checkTime(startDate) && checkTime(currentDate)){
    			Date d1 = new SimpleDateFormat("yyyy-MM").parse(startDate);//定义起始日期
        		Date d2 = new SimpleDateFormat("yyyy-MM").parse(currentDate);//定义结束日期
        		Calendar dd = Calendar.getInstance();//定义日期实例
        		dd.setTime(d1);//设置日期起始时间
        		while(dd.getTime().before(d2)){//判断是否到结束日期
        			dd.add(Calendar.MONTH, 1);  
        			dd.set(Calendar.DAY_OF_MONTH, 0);
        			String str = sdf.format(dd.getTime());
        			//System.out.println(str);//输出日期结果
        			formatMonthReport(list,hisMap,str,insertSize,hasHistory);
        			dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
        		}
    		}
    	}
    	if(checkTime(currentDate)){
			formatMonthReport(list,hisMap,sdf.format(d3),insertSize,hasHistory);
			result = true;
		}
    	return result;
	}
    
    public void formatMonthReport(List<MonthReport> list,Map<String,List<ScheduleHistory>> hisMap,String currentDate,int insertSize,boolean hasHistory) throws Exception{
		//入参currentDate 格式：yyyy-mm-dd
		//String currentDate = "2017-04-27";
		String [] currentDates = currentDate.split("-");
		
		//删除当月记录
		monthReportMapper.deleteByMonth(Integer.parseInt(currentDates[0]+currentDates[1]));
		
		//查询backuplog表所有数据，用来写入monthreport表中的执行次数字段
		List<RunTimeByDate> blList = backupLogMapper.selectRunTimeByDate(currentDates[0]+"-"+currentDates[1]+"-1",currentDate);
		
		//格式化backuplog List为Map，key：scheduleName value:RunTimeByDate
		Map<String, List<RunTimeByDate>> blMap = new HashMap<String, List<RunTimeByDate>>();
		List<RunTimeByDate> repeatList = new ArrayList<RunTimeByDate>();
		for (RunTimeByDate runTimeByDate : blList) {
			if(blMap.containsKey(runTimeByDate.getSchedulename())){
				repeatList.add(runTimeByDate);
                blMap.put(runTimeByDate.getSchedulename(), repeatList);
            }else{
            	repeatList = new ArrayList<RunTimeByDate>();
            	repeatList.add(runTimeByDate);
            	blMap.put(runTimeByDate.getSchedulename(), repeatList);
            }
		}
		
		//便利monthreport List，设置此对象中day_0X_1,day_X_2的值
		for (MonthReport monthReport : list) {
			//保存年-月
			monthReport.setMonthIndicator(Integer.parseInt(currentDates[0]+currentDates[1]));
			
			//计算执行次数
			String perunits = monthReport.getPerunits();
			Integer period = monthReport.getPeriod();
			if(period <= 0){
				period = 1;
			}
			//执行次数
			Integer jobNums = 0;
			if(null == perunits || "".equals(perunits)){
				jobNums = 1;
			}else if(PERUNITS.get(perunits) != null){
				jobNums = PERUNITS.get(perunits)/period;
			}else{
				jobNums = 0;
			}
			//是否写入历史记录
			if(hasHistory && null != hisMap && hisMap.size() > 0){
				Map<Integer, MonthReport> hisSchedule = getHisSchedule(hisMap,monthReport,currentDate);
				//DateOfMonth有值，则根据此数值确定当前月份需要更新的天数
				if(Integer.parseInt(currentDates[2]) >= 1 && write(currentDate,1,hisSchedule.get(1))){monthReport.setDay011("1");monthReport.setDay012("0(0)/"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
				if(Integer.parseInt(currentDates[2]) >= 2 && write(currentDate,2,hisSchedule.get(2))){monthReport.setDay021("1");monthReport.setDay022("0(0)/"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
				if(Integer.parseInt(currentDates[2]) >= 3 && write(currentDate,3,hisSchedule.get(3))){monthReport.setDay031("1");monthReport.setDay032("0(0)/"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);}
				if(Integer.parseInt(currentDates[2]) >= 4 && write(currentDate,4,hisSchedule.get(4))){monthReport.setDay041("1");monthReport.setDay042("0(0)/"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);}
				if(Integer.parseInt(currentDates[2]) >= 5 && write(currentDate,5,hisSchedule.get(5))){monthReport.setDay051("1");monthReport.setDay052("0(0)/"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);}
				if(Integer.parseInt(currentDates[2]) >= 6 && write(currentDate,6,hisSchedule.get(6))){monthReport.setDay061("1");monthReport.setDay062("0(0)/"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);}
				if(Integer.parseInt(currentDates[2]) >= 7 && write(currentDate,7,hisSchedule.get(7))){monthReport.setDay071("1");monthReport.setDay072("0(0)/"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);}
				if(Integer.parseInt(currentDates[2]) >= 8 && write(currentDate,8,hisSchedule.get(8))){monthReport.setDay081("1");monthReport.setDay082("0(0)/"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);}
				if(Integer.parseInt(currentDates[2]) >= 9 && write(currentDate,9,hisSchedule.get(9))){monthReport.setDay091("1");monthReport.setDay092("0(0)/"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);}
				if(Integer.parseInt(currentDates[2]) >= 10 && write(currentDate,10,hisSchedule.get(10))){monthReport.setDay101("1");monthReport.setDay102("0(0)/"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);}
				if(Integer.parseInt(currentDates[2]) >= 11 && write(currentDate,11,hisSchedule.get(11))){monthReport.setDay111("1");monthReport.setDay112("0(0)/"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);}
				if(Integer.parseInt(currentDates[2]) >= 12 && write(currentDate,12,hisSchedule.get(12))){monthReport.setDay121("1");monthReport.setDay122("0(0)/"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);}
				if(Integer.parseInt(currentDates[2]) >= 13 && write(currentDate,13,hisSchedule.get(13))){monthReport.setDay131("1");monthReport.setDay132("0(0)/"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);}
				if(Integer.parseInt(currentDates[2]) >= 14 && write(currentDate,14,hisSchedule.get(14))){monthReport.setDay141("1");monthReport.setDay142("0(0)/"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);}
				if(Integer.parseInt(currentDates[2]) >= 15 && write(currentDate,15,hisSchedule.get(15))){monthReport.setDay151("1");monthReport.setDay152("0(0)/"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);}
				if(Integer.parseInt(currentDates[2]) >= 16 && write(currentDate,16,hisSchedule.get(16))){monthReport.setDay161("1");monthReport.setDay162("0(0)/"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);}
				if(Integer.parseInt(currentDates[2]) >= 17 && write(currentDate,17,hisSchedule.get(17))){monthReport.setDay171("1");monthReport.setDay172("0(0)/"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);}
				if(Integer.parseInt(currentDates[2]) >= 18 && write(currentDate,18,hisSchedule.get(18))){monthReport.setDay181("1");monthReport.setDay182("0(0)/"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);}
				if(Integer.parseInt(currentDates[2]) >= 19 && write(currentDate,19,hisSchedule.get(19))){monthReport.setDay191("1");monthReport.setDay192("0(0)/"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);}
				if(Integer.parseInt(currentDates[2]) >= 20 && write(currentDate,20,hisSchedule.get(20))){monthReport.setDay201("1");monthReport.setDay202("0(0)/"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);}
				if(Integer.parseInt(currentDates[2]) >= 21 && write(currentDate,21,hisSchedule.get(21))){monthReport.setDay211("1");monthReport.setDay212("0(0)/"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);}
				if(Integer.parseInt(currentDates[2]) >= 22 && write(currentDate,22,hisSchedule.get(22))){monthReport.setDay221("1");monthReport.setDay222("0(0)/"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);}
				if(Integer.parseInt(currentDates[2]) >= 23 && write(currentDate,23,hisSchedule.get(23))){monthReport.setDay231("1");monthReport.setDay232("0(0)/"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);}
				if(Integer.parseInt(currentDates[2]) >= 24 && write(currentDate,24,hisSchedule.get(24))){monthReport.setDay241("1");monthReport.setDay242("0(0)/"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);}
				if(Integer.parseInt(currentDates[2]) >= 25 && write(currentDate,25,hisSchedule.get(25))){monthReport.setDay251("1");monthReport.setDay252("0(0)/"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);}
				if(Integer.parseInt(currentDates[2]) >= 26 && write(currentDate,26,hisSchedule.get(26))){monthReport.setDay261("1");monthReport.setDay262("0(0)/"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);}
				if(Integer.parseInt(currentDates[2]) >= 27 && write(currentDate,27,hisSchedule.get(27))){monthReport.setDay271("1");monthReport.setDay272("0(0)/"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);}
				if(Integer.parseInt(currentDates[2]) >= 28 && write(currentDate,28,hisSchedule.get(28))){monthReport.setDay281("1");monthReport.setDay282("0(0)/"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);}
				if(Integer.parseInt(currentDates[2]) >= 29 && write(currentDate,29,hisSchedule.get(29))){monthReport.setDay291("1");monthReport.setDay292("0(0)/"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);}
				if(Integer.parseInt(currentDates[2]) >= 30 && write(currentDate,30,hisSchedule.get(30))){monthReport.setDay301("1");monthReport.setDay302("0(0)/"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);}
				if(Integer.parseInt(currentDates[2]) >= 31 && write(currentDate,31,hisSchedule.get(31))){monthReport.setDay311("1");monthReport.setDay312("0(0)/"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);}
			}else{
				if(write(currentDate,1,monthReport)){monthReport.setDay011("1");monthReport.setDay012("0(0)/"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
				if(write(currentDate,2,monthReport)){monthReport.setDay021("1");monthReport.setDay022("0(0)/"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
				if(write(currentDate,3,monthReport)){monthReport.setDay031("1");monthReport.setDay032("0(0)/"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);}
				if(write(currentDate,4,monthReport)){monthReport.setDay041("1");monthReport.setDay042("0(0)/"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);}
				if(write(currentDate,5,monthReport)){monthReport.setDay051("1");monthReport.setDay052("0(0)/"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);}
				if(write(currentDate,6,monthReport)){monthReport.setDay061("1");monthReport.setDay062("0(0)/"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);}
				if(write(currentDate,7,monthReport)){monthReport.setDay071("1");monthReport.setDay072("0(0)/"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);}
				if(write(currentDate,8,monthReport)){monthReport.setDay081("1");monthReport.setDay082("0(0)/"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);}
				if(write(currentDate,9,monthReport)){monthReport.setDay091("1");monthReport.setDay092("0(0)/"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);}
				if(write(currentDate,10,monthReport)){monthReport.setDay101("1");monthReport.setDay102("0(0)/"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);}
				if(write(currentDate,11,monthReport)){monthReport.setDay111("1");monthReport.setDay112("0(0)/"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);}
				if(write(currentDate,12,monthReport)){monthReport.setDay121("1");monthReport.setDay122("0(0)/"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);}
				if(write(currentDate,13,monthReport)){monthReport.setDay131("1");monthReport.setDay132("0(0)/"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);}
				if(write(currentDate,14,monthReport)){monthReport.setDay141("1");monthReport.setDay142("0(0)/"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);}
				if(write(currentDate,15,monthReport)){monthReport.setDay151("1");monthReport.setDay152("0(0)/"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);}
				if(write(currentDate,16,monthReport)){monthReport.setDay161("1");monthReport.setDay162("0(0)/"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);}
				if(write(currentDate,17,monthReport)){monthReport.setDay171("1");monthReport.setDay172("0(0)/"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);}
				if(write(currentDate,18,monthReport)){monthReport.setDay181("1");monthReport.setDay182("0(0)/"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);}
				if(write(currentDate,19,monthReport)){monthReport.setDay191("1");monthReport.setDay192("0(0)/"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);}
				if(write(currentDate,20,monthReport)){monthReport.setDay201("1");monthReport.setDay202("0(0)/"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);}
				if(write(currentDate,21,monthReport)){monthReport.setDay211("1");monthReport.setDay212("0(0)/"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);}
				if(write(currentDate,22,monthReport)){monthReport.setDay221("1");monthReport.setDay222("0(0)/"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);}
				if(write(currentDate,23,monthReport)){monthReport.setDay231("1");monthReport.setDay232("0(0)/"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);}
				if(write(currentDate,24,monthReport)){monthReport.setDay241("1");monthReport.setDay242("0(0)/"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);}
				if(write(currentDate,25,monthReport)){monthReport.setDay251("1");monthReport.setDay252("0(0)/"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);}
				if(write(currentDate,26,monthReport)){monthReport.setDay261("1");monthReport.setDay262("0(0)/"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);}
				if(write(currentDate,27,monthReport)){monthReport.setDay271("1");monthReport.setDay272("0(0)/"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);}
				if(write(currentDate,28,monthReport)){monthReport.setDay281("1");monthReport.setDay282("0(0)/"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);}
				if(write(currentDate,29,monthReport)){monthReport.setDay291("1");monthReport.setDay292("0(0)/"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);}
				if(write(currentDate,30,monthReport)){monthReport.setDay301("1");monthReport.setDay302("0(0)/"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);}
				if(write(currentDate,31,monthReport)){monthReport.setDay311("1");monthReport.setDay312("0(0)/"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);}
			}
		}
		//计算backuplog表中的真实log记录数,并更新monthreport对象
		List<MonthReport> sunList = sumBackLog(list,blMap);
		//批量插入
		monthReportInsert(sunList,insertSize);
    }
    
    /**
     * 计算backuplog表中的真实log记录数,并更新monthreport对象
     * @param monthReports monthreport集合
     * @param blMap backuplog日志表记录，Map：key  scheduleName，value  RunTimeByDate对象
     * @return 更新手的MonthReport集合
     */
    public List<MonthReport> sumBackLog(List<MonthReport> monthReports,Map<String, List<RunTimeByDate>> blMap){
    	if(null != monthReports && monthReports.size() > 0){
    		for (MonthReport monthReport : monthReports) {
    			List<RunTimeByDate> runTimeByDates = blMap.get(monthReport.getScheduleName());
    			if(null != runTimeByDates && runTimeByDates.size() > 0){
    				for (RunTimeByDate runTimeByDate : runTimeByDates) {
						if(runTimeByDate.getStartdate().equals("1")){ if(null != monthReport.getDay012() && "" != monthReport.getDay012()){ int a = monthReport.getDay012().indexOf("("); String l = monthReport.getDay012().substring(a, monthReport.getDay012().length());monthReport.setDay012(runTimeByDate.getRunnum()+l);}else{monthReport.setDay012(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("2")){ if(null != monthReport.getDay022() && "" != monthReport.getDay022()){ int a = monthReport.getDay022().indexOf("("); String l = monthReport.getDay022().substring(a, monthReport.getDay022().length());monthReport.setDay022(runTimeByDate.getRunnum()+l);}else{monthReport.setDay022(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("3")){ if(null != monthReport.getDay032() && "" != monthReport.getDay032()){ int a = monthReport.getDay032().indexOf("("); String l = monthReport.getDay032().substring(a, monthReport.getDay032().length());monthReport.setDay032(runTimeByDate.getRunnum()+l);}else{monthReport.setDay032(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("4")){ if(null != monthReport.getDay042() && "" != monthReport.getDay042()){ int a = monthReport.getDay042().indexOf("("); String l = monthReport.getDay042().substring(a, monthReport.getDay042().length());monthReport.setDay042(runTimeByDate.getRunnum()+l);}else{monthReport.setDay042(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("5")){ if(null != monthReport.getDay052() && "" != monthReport.getDay052()){ int a = monthReport.getDay052().indexOf("("); String l = monthReport.getDay052().substring(a, monthReport.getDay052().length());monthReport.setDay052(runTimeByDate.getRunnum()+l);}else{monthReport.setDay052(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("6")){ if(null != monthReport.getDay062() && "" != monthReport.getDay062()){ int a = monthReport.getDay062().indexOf("("); String l = monthReport.getDay062().substring(a, monthReport.getDay062().length());monthReport.setDay062(runTimeByDate.getRunnum()+l);}else{monthReport.setDay062(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("7")){ if(null != monthReport.getDay072() && "" != monthReport.getDay072()){ int a = monthReport.getDay072().indexOf("("); String l = monthReport.getDay072().substring(a, monthReport.getDay072().length());monthReport.setDay072(runTimeByDate.getRunnum()+l);}else{monthReport.setDay072(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("8")){ if(null != monthReport.getDay082() && "" != monthReport.getDay082()){ int a = monthReport.getDay082().indexOf("("); String l = monthReport.getDay082().substring(a, monthReport.getDay082().length());monthReport.setDay082(runTimeByDate.getRunnum()+l);}else{monthReport.setDay082(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("9")){ if(null != monthReport.getDay092() && "" != monthReport.getDay092()){ int a = monthReport.getDay092().indexOf("("); String l = monthReport.getDay092().substring(a, monthReport.getDay092().length());monthReport.setDay092(runTimeByDate.getRunnum()+l);}else{monthReport.setDay092(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("10")){ if(null != monthReport.getDay102() && "" != monthReport.getDay102()){ int a = monthReport.getDay102().indexOf("("); String l = monthReport.getDay102().substring(a, monthReport.getDay102().length());monthReport.setDay102(runTimeByDate.getRunnum()+l);}else{monthReport.setDay102(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("11")){ if(null != monthReport.getDay112() && "" != monthReport.getDay112()){ int a = monthReport.getDay112().indexOf("("); String l = monthReport.getDay112().substring(a, monthReport.getDay112().length());monthReport.setDay112(runTimeByDate.getRunnum()+l);}else{monthReport.setDay112(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("12")){ if(null != monthReport.getDay122() && "" != monthReport.getDay122()){ int a = monthReport.getDay122().indexOf("("); String l = monthReport.getDay122().substring(a, monthReport.getDay122().length());monthReport.setDay122(runTimeByDate.getRunnum()+l);}else{monthReport.setDay122(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("13")){ if(null != monthReport.getDay132() && "" != monthReport.getDay132()){ int a = monthReport.getDay132().indexOf("("); String l = monthReport.getDay132().substring(a, monthReport.getDay132().length());monthReport.setDay132(runTimeByDate.getRunnum()+l);}else{monthReport.setDay132(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("14")){ if(null != monthReport.getDay142() && "" != monthReport.getDay142()){ int a = monthReport.getDay142().indexOf("("); String l = monthReport.getDay142().substring(a, monthReport.getDay142().length());monthReport.setDay142(runTimeByDate.getRunnum()+l);}else{monthReport.setDay142(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("15")){ if(null != monthReport.getDay152() && "" != monthReport.getDay152()){ int a = monthReport.getDay152().indexOf("("); String l = monthReport.getDay152().substring(a, monthReport.getDay152().length());monthReport.setDay152(runTimeByDate.getRunnum()+l);}else{monthReport.setDay152(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("16")){ if(null != monthReport.getDay162() && "" != monthReport.getDay162()){ int a = monthReport.getDay162().indexOf("("); String l = monthReport.getDay162().substring(a, monthReport.getDay162().length());monthReport.setDay162(runTimeByDate.getRunnum()+l);}else{monthReport.setDay162(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("17")){ if(null != monthReport.getDay172() && "" != monthReport.getDay172()){ int a = monthReport.getDay172().indexOf("("); String l = monthReport.getDay172().substring(a, monthReport.getDay172().length());monthReport.setDay172(runTimeByDate.getRunnum()+l);}else{monthReport.setDay172(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("18")){ if(null != monthReport.getDay182() && "" != monthReport.getDay182()){ int a = monthReport.getDay182().indexOf("("); String l = monthReport.getDay182().substring(a, monthReport.getDay182().length());monthReport.setDay182(runTimeByDate.getRunnum()+l);}else{monthReport.setDay182(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("19")){ if(null != monthReport.getDay192() && "" != monthReport.getDay192()){ int a = monthReport.getDay192().indexOf("("); String l = monthReport.getDay192().substring(a, monthReport.getDay192().length());monthReport.setDay192(runTimeByDate.getRunnum()+l);}else{monthReport.setDay192(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("20")){ if(null != monthReport.getDay202() && "" != monthReport.getDay202()){ int a = monthReport.getDay202().indexOf("("); String l = monthReport.getDay202().substring(a, monthReport.getDay202().length());monthReport.setDay202(runTimeByDate.getRunnum()+l);}else{monthReport.setDay202(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("21")){ if(null != monthReport.getDay212() && "" != monthReport.getDay212()){ int a = monthReport.getDay212().indexOf("("); String l = monthReport.getDay212().substring(a, monthReport.getDay212().length());monthReport.setDay212(runTimeByDate.getRunnum()+l);}else{monthReport.setDay212(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("22")){ if(null != monthReport.getDay222() && "" != monthReport.getDay222()){ int a = monthReport.getDay222().indexOf("("); String l = monthReport.getDay222().substring(a, monthReport.getDay222().length());monthReport.setDay222(runTimeByDate.getRunnum()+l);}else{monthReport.setDay222(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("23")){ if(null != monthReport.getDay232() && "" != monthReport.getDay232()){ int a = monthReport.getDay232().indexOf("("); String l = monthReport.getDay232().substring(a, monthReport.getDay232().length());monthReport.setDay232(runTimeByDate.getRunnum()+l);}else{monthReport.setDay232(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("24")){ if(null != monthReport.getDay242() && "" != monthReport.getDay242()){ int a = monthReport.getDay242().indexOf("("); String l = monthReport.getDay242().substring(a, monthReport.getDay242().length());monthReport.setDay242(runTimeByDate.getRunnum()+l);}else{monthReport.setDay242(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("25")){ if(null != monthReport.getDay252() && "" != monthReport.getDay252()){ int a = monthReport.getDay252().indexOf("("); String l = monthReport.getDay252().substring(a, monthReport.getDay252().length());monthReport.setDay252(runTimeByDate.getRunnum()+l);}else{monthReport.setDay252(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("26")){ if(null != monthReport.getDay262() && "" != monthReport.getDay262()){ int a = monthReport.getDay262().indexOf("("); String l = monthReport.getDay262().substring(a, monthReport.getDay262().length());monthReport.setDay262(runTimeByDate.getRunnum()+l);}else{monthReport.setDay262(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("27")){ if(null != monthReport.getDay272() && "" != monthReport.getDay272()){ int a = monthReport.getDay272().indexOf("("); String l = monthReport.getDay272().substring(a, monthReport.getDay272().length());monthReport.setDay272(runTimeByDate.getRunnum()+l);}else{monthReport.setDay272(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("28")){ if(null != monthReport.getDay282() && "" != monthReport.getDay282()){ int a = monthReport.getDay282().indexOf("("); String l = monthReport.getDay282().substring(a, monthReport.getDay282().length());monthReport.setDay282(runTimeByDate.getRunnum()+l);}else{monthReport.setDay282(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("29")){ if(null != monthReport.getDay292() && "" != monthReport.getDay292()){ int a = monthReport.getDay292().indexOf("("); String l = monthReport.getDay292().substring(a, monthReport.getDay292().length());monthReport.setDay292(runTimeByDate.getRunnum()+l);}else{monthReport.setDay292(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("30")){ if(null != monthReport.getDay302() && "" != monthReport.getDay302()){ int a = monthReport.getDay302().indexOf("("); String l = monthReport.getDay302().substring(a, monthReport.getDay302().length());monthReport.setDay302(runTimeByDate.getRunnum()+l);}else{monthReport.setDay302(runTimeByDate.getRunnum()+"(0)/0");}}
						if(runTimeByDate.getStartdate().equals("31")){ if(null != monthReport.getDay312() && "" != monthReport.getDay312()){ int a = monthReport.getDay312().indexOf("("); String l = monthReport.getDay312().substring(a, monthReport.getDay312().length());monthReport.setDay312(runTimeByDate.getRunnum()+l);}else{monthReport.setDay312(runTimeByDate.getRunnum()+"(0)/0");}}
    				}
    			}
    			
    			//更新day_01_X值，当day_02_X(如：0(1)/2)例子中的第一个值为0时，更新day_01_X为:0
    			if(null != monthReport.getDay012() && !"".equals(monthReport.getDay012())){ int a = monthReport.getDay012().indexOf("(");int b = monthReport.getDay012().indexOf("/"); if(Integer.parseInt(monthReport.getDay012().substring(0, a)) < Integer.parseInt(monthReport.getDay012().substring(b+1, monthReport.getDay012().length()))){monthReport.setDay011("0");}}
    			if(null != monthReport.getDay022() && !"".equals(monthReport.getDay022())){ int a = monthReport.getDay022().indexOf("(");int b = monthReport.getDay022().indexOf("/"); if(Integer.parseInt(monthReport.getDay022().substring(0, a)) < Integer.parseInt(monthReport.getDay022().substring(b+1, monthReport.getDay022().length()))){monthReport.setDay021("0");}}
    			if(null != monthReport.getDay032() && !"".equals(monthReport.getDay032())){ int a = monthReport.getDay032().indexOf("(");int b = monthReport.getDay032().indexOf("/"); if(Integer.parseInt(monthReport.getDay032().substring(0, a)) < Integer.parseInt(monthReport.getDay032().substring(b+1, monthReport.getDay032().length()))){monthReport.setDay031("0");}}
    			if(null != monthReport.getDay042() && !"".equals(monthReport.getDay042())){ int a = monthReport.getDay042().indexOf("(");int b = monthReport.getDay042().indexOf("/"); if(Integer.parseInt(monthReport.getDay042().substring(0, a)) < Integer.parseInt(monthReport.getDay042().substring(b+1, monthReport.getDay042().length()))){monthReport.setDay041("0");}}
    			if(null != monthReport.getDay052() && !"".equals(monthReport.getDay052())){ int a = monthReport.getDay052().indexOf("(");int b = monthReport.getDay052().indexOf("/"); if(Integer.parseInt(monthReport.getDay052().substring(0, a)) < Integer.parseInt(monthReport.getDay052().substring(b+1, monthReport.getDay052().length()))){monthReport.setDay051("0");}}
    			if(null != monthReport.getDay062() && !"".equals(monthReport.getDay062())){ int a = monthReport.getDay062().indexOf("(");int b = monthReport.getDay062().indexOf("/"); if(Integer.parseInt(monthReport.getDay062().substring(0, a)) < Integer.parseInt(monthReport.getDay062().substring(b+1, monthReport.getDay062().length()))){monthReport.setDay061("0");}}
    			if(null != monthReport.getDay072() && !"".equals(monthReport.getDay072())){ int a = monthReport.getDay072().indexOf("(");int b = monthReport.getDay072().indexOf("/"); if(Integer.parseInt(monthReport.getDay072().substring(0, a)) < Integer.parseInt(monthReport.getDay072().substring(b+1, monthReport.getDay072().length()))){monthReport.setDay071("0");}}
    			if(null != monthReport.getDay082() && !"".equals(monthReport.getDay082())){ int a = monthReport.getDay082().indexOf("(");int b = monthReport.getDay082().indexOf("/"); if(Integer.parseInt(monthReport.getDay082().substring(0, a)) < Integer.parseInt(monthReport.getDay082().substring(b+1, monthReport.getDay082().length()))){monthReport.setDay081("0");}}
    			if(null != monthReport.getDay092() && !"".equals(monthReport.getDay092())){ int a = monthReport.getDay092().indexOf("(");int b = monthReport.getDay092().indexOf("/"); if(Integer.parseInt(monthReport.getDay092().substring(0, a)) < Integer.parseInt(monthReport.getDay092().substring(b+1, monthReport.getDay092().length()))){monthReport.setDay091("0");}}
    			if(null != monthReport.getDay102() && !"".equals(monthReport.getDay102())){ int a = monthReport.getDay102().indexOf("(");int b = monthReport.getDay102().indexOf("/"); if(Integer.parseInt(monthReport.getDay102().substring(0, a)) < Integer.parseInt(monthReport.getDay102().substring(b+1, monthReport.getDay102().length()))){monthReport.setDay101("0");}}
    			if(null != monthReport.getDay112() && !"".equals(monthReport.getDay112())){ int a = monthReport.getDay112().indexOf("(");int b = monthReport.getDay112().indexOf("/"); if(Integer.parseInt(monthReport.getDay112().substring(0, a)) < Integer.parseInt(monthReport.getDay112().substring(b+1, monthReport.getDay112().length()))){monthReport.setDay111("0");}}
    			if(null != monthReport.getDay122() && !"".equals(monthReport.getDay122())){ int a = monthReport.getDay122().indexOf("(");int b = monthReport.getDay122().indexOf("/"); if(Integer.parseInt(monthReport.getDay122().substring(0, a)) < Integer.parseInt(monthReport.getDay122().substring(b+1, monthReport.getDay122().length()))){monthReport.setDay121("0");}}
    			if(null != monthReport.getDay132() && !"".equals(monthReport.getDay132())){ int a = monthReport.getDay132().indexOf("(");int b = monthReport.getDay132().indexOf("/"); if(Integer.parseInt(monthReport.getDay132().substring(0, a)) < Integer.parseInt(monthReport.getDay132().substring(b+1, monthReport.getDay132().length()))){monthReport.setDay131("0");}}
    			if(null != monthReport.getDay142() && !"".equals(monthReport.getDay142())){ int a = monthReport.getDay142().indexOf("(");int b = monthReport.getDay142().indexOf("/"); if(Integer.parseInt(monthReport.getDay142().substring(0, a)) < Integer.parseInt(monthReport.getDay142().substring(b+1, monthReport.getDay142().length()))){monthReport.setDay141("0");}}
    			if(null != monthReport.getDay152() && !"".equals(monthReport.getDay152())){ int a = monthReport.getDay152().indexOf("(");int b = monthReport.getDay152().indexOf("/"); if(Integer.parseInt(monthReport.getDay152().substring(0, a)) < Integer.parseInt(monthReport.getDay152().substring(b+1, monthReport.getDay152().length()))){monthReport.setDay151("0");}}
    			if(null != monthReport.getDay162() && !"".equals(monthReport.getDay162())){ int a = monthReport.getDay162().indexOf("(");int b = monthReport.getDay162().indexOf("/"); if(Integer.parseInt(monthReport.getDay162().substring(0, a)) < Integer.parseInt(monthReport.getDay162().substring(b+1, monthReport.getDay162().length()))){monthReport.setDay161("0");}}
    			if(null != monthReport.getDay172() && !"".equals(monthReport.getDay172())){ int a = monthReport.getDay172().indexOf("(");int b = monthReport.getDay172().indexOf("/"); if(Integer.parseInt(monthReport.getDay172().substring(0, a)) < Integer.parseInt(monthReport.getDay172().substring(b+1, monthReport.getDay172().length()))){monthReport.setDay171("0");}}
    			if(null != monthReport.getDay182() && !"".equals(monthReport.getDay182())){ int a = monthReport.getDay182().indexOf("(");int b = monthReport.getDay182().indexOf("/"); if(Integer.parseInt(monthReport.getDay182().substring(0, a)) < Integer.parseInt(monthReport.getDay182().substring(b+1, monthReport.getDay182().length()))){monthReport.setDay181("0");}}
    			if(null != monthReport.getDay192() && !"".equals(monthReport.getDay192())){ int a = monthReport.getDay192().indexOf("(");int b = monthReport.getDay192().indexOf("/"); if(Integer.parseInt(monthReport.getDay192().substring(0, a)) < Integer.parseInt(monthReport.getDay192().substring(b+1, monthReport.getDay192().length()))){monthReport.setDay191("0");}}
    			if(null != monthReport.getDay202() && !"".equals(monthReport.getDay202())){ int a = monthReport.getDay202().indexOf("(");int b = monthReport.getDay202().indexOf("/"); if(Integer.parseInt(monthReport.getDay202().substring(0, a)) < Integer.parseInt(monthReport.getDay202().substring(b+1, monthReport.getDay202().length()))){monthReport.setDay201("0");}}
    			if(null != monthReport.getDay212() && !"".equals(monthReport.getDay212())){ int a = monthReport.getDay212().indexOf("(");int b = monthReport.getDay212().indexOf("/"); if(Integer.parseInt(monthReport.getDay212().substring(0, a)) < Integer.parseInt(monthReport.getDay212().substring(b+1, monthReport.getDay212().length()))){monthReport.setDay211("0");}}
    			if(null != monthReport.getDay222() && !"".equals(monthReport.getDay222())){ int a = monthReport.getDay222().indexOf("(");int b = monthReport.getDay222().indexOf("/"); if(Integer.parseInt(monthReport.getDay222().substring(0, a)) < Integer.parseInt(monthReport.getDay222().substring(b+1, monthReport.getDay222().length()))){monthReport.setDay221("0");}}
    			if(null != monthReport.getDay232() && !"".equals(monthReport.getDay232())){ int a = monthReport.getDay232().indexOf("(");int b = monthReport.getDay232().indexOf("/"); if(Integer.parseInt(monthReport.getDay232().substring(0, a)) < Integer.parseInt(monthReport.getDay232().substring(b+1, monthReport.getDay232().length()))){monthReport.setDay231("0");}}
    			if(null != monthReport.getDay242() && !"".equals(monthReport.getDay242())){ int a = monthReport.getDay242().indexOf("(");int b = monthReport.getDay242().indexOf("/"); if(Integer.parseInt(monthReport.getDay242().substring(0, a)) < Integer.parseInt(monthReport.getDay242().substring(b+1, monthReport.getDay242().length()))){monthReport.setDay241("0");}}
    			if(null != monthReport.getDay252() && !"".equals(monthReport.getDay252())){ int a = monthReport.getDay252().indexOf("(");int b = monthReport.getDay252().indexOf("/"); if(Integer.parseInt(monthReport.getDay252().substring(0, a)) < Integer.parseInt(monthReport.getDay252().substring(b+1, monthReport.getDay252().length()))){monthReport.setDay251("0");}}
    			if(null != monthReport.getDay262() && !"".equals(monthReport.getDay262())){ int a = monthReport.getDay262().indexOf("(");int b = monthReport.getDay262().indexOf("/"); if(Integer.parseInt(monthReport.getDay262().substring(0, a)) < Integer.parseInt(monthReport.getDay262().substring(b+1, monthReport.getDay262().length()))){monthReport.setDay261("0");}}
    			if(null != monthReport.getDay272() && !"".equals(monthReport.getDay272())){ int a = monthReport.getDay272().indexOf("(");int b = monthReport.getDay272().indexOf("/"); if(Integer.parseInt(monthReport.getDay272().substring(0, a)) < Integer.parseInt(monthReport.getDay272().substring(b+1, monthReport.getDay272().length()))){monthReport.setDay271("0");}}
    			if(null != monthReport.getDay282() && !"".equals(monthReport.getDay282())){ int a = monthReport.getDay282().indexOf("(");int b = monthReport.getDay282().indexOf("/"); if(Integer.parseInt(monthReport.getDay282().substring(0, a)) < Integer.parseInt(monthReport.getDay282().substring(b+1, monthReport.getDay282().length()))){monthReport.setDay281("0");}}
    			if(null != monthReport.getDay292() && !"".equals(monthReport.getDay292())){ int a = monthReport.getDay292().indexOf("(");int b = monthReport.getDay292().indexOf("/"); if(Integer.parseInt(monthReport.getDay292().substring(0, a)) < Integer.parseInt(monthReport.getDay292().substring(b+1, monthReport.getDay292().length()))){monthReport.setDay291("0");}}
    			if(null != monthReport.getDay302() && !"".equals(monthReport.getDay302())){ int a = monthReport.getDay302().indexOf("(");int b = monthReport.getDay302().indexOf("/"); if(Integer.parseInt(monthReport.getDay302().substring(0, a)) < Integer.parseInt(monthReport.getDay302().substring(b+1, monthReport.getDay302().length()))){monthReport.setDay301("0");}}
    			if(null != monthReport.getDay312() && !"".equals(monthReport.getDay312())){ int a = monthReport.getDay312().indexOf("(");int b = monthReport.getDay312().indexOf("/"); if(Integer.parseInt(monthReport.getDay312().substring(0, a)) < Integer.parseInt(monthReport.getDay312().substring(b+1, monthReport.getDay312().length()))){monthReport.setDay311("0");}}
			}
    	}
    	return monthReports;
    }
    
    /**
     * 工具方法-批量写入
     * @param monthReports monthreport集合
     * @param size 大小
     */
    public void monthReportInsert(List<MonthReport> monthReports,int size){
    	int sign = 0;
    	List<MonthReport> list = new ArrayList<MonthReport>();
    	//插入前计算:totalSuccessful总成功，totalSchedule总记录数，bsr成功率   三个属性的值
    	if(null != monthReports && monthReports.size() > 0){
    		for (MonthReport monthReport : monthReports) {
        		int totalSuccessful = formatNums(monthReport.getDay012(),0) +
        				formatNums(monthReport.getDay022(),0) +
        				formatNums(monthReport.getDay032(),0) +
        				formatNums(monthReport.getDay042(),0) +
        				formatNums(monthReport.getDay052(),0) +
        				formatNums(monthReport.getDay062(),0) +
        				formatNums(monthReport.getDay072(),0) +
        				formatNums(monthReport.getDay082(),0) +
        				formatNums(monthReport.getDay092(),0) +
        				formatNums(monthReport.getDay102(),0) +
        				formatNums(monthReport.getDay112(),0) +
        				formatNums(monthReport.getDay122(),0) +
        				formatNums(monthReport.getDay132(),0) +
        				formatNums(monthReport.getDay142(),0) +
        				formatNums(monthReport.getDay152(),0) +
        				formatNums(monthReport.getDay162(),0) +
        				formatNums(monthReport.getDay172(),0) +
        				formatNums(monthReport.getDay182(),0) +
        				formatNums(monthReport.getDay192(),0) +
        				formatNums(monthReport.getDay202(),0) +
        				formatNums(monthReport.getDay212(),0) +
        				formatNums(monthReport.getDay222(),0) +
        				formatNums(monthReport.getDay232(),0) +
        				formatNums(monthReport.getDay242(),0) +
        				formatNums(monthReport.getDay252(),0) +
        				formatNums(monthReport.getDay262(),0) +
        				formatNums(monthReport.getDay272(),0) +
        				formatNums(monthReport.getDay282(),0) +
        				formatNums(monthReport.getDay292(),0) +
        				formatNums(monthReport.getDay302(),0) +
        				formatNums(monthReport.getDay312(),0);
        		monthReport.setTotalSuccessful(String.valueOf(totalSuccessful));
        		
        		int totalSchedule = formatNums(monthReport.getDay012(),2) +
        				formatNums(monthReport.getDay022(),2) +
        				formatNums(monthReport.getDay032(),2) +
        				formatNums(monthReport.getDay042(),2) +
        				formatNums(monthReport.getDay052(),2) +
        				formatNums(monthReport.getDay062(),2) +
        				formatNums(monthReport.getDay072(),2) +
        				formatNums(monthReport.getDay082(),2) +
        				formatNums(monthReport.getDay092(),2) +
        				formatNums(monthReport.getDay102(),2) +
        				formatNums(monthReport.getDay112(),2) +
        				formatNums(monthReport.getDay122(),2) +
        				formatNums(monthReport.getDay132(),2) +
        				formatNums(monthReport.getDay142(),2) +
        				formatNums(monthReport.getDay152(),2) +
        				formatNums(monthReport.getDay162(),2) +
        				formatNums(monthReport.getDay172(),2) +
        				formatNums(monthReport.getDay182(),2) +
        				formatNums(monthReport.getDay192(),2) +
        				formatNums(monthReport.getDay202(),2) +
        				formatNums(monthReport.getDay212(),2) +
        				formatNums(monthReport.getDay222(),2) +
        				formatNums(monthReport.getDay232(),2) +
        				formatNums(monthReport.getDay242(),2) +
        				formatNums(monthReport.getDay252(),2) +
        				formatNums(monthReport.getDay262(),2) +
        				formatNums(monthReport.getDay272(),2) +
        				formatNums(monthReport.getDay282(),2) +
        				formatNums(monthReport.getDay292(),2) +
        				formatNums(monthReport.getDay302(),2) +
        				formatNums(monthReport.getDay312(),2);
        		monthReport.setTotalSchedule(String.valueOf(totalSchedule));
        		DecimalFormat df=new DecimalFormat("0.00");
        		String bsr = "";
        		if(totalSchedule <= 0){
        			bsr = String.valueOf(df.format(((float)totalSuccessful/1)*100));
        		}else{
        			bsr = String.valueOf(df.format(((float)totalSuccessful/totalSchedule)*100));
        		}
        		monthReport.setBsr(bsr);
        		list.add(sign, monthReport);
        		sign++;
        	}
    	}
    	
    	//根据入参size，批量插入
    	if(list!=null&&list.size()>0){
    		if(size == 0){
    			monthReportMapper.insertBatch(list);
    		}else{
    			int page = (list.size() + size - 1)/size;
                List<MonthReport> newtimelist=null;
                for(int i = 0;i < page;i++) {
    				newtimelist=new ArrayList<MonthReport>();
    				if(i==page-1){
    				    newtimelist=list.subList(i*size, list.size());
    				}else {
    				    newtimelist=list.subList(i*size, i*size+size);
    				}
    				monthReportMapper.insertBatch(newtimelist);
                }
    		}
        }
    }
    
    /**
     * 根据历史表中的schedule对象，更新当前monthreport对象
     * @param hisMap 历史schedule记录，key：scheduleName  value：List<ScheduleHistory>
     * @param monthReport 当前mongthreport对象，根据历史记录表更新
     * @param currentDate 前期日期
     * @return Map<Integer, MonthReport> key:每月天数    value：当前天对应的MonthReport对象
     */
    public static Map<Integer, MonthReport> getHisSchedule(Map<String,List<ScheduleHistory>> hisMap,MonthReport monthReport,String currentDate) throws Exception{
    	//获得历史记录
		List<ScheduleHistory> scheduleHistorys = hisMap.get(monthReport.getScheduleName());
		Map<Integer, MonthReport> map = new HashMap<Integer, MonthReport>();
		String [] currnetDateS = currentDate.split("-");
		//如果当前schedule有历史记录，则拼装key：1，value：monthreport；key：2，value：monthreport；key：3，value：monthreport...，此Map类型的整个月份的monthreport  Map对象。
		if(null != scheduleHistorys ){
			List<Date> hisDate = new ArrayList<Date>();
			Date cHisDate = null;
			//当前日期
			Date cDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
			//先取当月日期，在取小于当月日期
			if(null != scheduleHistorys && scheduleHistorys.size() > 0){
				for (ScheduleHistory scheduleHistory : scheduleHistorys) {
					if(cDate.getTime() > scheduleHistory.getInsertDate().getTime()){
						hisDate.add(scheduleHistory.getInsertDate());
					}
				}
				
				for (ScheduleHistory scheduleHistory : scheduleHistorys) {
					if(cDate.getTime() <= scheduleHistory.getInsertDate().getTime()){
						cHisDate = scheduleHistory.getInsertDate();
						break;
					}
				}
			}
			
			Date cDates = new SimpleDateFormat("yyyy-MM-dd").parse(currnetDateS[0]+"-"+currnetDateS[1]+"-"+"1");
			
			List<Date> newDates = new ArrayList<Date>();
			if(hisDate.size() > 0){
				Collections.reverse(hisDate);
				for (int i = 0; i < hisDate.size(); i++) {
					newDates.add(i, hisDate.get(i));
					if(cDates.getTime() >= hisDate.get(i).getTime()){
						break;
					}
				}
				Collections.reverse(newDates);
			}
			
			//如cHisDate为null ， 表示当前月份的当前日至newDates 中最后一个日期中的    scheled 为newset表中的数据
			if(null != cHisDate){
				newDates.add(cHisDate);
			}
			
			//除去list中第一个history值
			if(newDates.size() > 1){
				Calendar cal0 = Calendar.getInstance();
				cal0.setTime(newDates.get(0));
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(newDates.get(1));
				if(cal0.get(Calendar.MONTH) != cal1.get(Calendar.MONTH)){
					newDates.remove(0);
				}
			}
			SimpleDateFormat newDatas = new SimpleDateFormat("yyyy-MM-dd");
			Integer dayOfMonth = 0;
			if(newDates.size() > 0){
				for (int i = 0; i < Integer.parseInt(currnetDateS[2]); i++) {
					dayOfMonth++;
					if(newDates.size() > 0){
						if(newDatas.parse(currnetDateS[0]+"-"+currnetDateS[1]+"-"+dayOfMonth).getTime() > newDates.get(0).getTime()){
							newDates.remove(0);
						}
					}
					
					if(newDates.size() > 0){
						if(newDatas.parse(currnetDateS[0]+"-"+currnetDateS[1]+"-"+dayOfMonth).getTime() <= newDates.get(0).getTime()){
							for (int j = 0; j < scheduleHistorys.size(); j++) {
								if(scheduleHistorys.get(j).getInsertDate().getTime() == newDates.get(0).getTime()){
									MonthReport his = new MonthReport();
									his.setDateOfWeek(scheduleHistorys.get(j).getDateOfWeek());
									his.setDateOfMonth(scheduleHistorys.get(j).getDateOfMonth());
									his.setWeekOfMonth(scheduleHistorys.get(j).getWeekOfMonth());
									his.setPerunits(scheduleHistorys.get(j).getPerunits());
									his.setPeriod(scheduleHistorys.get(j).getPeriod());
									map.put(dayOfMonth, his);
								}
							}
						}
					}else{
						map.put(dayOfMonth, monthReport);
					}
				}
			}
			return map;
		//如当前schedule没有历史记录，则使用当前monthreport对象
		}else{
			Integer dayOfMonth = 0;
			for (int i = 0; i < Integer.parseInt(currnetDateS[2]); i++) {
				dayOfMonth++;
				map.put(dayOfMonth, monthReport);
			}
			return map;
		}
	}
	
    /**
     * 判断当前天，是否需要更新day_X_1和day_X_2两个属性
     * @param currentDate 当前日期
     * @param currentDay 当前天数
     * @param monthReport 更新后的monthreport对象
     * @return
     */
	public static Boolean write(String currentDate,int currentDay,MonthReport monthReport) {
		try {
			String dateOfWeek = monthReport.getDateOfWeek();
			String weekOfMonth = monthReport.getWeekOfMonth();
			String dateOfMonth = monthReport.getDateOfMonth();
			if(null != dateOfMonth && !dateOfMonth.equals("") && !dateOfMonth.equals("Any")){
				return dateOfMonth.indexOf(String.valueOf(currentDay)) != -1;
			}
			if(dateOfWeek.equals("Any")){
				return true;
			}
			//切割时间，用来拼装每周对应每日的日期
			String[] cd = currentDate.split("-");
			String date = cd[0]+"-"+cd[1];
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
			Date date1 = dateFormat.parse(date);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			int days = Integer.parseInt(cd[2]);

			//Map类型，数据类型为，判断当前月份有几周，每周开始日期-结束日期
			//数据例如：   第一周：{1号，2号}，第二周：{3号，9号}...
			Map<Integer, String> weekInDay = new HashMap<Integer, String>();
			int week_s_num = 0;
			int week_e_num = 0;
			int count = 0;
			for (int i = 1; i <= days; i++) {
				DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
				Date date2 = dateFormat1.parse(date + "-" + i);
				calendar.clear();
				calendar.setTime(date2);
				int k = new Integer(calendar.get(Calendar.DAY_OF_WEEK));
				
				if (k == 1) {// 若当天是周日
					count++;
					if (i - 6 <= 1) {
						week_s_num = 1;
					} else {
						week_s_num = i - 6;
					}
					week_e_num = i;
				}
				if (k != 1 && i == days) {// 若是本月最好一天，且不是周日
					count++;
					week_s_num = i - k + 2;
					week_e_num = i;
				}
				
				if(count != 0){
					weekInDay.put(count, week_s_num+","+week_e_num);
				}
			}
			
			Week.put("First", 1);
			Week.put("Second", 2);
			Week.put("Third", 3);
			Week.put("Fourth", 4);
			Week.put("Last", 5);
			if(count >= 6){
				Week.put("Last", count);
			}
			
			//在weekInDay类型数据中，填充时间
			//数据例如：    第1周：{1，2，3，4，5，6，7}， 第2周：{8，9，10，11，12，13，14}类似数据
			Map<Integer, List<Integer>> newWeekInDay = new HashMap<Integer, List<Integer>>();
			for (Map.Entry<Integer, String> entry : weekInDay.entrySet()) {
				//System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue());
				
				String[] day = entry.getValue().split(",");
				
				List<Integer> dayInWeek = new ArrayList<Integer>();
				Integer first_dayInWeek = Integer.parseInt(day[0]);
				dayInWeek.add(0,first_dayInWeek);
				for (int i = 1; i < 7; i++) {
					if(first_dayInWeek < Integer.parseInt(day[1])){
						first_dayInWeek++;
						dayInWeek.add(i,first_dayInWeek);
					}
				}
				newWeekInDay.put(entry.getKey(), dayInWeek);
			}
			
			//修改第一周，第一周如不是从周一开始，则在第一周数组中补充0
			//数据例如:第一周：{0，0，0，0，0，1，2}，第二周：{3，4，5，6，7，8，9}...
			List<Integer> firstWeek = newWeekInDay.get(1);
			List<Integer> newFirstWeek = new ArrayList<Integer>();
			if(firstWeek.size() < 7){
				for (int i = 0; i < 7; i++) {
					if(i >= (7-firstWeek.size())){
						int sign = i - (7-firstWeek.size());
						newFirstWeek.add(i,firstWeek.get(sign));
					}else{
						newFirstWeek.add(i,0);
					}
				}
				newWeekInDay.put(1, newFirstWeek);
			}
			
			
			List<Boolean> signWrite = new ArrayList<Boolean>();
			int weekSign = 0;
			
			//根据week_of_month  和 date_of_week判断，某周的某一天是否需要写入
				
			//把英文Mon，Tue等星期转化为对应 数字 0，1...
			List<Integer> dateOfWeekSign = new ArrayList<Integer>();
			
			dateOfWeek = dateOfWeek.replace("\"","");
			String [] dateOfWeeks = dateOfWeek.split(";");
			
			for (int i = 0; i < dateOfWeeks.length; i++) {
				dateOfWeekSign.add(i,Day.get(dateOfWeeks[i]));
			}
			
			weekOfMonth = weekOfMonth.replace("\r", "");
			if(weekOfMonth.equals("Any") || weekOfMonth.equals("")){
				for (Map.Entry<Integer, List<Integer>> entry : newWeekInDay.entrySet()) {
					List<Integer> day = entry.getValue();
					for (int i = 0; i < day.size(); i++) {
						if(day.get(i) != 0){
							if(dateOfWeekSign.contains(i)){
								signWrite.add(weekSign,true);
							}else{
								signWrite.add(weekSign,false);
							}
							weekSign++;
						}
					}
				}
			}else{
				for (Map.Entry<Integer, List<Integer>> entry : newWeekInDay.entrySet()) {
					List<Integer> day = entry.getValue();
					//当weekOfMonth有值，并等于当前星期数时，进入此方法，获得当前月份的布尔List
					if(entry.getKey().equals(Week.get(weekOfMonth))){
						for (int i = 0; i < day.size(); i++) {
							if(day.get(i) != 0){
								if(dateOfWeekSign.contains(i)){
									signWrite.add(weekSign,true);
								}else{
									signWrite.add(weekSign,false);
								}
								weekSign++;
							}
						}
					}else{
						for (int i = 0; i < day.size(); i++) {
							if(day.get(i) != 0){
								signWrite.add(weekSign,false);
								weekSign++;
							}
						}
					}
				}
			}
			
			for (int i = 0; i < signWrite.size(); i++) {
				if(i == (currentDay-1)){
					return signWrite.get(i);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	
	/**
	 * 获得如：(1(0)/6)中所需要的值
	 * @param nums day_X_2的值
	 * @param sign 下标
	 * @return 所需值
	 */
	public int formatNums(String nums,int sign){
		int num = 0;
		if("" != nums && !"null".equals(nums) && null != nums){
			int a = nums.indexOf("(");
			int b = nums.indexOf("/");
			String a1 = nums.substring(0, a);
			String a2 = nums.substring(b+1, nums.length());
			String[] numString = {a1,"", a2}; 
			if("" != numString[sign] && !"null".equals(numString[sign]) && null != numString[sign]){
				num = Integer.parseInt(numString[sign]);
			}
		}
		return num;
	}
	
	//检查日期格式是否正确
	public boolean checkTime(String strDateTime) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ndate = format.parse(strDateTime);
        String str = format.format(ndate);
        String [] d = strDateTime.split("-");
        String m = d[1];
        String day = d[2];
        if(d[1].length() <= 1){ m = "0" + d[1]; }
        if(d[2].length() <= 1){ day = "0" + d[2]; }
        strDateTime = d[0] + "-" + m + "-"+ day;
        //success
        if (str.equals(strDateTime))
            return true;
        //datetime is not validate
        else
            return false;
	}
	
	@Override
    public List<Integer> selectAllAvaiableMonthFromDB() {
        return this.monthReportMapper.selectAllAvaiableMonthFromDB();
    }
}
