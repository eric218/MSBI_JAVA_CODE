package com.hpe.msbireport.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyFileUtils {
	//reportType:A,prod;B,non prod
	public static void copy(String oldPath,String newPath) throws Exception{
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
			String serverName = "";
			List<String> list = new ArrayList<String>();
			String serverSignA = "Output for command 'SELECT' issued against server";
			String serverSingC = "server";
			String serverSignB = "follows:";
			String serverSignD = "command 'SELECT'".toUpperCase();
			String serverSignE = "against server".toUpperCase();
			String serverSignF = "command SELECT".toUpperCase();



			while ((s = bf.readLine()) != null) {

				if(s.contains(serverSignA) && s.contains(serverSignB)){
					serverName = s.substring(s.indexOf(serverSingC)+7, s.indexOf(serverSignB)-1);
				}


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

				//VM特殊行
				if(s.contains("VM=")){
					String subStr = s.substring(s.indexOf("VM=")+3, s.length());
					String newLineFir = s.substring(0, s.indexOf("VM=")+3);
					String newLineSec = subStr.substring(0, subStr.indexOf("\"")).replace(",", ";");
					String newLineTr = subStr.substring(subStr.indexOf("\""), subStr.length());
					news = newLineFir+newLineSec+newLineTr;
				}

				//去除多余数据，
				if(!news.toUpperCase().contains(serverSignD) && !news.toUpperCase().contains(serverSignE) && !news.toUpperCase().contains(serverSignF)){
					String newline = news.substring(news.indexOf(",")+1,news.length());
					//并比较数据库中scheduleName，只保存数据库中存在的schedule
					//String scheduleName = newline.substring(0,newline.indexOf(","));
//					if(null != map.get(scheduleName)){
//						list.add(i-1,serverName+","+news);
//						i++;
//					}
					if(true){
						list.add(i-1,serverName+","+news);
						i++;
					}
				}
			}

			List<String> newList = new ArrayList<String>(new TreeSet<String>(list));
			for (String string : newList) {
				fw.write(string);
				fw.write(str);
			}
			bf.close();
			fw.close();
		}
	}

	public static void main(String[] args) {
		try {
			/*String a = "server";
			String c = "follows";
			String b = "ANR1687I Output for command 'SELECT' issued against server RSTGBUR1 follows:";
			System.out.println(b.substring(b.indexOf(a)+7, b.indexOf(c)-1));*/

			Map<String, String> map = new HashMap<String, String>();
			map.put("RSTGVCDB2_WEEKLY", "RSTGVCDB2_WEEKLY");
			map.put("RQACBMR11_DAILY_INCR", "RQACBMR11_DAILY_INCR");
			map.put("DCAESXDP201_VM_BACKUP", "DCAESXDP201_VM_BACKUP");


			copy("c:/MSBI/201803log/","c:/MSBI/201803log/schedule/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
