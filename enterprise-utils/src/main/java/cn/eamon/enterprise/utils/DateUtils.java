package cn.eamon.enterprise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 10:57
 */
public class DateUtils {

    /**
     * 日志转换成字符串
     */
    public static String date2String(Date date, String pattern) {
        SimpleDateFormat spf = new SimpleDateFormat(pattern);
        return spf.format(date);
    }

    /**
     * 字符串转换成日期
     */
    public static Date string2Date(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(str);
    }
}
