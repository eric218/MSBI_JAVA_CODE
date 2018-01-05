package com.hpe.msbireport;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hpe.msbireport.domain.RunTimeByDate;
import com.hpe.msbireport.mapper.BackupLogMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsbireportApplicationTests {
	@Autowired
	private BackupLogMapper backupLogMapper;
	

	@Test
	public void contextLoads() {
		
		
		 
		String aString = num("DCBPP703_LOCAL_FS_DAILY_INCR","29");
		String bString = num("DCBPPD704_SQLLOG_BACKUP","20");
		System.out.println(aString+"---"+bString);
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
