package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatUtil {

    /**
     *时间格式化
     */
    public static String dateFormat(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 得到当前时间
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowDate(){
        return dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss");
    }
}
