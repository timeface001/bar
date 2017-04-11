package com.fs.bar.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengsong on 2017/3/8.
 */
@Controller
@RequestMapping("test")
public class TestController {

    public static void main(String[] args) {
        T t = new TestController().new T();
        T t1 = new TestController().new T();

        t1.setName("1231");
        t.setName("123");


        Map map = new HashMap<>();
        map.put(t, "1");
        map.put(t1, "2");

        System.out.println(JSON.toJSONString(map));
    }


    class T {

        private String name;


        @Override
        public int hashCode() {
            if (name == null) {
                return 1;
            }

            return 0;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }

    }

}
