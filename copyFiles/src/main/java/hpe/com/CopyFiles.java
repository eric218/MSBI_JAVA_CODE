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
    private static String oldPath1="D:/wangwei/PROD/LOGS/";
    private static String oldPath2="D:/wangwei/PROD/RELATION/";
    private static String oldPath3="D:/wangwei/PROD/SCHEDULE/";
    private static String newPath="D:/wangwei/PROD/BACK_UP/";
    private static String oldPath4="D:/wangwei/NON_PROD/LOGS/";
    private static String oldPath5="D:/wangwei/NON_PROD/RELATION/";
    private static String oldPath6="D:/wangwei/NON_PROD/SCHEDULE/";
    private static String newPath2="D:/wangwei/NON_PROD/BACK_UP/";

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

    public static void copyNonProd() throws IOException {
        //copy daily for nun
        File fromFile = new File(oldPath4+"daily.txt");
        File toFile = new File(newPath2+"newdaily.txt"+getDtate());
        copyFile(fromFile,toFile);
        //copy assoc
        fromFile = new File(oldPath5+"assoc.txt");
        toFile = new File(newPath2+"newassoc.txt"+getDtate());
        copyFile(fromFile,toFile);
        //copy schedules
        fromFile = new File(oldPath6+"client_schedules.txt");
        toFile = new File(newPath2+"newclient_schedules.txt"+getDtate());
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
