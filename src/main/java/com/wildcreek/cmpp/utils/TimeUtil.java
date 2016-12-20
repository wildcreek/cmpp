package com.wildcreek.cmpp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/9
 * Time: 18:03
 */
public class TimeUtil {

    public static String genTimestampMdHms() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        return format.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(genTimestampMdHms());
    }
}
