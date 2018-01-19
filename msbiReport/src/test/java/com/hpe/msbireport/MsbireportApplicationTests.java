package com.hpe.msbireport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.domain.RunTimeByDate;
import com.hpe.msbireport.domain.ScheduleHistory;
import com.hpe.msbireport.mapper.BackupLogMapper;
import com.hpe.msbireport.mapper.MonthReportMapper;
import com.hpe.msbireport.mapper.ScheduleHistoryMapper;
import com.hpe.msbireport.service.MonthReportService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsbireportApplicationTests {
	@Autowired
	private BackupLogMapper backupLogMapper;
	@Autowired
	private MonthReportMapper monthReportMapper;
	@Autowired
	private MonthReportService monthReportService;
	@Autowired
	private ScheduleHistoryMapper scheduleHistoryMapper;
	

	@Test
	public void contextLoads() {
		try {
			String schedName = "LBITARC2_MONTHLY_15M_BACKUP";
			String currentDate = "2017-4-30";
			List<MonthReport> list = monthReportMapper.selectAllForUpate();
			MonthReport currentMR = null;
			for (MonthReport monthReport : list) {
				if(monthReport.getScheduleName().equals(schedName)){
					currentMR = monthReport;
				}
			}
			
			String [] currnetDateS = currentDate.split("-");
			Date cDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
			//历史记录
			List<ScheduleHistory> hisList = scheduleHistoryMapper.selectByEnabled(1);
			
			//scheledName 为 key
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
			
			
			//获得历史记录
			List<ScheduleHistory> scheduleHistorys = hisMap.get(schedName);
			List<Date> hisDate = new ArrayList<Date>();
			Date cHisDate = null;
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
			
			
			//System.out.println(newDates);
			
			SimpleDateFormat newDatas = new SimpleDateFormat("yyyy-MM-dd");
			List<Integer> testlist = new ArrayList<Integer>();
			Integer testi = 0;
			Integer testa = 0;
			Map<Integer, MonthReport> map = new HashMap<Integer, MonthReport>();
			if(newDates.size() > 0){
				for (int i = 0; i < Integer.parseInt(currnetDateS[2]); i++) {
					testa++;
					if(newDates.size() > 0){
						if(newDatas.parse(currnetDateS[0]+"-"+currnetDateS[1]+"-"+testa).getTime() > newDates.get(testi).getTime()){
							newDates.remove(0);
						}
					}
					
					if(newDates.size() > 0){
						if(newDatas.parse(currnetDateS[0]+"-"+currnetDateS[1]+"-"+testa).getTime() <= newDates.get(testi).getTime()){
							for (int j = 0; j < scheduleHistorys.size(); j++) {
								if(scheduleHistorys.get(j).getInsertDate().getTime() == newDates.get(testi).getTime()){
									MonthReport his = new MonthReport();
									his.setDateOfWeek(scheduleHistorys.get(j).getDateOfWeek());
									his.setDateOfMonth(scheduleHistorys.get(j).getDateOfMonth());
									his.setWeekOfMonth(scheduleHistorys.get(j).getWeekOfMonth());
									his.setPerunits(scheduleHistorys.get(j).getPerunits());
									his.setPeriod(scheduleHistorys.get(j).getPeriod());
									map.put(testa, his);
								}
							}
						}
					}else{
						map.put(testa, currentMR);
						//System.out.println(testa);
					}
					
				}
			}
			
			for (Map.Entry<Integer, MonthReport> entry : map.entrySet()) {
				System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue().getDateOfMonth());
			}
			
			
			//查询所有最新scheduleName数据
			/*List<MonthReport> list = monthReportMapper.selectAllForUpate();
			
			//查询backuplog表所有数据，用来写入monthreport表中的执行次数字段
			List<RunTimeByDate> blList = backupLogMapper.selectRunTimeByDate("2017-4-1","2017-4-30");
			
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
			
			int num1 = 1;
			int num2 = 1;
			for (MonthReport monthReport : list) {
				if(null != monthReport.getDateOfMonth() && !monthReport.getDateOfMonth().equals("Any") && !monthReport.getDateOfMonth().equals("")){
					System.out.println("a----:"+num1+"------:"+monthReport.getDateOfMonth());
					num1++;
				}else {
					System.out.println("b----:"+num2+"------:"+monthReport.getDateOfMonth());
					num2++;
				}
			}*/
			
			//System.out.println(blMap);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*String startDate = "";
		String currentDate = "2017-4-30";
		boolean hasHistory = false;
		int insertSize = 300;
		try {
			boolean result = monthReportService.formatMonthReportTable(startDate, currentDate, hasHistory, insertSize);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	public static void main(String[] args) {
		/*String nums = "null;null;1";
		int sign = 0;
		int num = 0;
		if("" != nums && "null" != nums && null != nums){
			String[] numString = nums.split(";");
			if("" != numString[sign] && !"null".equals(numString[sign]) && null != numString[sign]){
				num = Integer.parseInt(numString[sign]);
			}
		}*/
		String i = "2";
;
		
		System.out.println(i.indexOf("1"));
		
		/*try {
			Date d1 = new SimpleDateFormat("yyyy-MM").parse("2015-6-10");//定义起始日期
			Date d2 = new SimpleDateFormat("yyyy-MM").parse("2016-5-20");//定义结束日期
			Calendar dd = Calendar.getInstance();//定义日期实例
			dd.setTime(d1);//设置日期起始时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(dd.getTime().before(d2)){//判断是否到结束日期
				dd.add(Calendar.MONTH, 1);  
		        dd.set(Calendar.DAY_OF_MONTH, 0);
				String str = sdf.format(dd.getTime());
				System.out.println(str);//输出日期结果
				dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
			}
			System.out.println(sdf.format(d2));
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}
	
	public String num(String name,String date) {
		String startDate = "2017-4-1";
		String endDate = "2017-4-30";
		List<RunTimeByDate> list = backupLogMapper.selectRunTimeByDate(startDate,endDate);
		System.out.println(list.size());
		for (RunTimeByDate runTimeByDate : list) {
			if(runTimeByDate.getSchedulename().equals(name) && runTimeByDate.getStartdate().equals(date)){
				return runTimeByDate.getRunnum();
			}
		}
		return "0";
	}

}
