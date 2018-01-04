package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.MonthReport;
import com.hpe.msbireport.mapper.MonthReportMapper;
import com.hpe.msbireport.service.MonthReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MonthReport> selectAllMonthReportsByMonth(Integer monthIndicator) {
        return this.monthReportMapper.selectAllMonthReportsByMonth(monthIndicator);
    }
    
    @Override
    public boolean formatMonthReportTable(String currentDate) throws Exception{
    	boolean result = false;
		//入参currentDate 格式：yyyy-mm-dd
		//String currentDate = "2017-4-27";
		String [] currentDates = currentDate.split("-");
		//入参日期:天数
		Integer currentDay = Integer.parseInt(currentDates[2]);
		Map<String, Integer> Day = new HashMap<String, Integer>();
		Day.put("Monday", 0);
		Day.put("Tuesday", 1);
		Day.put("Wednesday", 2);
		Day.put("Thursday", 3);
		Day.put("Friday", 4);
		Day.put("Saturday", 5);
		Day.put("Sunday", 6);
		try {
			//查询数据库，所有数据
			List<MonthReport> list = monthReportMapper.selectAll();

			for (MonthReport monthReport : list) {
				//获得数据类型
				String schedStyle = monthReport.getSchedStyle();

				//根据CLASSIC类型处理
				if (schedStyle.equals("CLASSIC") ) {
					
					//次数类型
					String perunits = monthReport.getPerunits();
					//执行次数
					Integer jobNums = 0;
					//HOURS 与 DAYS分别处理
					if(perunits.equals("HOURS")){
						jobNums = 24 / monthReport.getPeriod();
					}else if(perunits.equals("DAYS")){
						jobNums = monthReport.getPeriod();
					}
					
					//DateOfWeek类型为 Any，直接处理
					if(monthReport.getDateOfWeek().equals("Any")){
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay022(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay032(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay042(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay052(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay062(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay072(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay082(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay092(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay102(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay112(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay122(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay132(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay142(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay152(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay162(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay172(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay182(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay192(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay202(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay212(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay222(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay232(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay242(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay252(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay262(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay272(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay282(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay292(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay302(null);};
						if(currentDay>=1){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay312(null);};
						//更新数据
						monthReportMapper.updateByPrimaryKey(monthReport);
					}else{
						//write 方法，返回布尔类型List，通过判断是否为真，执行写入1  或  写入4
						List<Boolean> writeList = write(currentDate,Day.get(monthReport.getDateOfWeek()),"CLASSIC",null,null);
						if(currentDay>=1){
							if(writeList.get(0)){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
						}else{monthReport.setDay011("4");monthReport.setDay012(null);};
						if(currentDay>=2){
							if(writeList.get(1)){monthReport.setDay021("1");monthReport.setDay022("null;null;"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
						}else{monthReport.setDay021("4");monthReport.setDay022(null);};
						if(currentDay>=3){
							if(writeList.get(2)){monthReport.setDay031("1");monthReport.setDay032("null;null;"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);};
						}else{monthReport.setDay031("4");monthReport.setDay032(null);};
						if(currentDay>=4){
							if(writeList.get(3)){monthReport.setDay041("1");monthReport.setDay042("null;null;"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);};
						}else{monthReport.setDay041("4");monthReport.setDay042(null);};
						if(currentDay>=5){
							if(writeList.get(4)){monthReport.setDay051("1");monthReport.setDay052("null;null;"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);};
						}else{monthReport.setDay051("4");monthReport.setDay052(null);};
						if(currentDay>=6){
							if(writeList.get(5)){monthReport.setDay061("1");monthReport.setDay062("null;null;"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);};
						}else{monthReport.setDay061("4");monthReport.setDay062(null);};
						if(currentDay>=7){
							if(writeList.get(6)){monthReport.setDay071("1");monthReport.setDay072("null;null;"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);};
						}else{monthReport.setDay071("4");monthReport.setDay072(null);};
						if(currentDay>=8){
							if(writeList.get(7)){monthReport.setDay081("1");monthReport.setDay082("null;null;"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);};
						}else{monthReport.setDay081("4");monthReport.setDay082(null);};
						if(currentDay>=9){
							if(writeList.get(8)){monthReport.setDay091("1");monthReport.setDay092("null;null;"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);};
						}else{monthReport.setDay091("4");monthReport.setDay092(null);};
						if(currentDay>=10){
							if(writeList.get(9)){monthReport.setDay101("1");monthReport.setDay102("null;null;"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);};
						}else{monthReport.setDay101("4");monthReport.setDay102(null);};
						if(currentDay>=11){
							if(writeList.get(10)){monthReport.setDay111("1");monthReport.setDay112("null;null;"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);};
						}else{monthReport.setDay111("4");monthReport.setDay112(null);};
						if(currentDay>=12){
							if(writeList.get(11)){monthReport.setDay121("1");monthReport.setDay122("null;null;"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);};
						}else{monthReport.setDay121("4");monthReport.setDay122(null);};
						if(currentDay>=13){
							if(writeList.get(12)){monthReport.setDay131("1");monthReport.setDay132("null;null;"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);};
						}else{monthReport.setDay131("4");monthReport.setDay132(null);};
						if(currentDay>=14){
							if(writeList.get(13)){monthReport.setDay141("1");monthReport.setDay142("null;null;"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);};
						}else{monthReport.setDay141("4");monthReport.setDay142(null);};
						if(currentDay>=15){
							if(writeList.get(14)){monthReport.setDay151("1");monthReport.setDay152("null;null;"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);};
						}else{monthReport.setDay151("4");monthReport.setDay152(null);};
						if(currentDay>=16){
							if(writeList.get(15)){monthReport.setDay161("1");monthReport.setDay162("null;null;"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);};
						}else{monthReport.setDay161("4");monthReport.setDay162(null);};
						if(currentDay>=17){
							if(writeList.get(16)){monthReport.setDay171("1");monthReport.setDay172("null;null;"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);};
						}else{monthReport.setDay171("4");monthReport.setDay172(null);};
						if(currentDay>=18){
							if(writeList.get(17)){monthReport.setDay181("1");monthReport.setDay182("null;null;"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);};
						}else{monthReport.setDay181("4");monthReport.setDay182(null);};
						if(currentDay>=19){
							if(writeList.get(18)){monthReport.setDay191("1");monthReport.setDay192("null;null;"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);};
						}else{monthReport.setDay191("4");monthReport.setDay192(null);};
						if(currentDay>=20){
							if(writeList.get(19)){monthReport.setDay201("1");monthReport.setDay202("null;null;"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);};
						}else{monthReport.setDay201("4");monthReport.setDay202(null);};
						if(currentDay>=21){
							if(writeList.get(20)){monthReport.setDay211("1");monthReport.setDay212("null;null;"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);};
						}else{monthReport.setDay211("4");monthReport.setDay212(null);};
						if(currentDay>=22){
							if(writeList.get(21)){monthReport.setDay221("1");monthReport.setDay222("null;null;"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);};
						}else{monthReport.setDay221("4");monthReport.setDay222(null);};
						if(currentDay>=23){
							if(writeList.get(22)){monthReport.setDay231("1");monthReport.setDay232("null;null;"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);};
						}else{monthReport.setDay231("4");monthReport.setDay232(null);};
						if(currentDay>=24){
							if(writeList.get(23)){monthReport.setDay241("1");monthReport.setDay242("null;null;"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);};
						}else{monthReport.setDay241("4");monthReport.setDay242(null);};
						if(currentDay>=25){
							if(writeList.get(24)){monthReport.setDay251("1");monthReport.setDay252("null;null;"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);};
						}else{monthReport.setDay251("4");monthReport.setDay252(null);};
						if(currentDay>=26){
							if(writeList.get(25)){monthReport.setDay261("1");monthReport.setDay262("null;null;"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);};
						}else{monthReport.setDay261("4");monthReport.setDay262(null);};
						if(currentDay>=27){
							if(writeList.get(26)){monthReport.setDay271("1");monthReport.setDay272("null;null;"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);};
						}else{monthReport.setDay271("4");monthReport.setDay272(null);};
						if(currentDay>=28){
							if(writeList.get(27)){monthReport.setDay281("1");monthReport.setDay282("null;null;"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);};
						}else{monthReport.setDay281("4");monthReport.setDay282(null);};
						if(currentDay>=29){
							if(writeList.get(28)){monthReport.setDay291("1");monthReport.setDay292("null;null;"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);};
						}else{monthReport.setDay291("4");monthReport.setDay292(null);};
						if(currentDay>=30){
							if(writeList.get(29)){monthReport.setDay301("1");monthReport.setDay302("null;null;"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);};
						}else{monthReport.setDay301("4");monthReport.setDay302(null);};
						if(currentDay>=31){
							if(writeList.get(30)){monthReport.setDay311("1");monthReport.setDay312("null;null;"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);};
						}else{monthReport.setDay311("4");monthReport.setDay312(null);};
						monthReportMapper.updateByPrimaryKey(monthReport);
					}
					
				//根据ENHANCED类型处理
				} else if (schedStyle.equals("ENHANCED")) {
					List<Boolean> writeList = write(currentDate,0,"ENHANCED",monthReport.getDateOfWeek(),monthReport.getWeekOfMonth());
					String jobNums = "1";
					if(currentDay>=1){
						if(writeList.get(0)){monthReport.setDay011("1");monthReport.setDay012("null;null;"+jobNums);}else{monthReport.setDay011("4");monthReport.setDay012(null);}
					}else{monthReport.setDay011("4");monthReport.setDay012(null);};
					if(currentDay>=2){
						if(writeList.get(1)){monthReport.setDay021("1");monthReport.setDay022("null;null;"+jobNums);}else{monthReport.setDay021("4");monthReport.setDay022(null);}
					}else{monthReport.setDay021("4");monthReport.setDay022(null);};
					if(currentDay>=3){
						if(writeList.get(2)){monthReport.setDay031("1");monthReport.setDay032("null;null;"+jobNums);}else{monthReport.setDay031("4");monthReport.setDay032(null);};
					}else{monthReport.setDay031("4");monthReport.setDay032(null);};
					if(currentDay>=4){
						if(writeList.get(3)){monthReport.setDay041("1");monthReport.setDay042("null;null;"+jobNums);}else{monthReport.setDay041("4");monthReport.setDay042(null);};
					}else{monthReport.setDay041("4");monthReport.setDay042(null);};
					if(currentDay>=5){
						if(writeList.get(4)){monthReport.setDay051("1");monthReport.setDay052("null;null;"+jobNums);}else{monthReport.setDay051("4");monthReport.setDay052(null);};
					}else{monthReport.setDay051("4");monthReport.setDay052(null);};
					if(currentDay>=6){
						if(writeList.get(5)){monthReport.setDay061("1");monthReport.setDay062("null;null;"+jobNums);}else{monthReport.setDay061("4");monthReport.setDay062(null);};
					}else{monthReport.setDay061("4");monthReport.setDay062(null);};
					if(currentDay>=7){
						if(writeList.get(6)){monthReport.setDay071("1");monthReport.setDay072("null;null;"+jobNums);}else{monthReport.setDay071("4");monthReport.setDay072(null);};
					}else{monthReport.setDay071("4");monthReport.setDay072(null);};
					if(currentDay>=8){
						if(writeList.get(7)){monthReport.setDay081("1");monthReport.setDay082("null;null;"+jobNums);}else{monthReport.setDay081("4");monthReport.setDay082(null);};
					}else{monthReport.setDay081("4");monthReport.setDay082(null);};
					if(currentDay>=9){
						if(writeList.get(8)){monthReport.setDay091("1");monthReport.setDay092("null;null;"+jobNums);}else{monthReport.setDay091("4");monthReport.setDay092(null);};
					}else{monthReport.setDay091("4");monthReport.setDay092(null);};
					if(currentDay>=10){
						if(writeList.get(9)){monthReport.setDay101("1");monthReport.setDay102("null;null;"+jobNums);}else{monthReport.setDay101("4");monthReport.setDay102(null);};
					}else{monthReport.setDay101("4");monthReport.setDay102(null);};
					if(currentDay>=11){
						if(writeList.get(10)){monthReport.setDay111("1");monthReport.setDay112("null;null;"+jobNums);}else{monthReport.setDay111("4");monthReport.setDay112(null);};
					}else{monthReport.setDay111("4");monthReport.setDay112(null);};
					if(currentDay>=12){
						if(writeList.get(11)){monthReport.setDay121("1");monthReport.setDay122("null;null;"+jobNums);}else{monthReport.setDay121("4");monthReport.setDay122(null);};
					}else{monthReport.setDay121("4");monthReport.setDay122(null);};
					if(currentDay>=13){
						if(writeList.get(12)){monthReport.setDay131("1");monthReport.setDay132("null;null;"+jobNums);}else{monthReport.setDay131("4");monthReport.setDay132(null);};
					}else{monthReport.setDay131("4");monthReport.setDay132(null);};
					if(currentDay>=14){
						if(writeList.get(13)){monthReport.setDay141("1");monthReport.setDay142("null;null;"+jobNums);}else{monthReport.setDay141("4");monthReport.setDay142(null);};
					}else{monthReport.setDay141("4");monthReport.setDay142(null);};
					if(currentDay>=15){
						if(writeList.get(14)){monthReport.setDay151("1");monthReport.setDay152("null;null;"+jobNums);}else{monthReport.setDay151("4");monthReport.setDay152(null);};
					}else{monthReport.setDay151("4");monthReport.setDay152(null);};
					if(currentDay>=16){
						if(writeList.get(15)){monthReport.setDay161("1");monthReport.setDay162("null;null;"+jobNums);}else{monthReport.setDay161("4");monthReport.setDay162(null);};
					}else{monthReport.setDay161("4");monthReport.setDay162(null);};
					if(currentDay>=17){
						if(writeList.get(16)){monthReport.setDay171("1");monthReport.setDay172("null;null;"+jobNums);}else{monthReport.setDay171("4");monthReport.setDay172(null);};
					}else{monthReport.setDay171("4");monthReport.setDay172(null);};
					if(currentDay>=18){
						if(writeList.get(17)){monthReport.setDay181("1");monthReport.setDay182("null;null;"+jobNums);}else{monthReport.setDay181("4");monthReport.setDay182(null);};
					}else{monthReport.setDay181("4");monthReport.setDay182(null);};
					if(currentDay>=19){
						if(writeList.get(18)){monthReport.setDay191("1");monthReport.setDay192("null;null;"+jobNums);}else{monthReport.setDay191("4");monthReport.setDay192(null);};
					}else{monthReport.setDay191("4");monthReport.setDay192(null);};
					if(currentDay>=20){
						if(writeList.get(19)){monthReport.setDay201("1");monthReport.setDay202("null;null;"+jobNums);}else{monthReport.setDay201("4");monthReport.setDay202(null);};
					}else{monthReport.setDay201("4");monthReport.setDay202(null);};
					if(currentDay>=21){
						if(writeList.get(20)){monthReport.setDay211("1");monthReport.setDay212("null;null;"+jobNums);}else{monthReport.setDay211("4");monthReport.setDay212(null);};
					}else{monthReport.setDay211("4");monthReport.setDay212(null);};
					if(currentDay>=22){
						if(writeList.get(21)){monthReport.setDay221("1");monthReport.setDay222("null;null;"+jobNums);}else{monthReport.setDay221("4");monthReport.setDay222(null);};
					}else{monthReport.setDay221("4");monthReport.setDay222(null);};
					if(currentDay>=23){
						if(writeList.get(22)){monthReport.setDay231("1");monthReport.setDay232("null;null;"+jobNums);}else{monthReport.setDay231("4");monthReport.setDay232(null);};
					}else{monthReport.setDay231("4");monthReport.setDay232(null);};
					if(currentDay>=24){
						if(writeList.get(23)){monthReport.setDay241("1");monthReport.setDay242("null;null;"+jobNums);}else{monthReport.setDay241("4");monthReport.setDay242(null);};
					}else{monthReport.setDay241("4");monthReport.setDay242(null);};
					if(currentDay>=25){
						if(writeList.get(24)){monthReport.setDay251("1");monthReport.setDay252("null;null;"+jobNums);}else{monthReport.setDay251("4");monthReport.setDay252(null);};
					}else{monthReport.setDay251("4");monthReport.setDay252(null);};
					if(currentDay>=26){
						if(writeList.get(25)){monthReport.setDay261("1");monthReport.setDay262("null;null;"+jobNums);}else{monthReport.setDay261("4");monthReport.setDay262(null);};
					}else{monthReport.setDay261("4");monthReport.setDay262(null);};
					if(currentDay>=27){
						if(writeList.get(26)){monthReport.setDay271("1");monthReport.setDay272("null;null;"+jobNums);}else{monthReport.setDay271("4");monthReport.setDay272(null);};
					}else{monthReport.setDay271("4");monthReport.setDay272(null);};
					if(currentDay>=28){
						if(writeList.get(27)){monthReport.setDay281("1");monthReport.setDay282("null;null;"+jobNums);}else{monthReport.setDay281("4");monthReport.setDay282(null);};
					}else{monthReport.setDay281("4");monthReport.setDay282(null);};
					if(currentDay>=29){
						if(writeList.get(28)){monthReport.setDay291("1");monthReport.setDay292("null;null;"+jobNums);}else{monthReport.setDay291("4");monthReport.setDay292(null);};
					}else{monthReport.setDay291("4");monthReport.setDay292(null);};
					if(currentDay>=30){
						if(writeList.get(29)){monthReport.setDay301("1");monthReport.setDay302("null;null;"+jobNums);}else{monthReport.setDay301("4");monthReport.setDay302(null);};
					}else{monthReport.setDay301("4");monthReport.setDay302(null);};
					if(currentDay>=31){
						if(writeList.get(30)){monthReport.setDay311("1");monthReport.setDay312("null;null;"+jobNums);}else{monthReport.setDay311("4");monthReport.setDay312(null);};
					}else{monthReport.setDay311("4");monthReport.setDay312(null);};
					//更新数据
					monthReportMapper.updateByPrimaryKey(monthReport);
				}
			}
			result = true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
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
	public static List<Boolean> write(String currentDate,int daySign,String type,String dateOfWeek,String weekOfMonth) {
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
				Map<String, Integer> Day = new HashMap<String, Integer>();
				Day.put("Mon", 0);
				Day.put("Tue", 1);
				Day.put("Wed", 2);
				Day.put("Thu", 3);
				Day.put("Fri", 4);
				Day.put("Sat", 5);
				Day.put("Sun", 6);
				
				Map<String, Integer> Week = new HashMap<String, Integer>();
				Week.put("First", 1);
				Week.put("Second", 2);
				Week.put("Third", 3);
				Week.put("Fourth", 4);
				Week.put("Last", 5);
				if(count == 6){
					Week.put("Last", 6);
				}
				
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
	
	@Override
    public List<Integer> selectAllAvaiableMonthFromDB() {
        return this.monthReportMapper.selectAllAvaiableMonthFromDB();
    }
}
