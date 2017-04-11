package com.fs.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fengsong on 2017/3/14.
 */
public  class GeneralUtils {

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

    /**
     * 判断List是否不为空
     * @param list
     * @return
     */
    public static boolean isNotNullOrEmpty(List<?> list){
        return  !isNullOrEmpty(list);
    }

    /**
     *  生成Map数据
     * @param keyValues
     */
    public static Map<String,Object> generateMap(Object...keyValues) {

        if(keyValues==null||keyValues.length%2!=0){
            return new ConcurrentHashMap(0);
        }else{
            Map<String,Object> map=new ConcurrentHashMap(keyValues.length/2);

            for(int i=0;i<keyValues.length;i++){
                map.put(String.valueOf(keyValues[i]),keyValues[++i]);
            }

            return map;
        }
    }

    public static void main(String[] args) {
        Map<Object,Object> map=new HashMap();

        System.out.println(JSON.toJSONString(map));

        Object p=new GeneralUtils().new P();
        Object q=new GeneralUtils().new Q();



        map.put(p,"");


        map.put(q,"123");

        System.out.println("a安徽省合肥市"+Objects.toString(null,""));



    }

     class P{
        @Override
        public int hashCode() {
            return 0;
        }
    }

    class Q{
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
