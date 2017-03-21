package com.fs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengsong on 2017/3/14.
 */
public class GeneralUtils {

    /**
     * 判断List是否为空或者长度为0
     *
     * @param list
     * @return
     * @author fs
     */
    public static boolean isNullOrEmpty(List<?> list){
        return  list==null||list.isEmpty();
    }

    public static boolean isNotNullOrEmpty(List<?> list){
        return  !isNullOrEmpty(list);
    }

    /**
     *  生成Map数据
     * @param keyValues
     */
    public static Map<String,Object> generateMap(Object...keyValues) {

        if(keyValues==null||keyValues.length%2!=0){
            return new HashMap(0);
        }else{
            Map<String,Object> map=new HashMap(keyValues.length/2);

            for(int i=0;i<keyValues.length;i++){
                map.put(String.valueOf(keyValues[i]),keyValues[++i]);
            }
            return map;
        }
    }
}
