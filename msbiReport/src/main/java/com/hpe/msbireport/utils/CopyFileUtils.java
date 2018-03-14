package com.hpe.msbireport.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyFileUtils {
	//type 不同的表,PRO 代表main表;NONPROD 代表main_non_prod
	public void copy(String oldPath,String newPath) throws Exception{
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
            //读取
			BufferedReader bf = new BufferedReader(new FileReader(oldFileMap.get(name)));
			//写入
			FileWriter fw = new FileWriter(newPath+"schedule_"+name+".txt");
			//每行数据
			String s = null;
			//打印行号
			Integer i = 1;
			//每行数据-格式化后
			String news = "";
			//换行符
			String str = System.getProperty("line.separator");
			while ((s = bf.readLine()) != null) {
				Pattern p = Pattern.compile("\"(.*?)\"");
				Matcher m = p.matcher(s);
				news = s;
				//判断是否找到双引号
				while (m.find()) {
					//只处理逗号
					if (m.group().indexOf(",") != -1) {
						m.group().replace(",", ";");
						String f = s.substring(0, m.start());
						String e = s.substring(m.end(), s.length());
						news = f + m.group().replace(",", ";") + e;
					}
				}
				i++;
				fw.write(news);
				fw.write(str);
			}
			bf.close();
			fw.close();
		}
	}
}
