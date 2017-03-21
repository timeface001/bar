package com.fs.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fengsong on 2017/3/8.
 */
@Controller
public class BarController {


    @RequestMapping("/")
    public String index(HttpServletRequest request, Model modelMap){


        request.setAttribute("ss","1231");
        modelMap.addAttribute("sss","123");

        return "index";
    }




}
