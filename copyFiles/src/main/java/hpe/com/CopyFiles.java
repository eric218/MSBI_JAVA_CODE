package hpe.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-03-28
 * Time: 10:13 AM
 */
public class CopyFiles {
    private static String oldPath1="C:/wangwei/LOGS/";
    private static String oldPath2="C:/wangwei/RELATION/";
    private static String oldPath3="C:/wangwei/SCHEDULE/";
    private static String newPath="C:/wangwei/PROD/";
    public static void copy() throws IOException {
        //copy daily
        File fromFile = new File(oldPath1+"daily.txt");
        File toFile = new File(newPath+"newdaily.txt"+getDtate());
        copyFile(fromFile,toFile);
        //copy assoc
        fromFile = new File(oldPath2+"assoc.txt");
        toFile = new File(newPath+"newassoc.txt"+getDtate());
        copyFile(fromFile,toFile);
        //copy schedules
        fromFile = new File(oldPath3+"client_schedules.txt");
        toFile = new File(newPath+"newclient_schedules.txt"+getDtate());
        copyFile(fromFile,toFile);
    }

    public static void copyFile(File fromFile, File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        ins.close();
        out.close();
    }

    public static String getDtate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMdd");
        return sdf.format(d);
    }
}
