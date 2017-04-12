package com.fs.bar.controller;

import com.fs.bar.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fengsong on 2017/3/8.
 */
@Controller
public class BarController {


    @Autowired
    private DictService dictService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model modelMap) {


        request.setAttribute("ss", "1231");
        modelMap.addAttribute("sss", "123");

        return "index";
    }


    @RequestMapping("toAdd")
    public String toAdd(HttpServletRequest request) {
        request.setAttribute("barOpts", dictService.barTypeOpts());
        return "addBar";
    }


}
