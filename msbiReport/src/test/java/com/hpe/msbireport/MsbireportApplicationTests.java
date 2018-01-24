package com.hpe.msbireport;

import java.text.DateFormat;
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
	
	private final static Map<String, Integer> Day = new HashMap<String, Integer>();
	private final static Map<String, Integer> Week = new HashMap<String, Integer>();
	
	@Test
	public void testService(){
		try {
			String currentDate = "2017-4-31";
			String sDate = null;
			boolean s = monthReportService.formatMonthReportTable(sDate, currentDate, true, 200);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void test(){
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
		
		
		try {
			
			String schedName = "DCBPP0735_WINOS_BACKUP";
			String currentDate = "2017-4-30";
			List<MonthReport> list = monthReportMapper.selectAllForUpate();
			MonthReport currentMR = null;
			for (MonthReport monthReport : list) {
				if(monthReport.getScheduleName().equals(schedName)){
					currentMR = monthReport;
				}
			}
			
			String dateOfWeek = currentMR.getDateOfWeek();
			String weekOfMonth = currentMR.getWeekOfMonth();
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
			
			System.out.println(signWrite);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

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
			Integer dayOfMonth = 0;
			Map<Integer, MonthReport> map = new HashMap<Integer, MonthReport>();
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
						map.put(dayOfMonth, currentMR);
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
		String strDateTime = "2017-2-2";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ndate = format.parse(strDateTime);
            String str = format.format(ndate);
            System.out.println(ndate);
            System.out.println(str);
            
            String [] d = strDateTime.split("-");
            String m = d[1];
            String day = d[2];
            if(d[1].length() <= 1){ m = "0" + d[1]; }
            if(d[2].length() <= 1){ day = "0" + d[2]; }
            strDateTime = d[0] + "-" + m + "-"+ day;
            
            System.out.println("strDateTime=" + strDateTime);
            //success
            if (str.equals(strDateTime))
                System.out.println("1");
            //datetime is not validate
            else
            	System.out.println("0");
        } catch (Exception e) {
        	System.out.println("-1");
            e.printStackTrace();
            //format error
        }
		
		
		/*String s = "123(0)/1";
		
		
		
		int a = s.indexOf("(");
		
		String l = s.substring(0, a);
		
		System.out.println(l);*/
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


