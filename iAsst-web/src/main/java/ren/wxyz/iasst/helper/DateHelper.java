/**
 * Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 * <p>
 * This program can be distributed under the terms of the GNU GPL Version 2.
 * See the file LICENSE.
 */
package ren.wxyz.iasst.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期帮助类
 *
 * @auther wxyz 2016-08-18_22:10
 * @since 0.1
 */
public interface DateHelper {

    /**
     * 默认日期时间格式
     */
    String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化日期时间，默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date 给定日期时间
     * @return 格式化后的日期时间字符串
     */
    static String format(Date date) {
        return format(date, DEFAULT_FORMAT);
    }

    /**
     * 格式化日期时间
     *
     * @param date 给定的日期时间
     * @param format 将要格式化的格式
     *
     * @see SimpleDateFormat
     *
     * @return 日期时间字符串
     */
    static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将给定字符串通过默认格式解析成日期时间，默认格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param source 日期时间字符串
     * @param defaultDate  解析失败后，返回的默认日期时间
     * @return 日期时间
     */
    static Date parse(String source, Date defaultDate) {
        try {
            return parse(source);
        }
        catch (Exception e) {
            return defaultDate;
        }
    }

    /**
     * 将给定字符串通过默认格式解析成日期时间，默认格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param source 日期时间字符串
     * @return 日期时间
     * @exception RuntimeException 字符串无法匹配格式时，将抛出该异常
     */
    static Date parse(String source) {
        return parse(source, DEFAULT_FORMAT);
    }

    /**
     * 将给定字符串通过给定格式解析成日期时间
     *
     * @param source 日期时间字符串
     * @param format 日期时间格式
     * @return 日期时间
     * @exception RuntimeException 字符串无法匹配格式时，将抛出该异常
     */
    static Date parse(String source, String format) {
        try {
            return new SimpleDateFormat(format).parse(source);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
