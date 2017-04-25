package com.fs.util;/**
 * Created by fengsong on 2017/4/17.
 */


import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-17 11:01
 **/
public class LogUtils {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static  void runDeug(String msg){
        logger.debug(msg);
        logger.warn(msg);
        logger.info(msg);
        logger.error(msg);


        logger.trace("123123");

        System.out.println(getStack());;


    }

    public static String getStack()
    {

        StackTraceElement element= Arrays.asList(new Throwable().getStackTrace()).get(2);

        return element.getMethodName()+","+element.getLineNumber();
    }



}
