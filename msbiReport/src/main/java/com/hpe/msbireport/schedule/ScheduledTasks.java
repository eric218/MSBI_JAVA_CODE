package com.hpe.msbireport.schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hpe.msbireport.service.MonthReportService;
import com.hpe.msbireport.service.PoiExcelService;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 5/1/18
 * Description: WTF....
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    MonthReportService monthReportService;

    @Autowired
    PoiExcelService poiExcelService;

    @Value("${msbi.app.file.location.monthly}")
    private String monthlyReportPath;

    @Value("${msbi.app.file.location.daily}")
    private String dailyReportPath;
    
    @Value("${msbi.app.monthreport.currentdate}")
    private String currentDate;
    
    @Value("${msbi.app.monthreport.history}")
    private boolean hasHistory;
    
    @Value("${msbi.app.monthreport.insertSize}")
    private int insertSize;
    
    @Value("${msbi.app.copyfile.from}")
    private String oldPath;
    
    @Value("${msbi.app.copyfile.to}")
    private String newPath;

    //0 59 23 1 1/1 *  = every 1st day of each month at 23:59 PM
    @Scheduled(cron = "${msbi.app.scheduled.time.monthly}")
    public void autoGeneratePastMonthlyReport() throws Exception {
        log.info("@Scheduled Task: AutoGeneratePastMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        for (Integer monthIndicator : availableMonthLists) {
            this.poiExcelService.generateExcelFileToAFixedPath(monthIndicator, monthlyReportPath);
        }
        log.info("@Scheduled Task: AutoGeneratePastMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }

    // every day at 02:00 AM
    @Scheduled(cron = "${msbi.app.scheduled.time.daily}")
    public void autoDailyGenerateCurrentMonthlyReport() throws Exception {
        log.info("@Scheduled Task: AutoDailyGenerateCurrentMonthlyReport scheduled tasks start at:  {}", dateFormat.format(new Date()));
        List<Integer> availableMonthLists = this.monthReportService.selectAllAvaiableMonthFromDB();
        if (availableMonthLists != null) {
            this.poiExcelService.generateExcelFileToAFixedPath(availableMonthLists.get(0), dailyReportPath);
        }
        log.info("@Scheduled Task: AutoDailyGenerateCurrentMonthlyReport scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }
    
    // every day at 02:00 AM
    @Scheduled(cron = "${msbi.generate.scheduled.time.daily}")
    public void autoFormatMonthReportTable() throws Exception {
        log.info("@Scheduled Task: AutoFormatMonthReportTable scheduled tasks start at:  {}", dateFormat.format(new Date()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        if(null != currentDate && !"".equals(currentDate)){
        	endDate = format.parse(currentDate);
        }else{
        	endDate = monthReportService.getEndDate();
        }
        if(null != endDate){
    		String endDateS = format.format(endDate);
    		String [] endDateSN = endDateS.split("-");
    		
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(endDate);
    		cal.add(Calendar.DATE, -3);
    		String en = format.format(cal.getTime());
    		String[] ens = en.split("-");
    		
    		if(endDateSN[1].equals(ens[1])){
    			monthReportService.formatMonthReportTable(null, endDateS, hasHistory, insertSize);
    		}else{
    			monthReportService.formatMonthReportTable(en, endDateS, hasHistory, insertSize);
    		}
    	}
        log.info("@Scheduled Task: AutoFormatMonthReportTable scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }
    
    // every day at 02:00 AM
    @SuppressWarnings("resource")
	@Scheduled(cron = "${msbi.copy.scheduled.time.daily}")
    public void autoCopyFile() throws Exception {
        log.info("@Scheduled Task: AutoCopyFile scheduled tasks start at:  {}", dateFormat.format(new Date()));
    	
    	List<String> oldFileName = new ArrayList<String>();
    	List<String> newFileName = new ArrayList<String>();
    	Map<String,File> oldFileMap = new HashMap<String, File>();
    	//获得源文件
    	File oldFiles = new File(oldPath);
    	File[] oldArray = oldFiles.listFiles();
    	//把符合要求的文件保存为Map，key：文件名 value：File对象
    	for (File file : oldArray) {
    		if(file.getName().contains("schedules.txt")){
    			String a = file.getName().split("_")[2];
    			String keyTime = "";
    			if(a.length() == 7){
        			String y = a.substring(0, 4);
        			String m = "0"+a.substring(4, 5);
        			String d = a.substring(a.length()-2, a.length());
        			keyTime = y+m+d;
        		}else if(a.length() == 8){
        			keyTime = a;
        		}else if(a.length() == 6){
        			String y = a.substring(0, 4);
        			String m = "0"+a.substring(4, 5);
        			String d = "0"+a.substring(a.length()-1, a.length());
        			keyTime = y+m+d;
        		}
    			
    			if("" != keyTime){
    				oldFileMap.put(keyTime, file);
    				oldFileName.add(keyTime);
    			}
    		}
		}
    	
    	//获得已复制的文件名，用来对比
    	File newFiles = new File(newPath);
    	File[] newArray = newFiles.listFiles();
    	for (File file : newArray) {
    		String keyName = file.getName().split("_")[1].substring(0,8);
    		newFileName.add(keyName);
		}
    	
    	//对比源文件和已复制文件名，获得为复制的文件名
    	for (String newName : newFileName) {
			for (int i = 0; i < oldFileName.size(); i++) {
				if(newName.equals(oldFileName.get(i))){
					oldFileName.remove(i);
				}
			}
		}
    	
    	for (String name : oldFileName) {
    		FileChannel inputChannel = null;    
            FileChannel outputChannel = null;    
            inputChannel = new FileInputStream(oldFileMap.get(name)).getChannel();
            outputChannel = new FileOutputStream(new File(newPath+"schedule_"+name+".txt")).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            inputChannel.close();
            outputChannel.close();
		}
        log.info("@Scheduled Task: AutoCopyFile scheduled tasks finished at:  {}", dateFormat.format(new Date()));
    }
}
