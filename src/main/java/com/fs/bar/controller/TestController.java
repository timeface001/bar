package com.fs.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengsong on 2017/3/8.
 */
@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping("/demo")
    public String  test()
    {
        ModelAndView view=new ModelAndView("templates/index");


        return "index";
    }


}
