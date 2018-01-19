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
		
		//历史记录
		List<ScheduleHistory> hisList = scheduleHistoryMapper.selectByEnabled(1);
		Map<String,List<ScheduleHistory>> hisMap = new HashMap<String,List<ScheduleHistory>>();
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
		
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if("" == currentDate || null == currentDate){
    		currentDate = sdf.format(new Date());
    	}
    	Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);//当前日期
    	if("" != startDate && null != startDate){
    		Date d1 = new SimpleDateFormat("yyyy-MM").parse(startDate);//定义起始日期
    		Date d2 = new SimpleDateFormat("yyyy-MM").parse(currentDate);//定义结束日期
    		Calendar dd = Calendar.getInstance();//定义日期实例
    		dd.setTime(d1);//设置日期起始时间
    		while(dd.getTime().before(d2)){//判断是否到结束日期
    			dd.add(Calendar.MONTH, 1);  
    			dd.set(Calendar.DAY_OF_MONTH, 0);
    			String str = sdf.format(dd.getTime());
    			//System.out.println(str);//输出日期结果
    			formatMonthReport(list,hisMap,str,insertSize);
    			dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
    		}
    	}
    	formatMonthReport(list,hisMap,sdf.format(d3),insertSize);
    	result = true;
    	return result;
	}
    
    public void formatMonthReport(List<MonthReport> list,Map<String,List<ScheduleHistory>> hisMap,String currentDate,int insertSize) throws Exception{
		//入参currentDate 格式：yyyy-mm-dd
		//String currentDate = "2017-04-27";
    	Date cDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
		String [] currentDates = currentDate.split("-");
		//入参日期:天数
		Integer currentDay = Integer.parseInt(currentDates[2]);
		
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
		

		for (MonthReport monthReport : list) {
			//获得数据类型
			String schedStyle = monthReport.getSchedStyle();
			//获得名称
			String schedName = monthReport.getScheduleName();
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
			
			//获得历史记录
			List<ScheduleHistory> scheduleHistorys = hisMap.get(schedName);
			SimpleDateFormat sdfHis = new SimpleDateFormat("yyyy-MM");
			List<Date> hisDate = new ArrayList<Date>();
			Date cHisDate = new Date();
			//先取当月日期，在取小于当月日期
			if(null != scheduleHistorys && scheduleHistorys.size() > 0){
				for (ScheduleHistory scheduleHistory : scheduleHistorys) {
					if(sdfHis.format(scheduleHistory.getInsertDate()).equals(sdfHis.format(cDate))){
						hisDate.add(scheduleHistory.getInsertDate());
					}else{
						if(cDate.getTime() < scheduleHistory.getInsertDate().getTime()){
							cHisDate = scheduleHistory.getInsertDate();
							break;
						}
					}
				}
			}
			
			//DateOfMonth有值，则根据此数值确定当前月份需要更新的天数
			if(null != monthReport.getDateOfMonth() && !monthReport.getDateOfMonth().equals("Any") && !monthReport.getDateOfMonth().equals("")){
				String dateOfMontht = monthReport.getDateOfMonth();
				if(dateOfMontht.indexOf("1") != -1){monthReport.setDay011("1");monthReport.setDay012(runNum(blList, schedName, "1")+"(0)/"+jobNums);}
				if(dateOfMontht.indexOf("2") != -1){}
				if(dateOfMontht.indexOf("3") != -1){}
				if(dateOfMontht.indexOf("4") != -1){}
				if(dateOfMontht.indexOf("5") != -1){}
				if(dateOfMontht.indexOf("6") != -1){}
				if(dateOfMontht.indexOf("7") != -1){}
				if(dateOfMontht.indexOf("8") != -1){}
				if(dateOfMontht.indexOf("9") != -1){}
				if(dateOfMontht.indexOf("10") != -1){}
				if(dateOfMontht.indexOf("11") != -1){}
				if(dateOfMontht.indexOf("12") != -1){}
				if(dateOfMontht.indexOf("13") != -1){}
				if(dateOfMontht.indexOf("14") != -1){}
				if(dateOfMontht.indexOf("15") != -1){}
				if(dateOfMontht.indexOf("16") != -1){}
				if(dateOfMontht.indexOf("17") != -1){}
				if(dateOfMontht.indexOf("18") != -1){}
				if(dateOfMontht.indexOf("19") != -1){}
				if(dateOfMontht.indexOf("20") != -1){}
				if(dateOfMontht.indexOf("21") != -1){}
				if(dateOfMontht.indexOf("22") != -1){}
				if(dateOfMontht.indexOf("23") != -1){}
				if(dateOfMontht.indexOf("24") != -1){}
				if(dateOfMontht.indexOf("25") != -1){}
				if(dateOfMontht.indexOf("26") != -1){}
				if(dateOfMontht.indexOf("27") != -1){}
				if(dateOfMontht.indexOf("28") != -1){}
				if(dateOfMontht.indexOf("29") != -1){}
				if(dateOfMontht.indexOf("30") != -1){}
				if(dateOfMontht.indexOf("31") != -1){}
			}else {
				
			}
			
			/*if (schedStyle.equals("CLASSIC") ) {
				
				
				
				//DateOfWeek类型为 Any，直接处理
				if(monthReport.getDateOfWeek().equals("Any")){
					if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012(runNum(blList, schedName, "1")+";null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);};
					if(currentDay>=2){monthReport.setDay021("1");monthReport.setDay022(runNum(blList, schedName, "2")+";null;"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);};
					if(currentDay>=3){monthReport.setDay031("1");monthReport.setDay032(runNum(blList, schedName, "3")+";null;"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);};
					if(currentDay>=4){monthReport.setDay041("1");monthReport.setDay042(runNum(blList, schedName, "4")+";null;"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);};
					if(currentDay>=5){monthReport.setDay051("1");monthReport.setDay052(runNum(blList, schedName, "5")+";null;"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);};
					if(currentDay>=6){monthReport.setDay061("1");monthReport.setDay062(runNum(blList, schedName, "6")+";null;"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);};
					if(currentDay>=7){monthReport.setDay071("1");monthReport.setDay072(runNum(blList, schedName, "7")+";null;"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);};
					if(currentDay>=8){monthReport.setDay081("1");monthReport.setDay082(runNum(blList, schedName, "8")+";null;"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);};
					if(currentDay>=9){monthReport.setDay091("1");monthReport.setDay092(runNum(blList, schedName, "9")+";null;"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);};
					if(currentDay>=10){monthReport.setDay101("1");monthReport.setDay102(runNum(blList, schedName, "10")+";null;"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);};
					if(currentDay>=11){monthReport.setDay111("1");monthReport.setDay112(runNum(blList, schedName, "11")+";null;"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);};
					if(currentDay>=12){monthReport.setDay121("1");monthReport.setDay122(runNum(blList, schedName, "12")+";null;"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);};
					if(currentDay>=13){monthReport.setDay131("1");monthReport.setDay132(runNum(blList, schedName, "13")+";null;"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);};
					if(currentDay>=14){monthReport.setDay141("1");monthReport.setDay142(runNum(blList, schedName, "14")+";null;"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);};
					if(currentDay>=15){monthReport.setDay151("1");monthReport.setDay152(runNum(blList, schedName, "15")+";null;"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);};
					if(currentDay>=16){monthReport.setDay161("1");monthReport.setDay162(runNum(blList, schedName, "16")+";null;"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);};
					if(currentDay>=17){monthReport.setDay171("1");monthReport.setDay172(runNum(blList, schedName, "17")+";null;"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);};
					if(currentDay>=18){monthReport.setDay181("1");monthReport.setDay182(runNum(blList, schedName, "18")+";null;"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);};
					if(currentDay>=19){monthReport.setDay191("1");monthReport.setDay192(runNum(blList, schedName, "19")+";null;"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);};
					if(currentDay>=20){monthReport.setDay201("1");monthReport.setDay202(runNum(blList, schedName, "20")+";null;"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);};
					if(currentDay>=21){monthReport.setDay211("1");monthReport.setDay212(runNum(blList, schedName, "21")+";null;"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);};
					if(currentDay>=22){monthReport.setDay221("1");monthReport.setDay222(runNum(blList, schedName, "22")+";null;"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);};
					if(currentDay>=23){monthReport.setDay231("1");monthReport.setDay232(runNum(blList, schedName, "23")+";null;"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);};
					if(currentDay>=24){monthReport.setDay241("1");monthReport.setDay242(runNum(blList, schedName, "24")+";null;"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);};
					if(currentDay>=25){monthReport.setDay251("1");monthReport.setDay252(runNum(blList, schedName, "25")+";null;"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);};
					if(currentDay>=26){monthReport.setDay261("1");monthReport.setDay262(runNum(blList, schedName, "26")+";null;"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);};
					if(currentDay>=27){monthReport.setDay271("1");monthReport.setDay272(runNum(blList, schedName, "27")+";null;"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);};
					if(currentDay>=28){monthReport.setDay281("1");monthReport.setDay282(runNum(blList, schedName, "28")+";null;"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);};
					if(currentDay>=29){monthReport.setDay291("1");monthReport.setDay292(runNum(blList, schedName, "29")+";null;"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);};
					if(currentDay>=30){monthReport.setDay301("1");monthReport.setDay302(runNum(blList, schedName, "30")+";null;"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);};
					if(currentDay>=31){monthReport.setDay311("1");monthReport.setDay312(runNum(blList, schedName, "31")+";null;"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);};
					//更新数据
					//monthReportMapper.updateByPrimaryKey(monthReport);
				}else{
					//write 方法，返回布尔类型List，通过判断是否为真，执行写入1  或  写入4
					List<Boolean> writeList = write(currentDate,Day.get(monthReport.getDateOfWeek()),"CLASSIC",null,null,monthReport.getScheduleName(),hisList);
					if(currentDay>=1){
						if(writeList.get(0)){monthReport.setDay011("1");monthReport.setDay012(runNum(blList, schedName, "1")+";null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
					}else{monthReport.setDay011("4");monthReport.setDay012(null);};
					if(currentDay>=2){
						if(writeList.get(1)){monthReport.setDay021("1");monthReport.setDay022(runNum(blList, schedName, "2")+";null;"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
					}else{monthReport.setDay021("4");monthReport.setDay022(null);};
					if(currentDay>=3){
						if(writeList.get(2)){monthReport.setDay031("1");monthReport.setDay032(runNum(blList, schedName, "3")+";null;"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);};
					}else{monthReport.setDay031("4");monthReport.setDay032(null);};
					if(currentDay>=4){
						if(writeList.get(3)){monthReport.setDay041("1");monthReport.setDay042(runNum(blList, schedName, "4")+";null;"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);};
					}else{monthReport.setDay041("4");monthReport.setDay042(null);};
					if(currentDay>=5){
						if(writeList.get(4)){monthReport.setDay051("1");monthReport.setDay052(runNum(blList, schedName, "5")+";null;"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);};
					}else{monthReport.setDay051("4");monthReport.setDay052(null);};
					if(currentDay>=6){
						if(writeList.get(5)){monthReport.setDay061("1");monthReport.setDay062(runNum(blList, schedName, "6")+";null;"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);};
					}else{monthReport.setDay061("4");monthReport.setDay062(null);};
					if(currentDay>=7){
						if(writeList.get(6)){monthReport.setDay071("1");monthReport.setDay072(runNum(blList, schedName, "7")+";null;"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);};
					}else{monthReport.setDay071("4");monthReport.setDay072(null);};
					if(currentDay>=8){
						if(writeList.get(7)){monthReport.setDay081("1");monthReport.setDay082(runNum(blList, schedName, "8")+";null;"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);};
					}else{monthReport.setDay081("4");monthReport.setDay082(null);};
					if(currentDay>=9){
						if(writeList.get(8)){monthReport.setDay091("1");monthReport.setDay092(runNum(blList, schedName, "9")+";null;"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);};
					}else{monthReport.setDay091("4");monthReport.setDay092(null);};
					if(currentDay>=10){
						if(writeList.get(9)){monthReport.setDay101("1");monthReport.setDay102(runNum(blList, schedName, "10")+";null;"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);};
					}else{monthReport.setDay101("4");monthReport.setDay102(null);};
					if(currentDay>=11){
						if(writeList.get(10)){monthReport.setDay111("1");monthReport.setDay112(runNum(blList, schedName, "11")+";null;"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);};
					}else{monthReport.setDay111("4");monthReport.setDay112(null);};
					if(currentDay>=12){
						if(writeList.get(11)){monthReport.setDay121("1");monthReport.setDay122(runNum(blList, schedName, "12")+";null;"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);};
					}else{monthReport.setDay121("4");monthReport.setDay122(null);};
					if(currentDay>=13){
						if(writeList.get(12)){monthReport.setDay131("1");monthReport.setDay132(runNum(blList, schedName, "13")+";null;"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);};
					}else{monthReport.setDay131("4");monthReport.setDay132(null);};
					if(currentDay>=14){
						if(writeList.get(13)){monthReport.setDay141("1");monthReport.setDay142(runNum(blList, schedName, "14")+";null;"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);};
					}else{monthReport.setDay141("4");monthReport.setDay142(null);};
					if(currentDay>=15){
						if(writeList.get(14)){monthReport.setDay151("1");monthReport.setDay152(runNum(blList, schedName, "15")+";null;"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);};
					}else{monthReport.setDay151("4");monthReport.setDay152(null);};
					if(currentDay>=16){
						if(writeList.get(15)){monthReport.setDay161("1");monthReport.setDay162(runNum(blList, schedName, "16")+";null;"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);};
					}else{monthReport.setDay161("4");monthReport.setDay162(null);};
					if(currentDay>=17){
						if(writeList.get(16)){monthReport.setDay171("1");monthReport.setDay172(runNum(blList, schedName, "17")+";null;"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);};
					}else{monthReport.setDay171("4");monthReport.setDay172(null);};
					if(currentDay>=18){
						if(writeList.get(17)){monthReport.setDay181("1");monthReport.setDay182(runNum(blList, schedName, "18")+";null;"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);};
					}else{monthReport.setDay181("4");monthReport.setDay182(null);};
					if(currentDay>=19){
						if(writeList.get(18)){monthReport.setDay191("1");monthReport.setDay192(runNum(blList, schedName, "19")+";null;"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);};
					}else{monthReport.setDay191("4");monthReport.setDay192(null);};
					if(currentDay>=20){
						if(writeList.get(19)){monthReport.setDay201("1");monthReport.setDay202(runNum(blList, schedName, "20")+";null;"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);};
					}else{monthReport.setDay201("4");monthReport.setDay202(null);};
					if(currentDay>=21){
						if(writeList.get(20)){monthReport.setDay211("1");monthReport.setDay212(runNum(blList, schedName, "21")+";null;"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);};
					}else{monthReport.setDay211("4");monthReport.setDay212(null);};
					if(currentDay>=22){
						if(writeList.get(21)){monthReport.setDay221("1");monthReport.setDay222(runNum(blList, schedName, "22")+";null;"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);};
					}else{monthReport.setDay221("4");monthReport.setDay222(null);};
					if(currentDay>=23){
						if(writeList.get(22)){monthReport.setDay231("1");monthReport.setDay232(runNum(blList, schedName, "23")+";null;"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);};
					}else{monthReport.setDay231("4");monthReport.setDay232(null);};
					if(currentDay>=24){
						if(writeList.get(23)){monthReport.setDay241("1");monthReport.setDay242(runNum(blList, schedName, "24")+";null;"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);};
					}else{monthReport.setDay241("4");monthReport.setDay242(null);};
					if(currentDay>=25){
						if(writeList.get(24)){monthReport.setDay251("1");monthReport.setDay252(runNum(blList, schedName, "25")+";null;"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);};
					}else{monthReport.setDay251("4");monthReport.setDay252(null);};
					if(currentDay>=26){
						if(writeList.get(25)){monthReport.setDay261("1");monthReport.setDay262(runNum(blList, schedName, "26")+";null;"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);};
					}else{monthReport.setDay261("4");monthReport.setDay262(null);};
					if(currentDay>=27){
						if(writeList.get(26)){monthReport.setDay271("1");monthReport.setDay272(runNum(blList, schedName, "27")+";null;"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);};
					}else{monthReport.setDay271("4");monthReport.setDay272(null);};
					if(currentDay>=28){
						if(writeList.get(27)){monthReport.setDay281("1");monthReport.setDay282(runNum(blList, schedName, "28")+";null;"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);};
					}else{monthReport.setDay281("4");monthReport.setDay282(null);};
					if(currentDay>=29){
						if(writeList.get(28)){monthReport.setDay291("1");monthReport.setDay292(runNum(blList, schedName, "29")+";null;"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);};
					}else{monthReport.setDay291("4");monthReport.setDay292(null);};
					if(currentDay>=30){
						if(writeList.get(29)){monthReport.setDay301("1");monthReport.setDay302(runNum(blList, schedName, "30")+";null;"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);};
					}else{monthReport.setDay301("4");monthReport.setDay302(null);};
					if(currentDay>=31){
						if(writeList.get(30)){monthReport.setDay311("1");monthReport.setDay312(runNum(blList, schedName, "31")+";null;"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);};
					}else{monthReport.setDay311("4");monthReport.setDay312(null);};
					//monthReportMapper.updateByPrimaryKey(monthReport);
				}
				
			//根据ENHANCED类型处理
			} else if (schedStyle.equals("ENHANCED")) {
				List<Boolean> writeList = write(currentDate,0,"ENHANCED",monthReport.getDateOfWeek(),monthReport.getWeekOfMonth(),null,null);
				String jobNums = "1";
				if(currentDay>=1){
					if(writeList.get(0)){monthReport.setDay011("1");monthReport.setDay012(runNum(blList, schedName, "1")+";null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
				}else{monthReport.setDay011("4");monthReport.setDay012(null);};
				if(currentDay>=2){
					if(writeList.get(1)){monthReport.setDay021("1");monthReport.setDay022(runNum(blList, schedName, "2")+";null;"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
				}else{monthReport.setDay021("4");monthReport.setDay022(null);};
				if(currentDay>=3){
					if(writeList.get(2)){monthReport.setDay031("1");monthReport.setDay032(runNum(blList, schedName, "3")+";null;"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);};
				}else{monthReport.setDay031("4");monthReport.setDay032(null);};
				if(currentDay>=4){
					if(writeList.get(3)){monthReport.setDay041("1");monthReport.setDay042(runNum(blList, schedName, "4")+";null;"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);};
				}else{monthReport.setDay041("4");monthReport.setDay042(null);};
				if(currentDay>=5){
					if(writeList.get(4)){monthReport.setDay051("1");monthReport.setDay052(runNum(blList, schedName, "5")+";null;"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);};
				}else{monthReport.setDay051("4");monthReport.setDay052(null);};
				if(currentDay>=6){
					if(writeList.get(5)){monthReport.setDay061("1");monthReport.setDay062(runNum(blList, schedName, "6")+";null;"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);};
				}else{monthReport.setDay061("4");monthReport.setDay062(null);};
				if(currentDay>=7){
					if(writeList.get(6)){monthReport.setDay071("1");monthReport.setDay072(runNum(blList, schedName, "7")+";null;"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);};
				}else{monthReport.setDay071("4");monthReport.setDay072(null);};
				if(currentDay>=8){
					if(writeList.get(7)){monthReport.setDay081("1");monthReport.setDay082(runNum(blList, schedName, "8")+";null;"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);};
				}else{monthReport.setDay081("4");monthReport.setDay082(null);};
				if(currentDay>=9){
					if(writeList.get(8)){monthReport.setDay091("1");monthReport.setDay092(runNum(blList, schedName, "9")+";null;"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);};
				}else{monthReport.setDay091("4");monthReport.setDay092(null);};
				if(currentDay>=10){
					if(writeList.get(9)){monthReport.setDay101("1");monthReport.setDay102(runNum(blList, schedName, "10")+";null;"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);};
				}else{monthReport.setDay101("4");monthReport.setDay102(null);};
				if(currentDay>=11){
					if(writeList.get(10)){monthReport.setDay111("1");monthReport.setDay112(runNum(blList, schedName, "11")+";null;"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);};
				}else{monthReport.setDay111("4");monthReport.setDay112(null);};
				if(currentDay>=12){
					if(writeList.get(11)){monthReport.setDay121("1");monthReport.setDay122(runNum(blList, schedName, "12")+";null;"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);};
				}else{monthReport.setDay121("4");monthReport.setDay122(null);};
				if(currentDay>=13){
					if(writeList.get(12)){monthReport.setDay131("1");monthReport.setDay132(runNum(blList, schedName, "13")+";null;"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);};
				}else{monthReport.setDay131("4");monthReport.setDay132(null);};
				if(currentDay>=14){
					if(writeList.get(13)){monthReport.setDay141("1");monthReport.setDay142(runNum(blList, schedName, "14")+";null;"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);};
				}else{monthReport.setDay141("4");monthReport.setDay142(null);};
				if(currentDay>=15){
					if(writeList.get(14)){monthReport.setDay151("1");monthReport.setDay152(runNum(blList, schedName, "15")+";null;"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);};
				}else{monthReport.setDay151("4");monthReport.setDay152(null);};
				if(currentDay>=16){
					if(writeList.get(15)){monthReport.setDay161("1");monthReport.setDay162(runNum(blList, schedName, "16")+";null;"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);};
				}else{monthReport.setDay161("4");monthReport.setDay162(null);};
				if(currentDay>=17){
					if(writeList.get(16)){monthReport.setDay171("1");monthReport.setDay172(runNum(blList, schedName, "17")+";null;"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);};
				}else{monthReport.setDay171("4");monthReport.setDay172(null);};
				if(currentDay>=18){
					if(writeList.get(17)){monthReport.setDay181("1");monthReport.setDay182(runNum(blList, schedName, "18")+";null;"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);};
				}else{monthReport.setDay181("4");monthReport.setDay182(null);};
				if(currentDay>=19){
					if(writeList.get(18)){monthReport.setDay191("1");monthReport.setDay192(runNum(blList, schedName, "19")+";null;"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);};
				}else{monthReport.setDay191("4");monthReport.setDay192(null);};
				if(currentDay>=20){
					if(writeList.get(19)){monthReport.setDay201("1");monthReport.setDay202(runNum(blList, schedName, "20")+";null;"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);};
				}else{monthReport.setDay201("4");monthReport.setDay202(null);};
				if(currentDay>=21){
					if(writeList.get(20)){monthReport.setDay211("1");monthReport.setDay212(runNum(blList, schedName, "21")+";null;"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);};
				}else{monthReport.setDay211("4");monthReport.setDay212(null);};
				if(currentDay>=22){
					if(writeList.get(21)){monthReport.setDay221("1");monthReport.setDay222(runNum(blList, schedName, "22")+";null;"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);};
				}else{monthReport.setDay221("4");monthReport.setDay222(null);};
				if(currentDay>=23){
					if(writeList.get(22)){monthReport.setDay231("1");monthReport.setDay232(runNum(blList, schedName, "23")+";null;"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);};
				}else{monthReport.setDay231("4");monthReport.setDay232(null);};
				if(currentDay>=24){
					if(writeList.get(23)){monthReport.setDay241("1");monthReport.setDay242(runNum(blList, schedName, "24")+";null;"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);};
				}else{monthReport.setDay241("4");monthReport.setDay242(null);};
				if(currentDay>=25){
					if(writeList.get(24)){monthReport.setDay251("1");monthReport.setDay252(runNum(blList, schedName, "25")+";null;"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);};
				}else{monthReport.setDay251("4");monthReport.setDay252(null);};
				if(currentDay>=26){
					if(writeList.get(25)){monthReport.setDay261("1");monthReport.setDay262(runNum(blList, schedName, "26")+";null;"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);};
				}else{monthReport.setDay261("4");monthReport.setDay262(null);};
				if(currentDay>=27){
					if(writeList.get(26)){monthReport.setDay271("1");monthReport.setDay272(runNum(blList, schedName, "27")+";null;"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);};
				}else{monthReport.setDay271("4");monthReport.setDay272(null);};
				if(currentDay>=28){
					if(writeList.get(27)){monthReport.setDay281("1");monthReport.setDay282(runNum(blList, schedName, "28")+";null;"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);};
				}else{monthReport.setDay281("4");monthReport.setDay282(null);};
				if(currentDay>=29){
					if(writeList.get(28)){monthReport.setDay291("1");monthReport.setDay292(runNum(blList, schedName, "29")+";null;"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);};
				}else{monthReport.setDay291("4");monthReport.setDay292(null);};
				if(currentDay>=30){
					if(writeList.get(29)){monthReport.setDay301("1");monthReport.setDay302(runNum(blList, schedName, "30")+";null;"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);};
				}else{monthReport.setDay301("4");monthReport.setDay302(null);};
				if(currentDay>=31){
					if(writeList.get(30)){monthReport.setDay311("1");monthReport.setDay312(runNum(blList, schedName, "31")+";null;"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);};
				}else{monthReport.setDay311("4");monthReport.setDay312(null);};
				//更新数据
				//monthReportMapper.updateByPrimaryKey(monthReport);
			}*/
		}
		monthReportInsert(list,insertSize);
    }
    
    public void monthReportInsert(List<MonthReport> monthReports,int size){
    	int sign = 0;
    	List<MonthReport> list = new ArrayList<MonthReport>();
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
        		monthReport.setBsr(String.valueOf(df.format(((float)totalSuccessful/totalSchedule)*100)));
        		list.add(sign, monthReport);
        		sign++;
        	}
    	}
    	
    	if(list!=null&&list.size()>0){
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
	
	/**
	 * 此方法用来获得当前月份中，每天是否需要填写的List
	 * 
	 * @param currentDate 传入日期
	 * @param daySign 类型为CLASSIC时，判断每周是否写入
	 * @param type 类型
	 * @param dateOfWeek 类型为ENHANCED，判断每周是否写入
	 * @param weekOfMonth 类型为ENHANCED，判断每周是否写入
	 * 
	 * @return 布尔类型List，用来判断当前月份，每天是否执行
	 */
	public static List<Boolean> write(String currentDate,int daySign,String type,String dateOfWeek,String weekOfMonth,String sName,List<ScheduleHistory> list) {
		try {
			
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
			if(type.equals("ENHANCED")){
				
				//把英文Mon，Tue等星期转化为对应 数字 0，1...
				List<Integer> dateOfWeekSign = new ArrayList<Integer>();
				dateOfWeek = dateOfWeek.replace("\"","");
				String [] dateOfWeeks = dateOfWeek.split(";");
				for (int i = 0; i < dateOfWeeks.length; i++) {
					dateOfWeekSign.add(i,Day.get(dateOfWeeks[i]));
				}
				
				weekOfMonth = weekOfMonth.replace("\r", "");
				if(weekOfMonth.equals("Any") ){
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
			
			//根据daySign判断，某一天是否需要写入
			}else if(type.equals("CLASSIC")){
				for (Map.Entry<Integer, List<Integer>> entry : newWeekInDay.entrySet()) {
					List<Integer> day = entry.getValue();
					for (int i = 0; i < day.size(); i++) {
						if(day.get(i) != 0){
							if(i == daySign){
								signWrite.add(weekSign,true);
							}else{
								signWrite.add(weekSign,false);
							}
							weekSign++;
						}
					}
				}
			}
			
			return signWrite;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	/**
	 * 返回执行次数
	 * @param list backuplog表所有数据
	 * @param name Schedulename
	 * @param date 日期：天数
	 * @return 执行次数
	 */
	public String runNum(List<RunTimeByDate> list,String name,String date) {
		for (RunTimeByDate runTimeByDate : list) {
			if(runTimeByDate.getSchedulename().equals(name) && runTimeByDate.getStartdate().equals(date)){
				return runTimeByDate.getRunnum();
			}
		}
		return "null";
	}
	
	public int formatNums(String nums,int sign){
		int num = 0;
		if("" != nums && !"null".equals(nums) && null != nums){
			String[] numString = nums.split(";");
			if("" != numString[sign] && !"null".equals(numString[sign]) && null != numString[sign]){
				num = Integer.parseInt(numString[sign]);
			}
		}
		return num;
	}
	
	@Override
    public List<Integer> selectAllAvaiableMonthFromDB() {
        return this.monthReportMapper.selectAllAvaiableMonthFromDB();
    }
}
