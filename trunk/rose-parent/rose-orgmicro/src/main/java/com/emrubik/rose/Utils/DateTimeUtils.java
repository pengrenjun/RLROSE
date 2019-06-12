package com.emrubik.rose.Utils;

import org.assertj.core.util.DateUtil;

import java.util.Date;

/**
 * @Description 日期工具类
 * @Date 2019/3/20 0020 上午 11:07
 * @Created by Pengrenjun
 */

public class DateTimeUtils {

    /**
     * 将系统当前日期转换为字符串
     * @return
     */
    public static String currentDateTostr(){
        return DateUtil.formatAsDatetime(new Date(System.currentTimeMillis()));
    }
}
