package com.fs.util;/**
 * Created by fengsong on 2017/4/17.
 */


import org.slf4j.LoggerFactory;

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



    }

    /*StackTraceElement[] elements= new Throwable().getStackTrace();
        for(StackTraceElement element:elements){
        System.out.println(element.getClassName()+""+element.getMethodName()+""+element.getLineNumber());
    }*/

}
