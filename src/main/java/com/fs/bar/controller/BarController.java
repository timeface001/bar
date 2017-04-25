package com.fs.bar.controller;

import com.fs.bar.exchange.request.BarSaveRequest;
import com.fs.bar.service.BarService;
import com.fs.bar.service.DictService;
import com.fs.util.LogUtils;
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

    @Autowired
    private BarService barService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model modelMap) {


        LogUtils.runDeug("test");

        request.setAttribute("ss", "1231");
        modelMap.addAttribute("sss", "123");

        return "index";
    }


    @RequestMapping("toAdd")
    public String toAdd(HttpServletRequest request) {
        request.setAttribute("barOpts", dictService.barTypeOpts());

        return "addBar";
    }

    /**
     * 网吧新增
     * @return
     */
    @RequestMapping("save")
    public String save(BarSaveRequest request)
    {

        try {
            barService.saveBar(request.generateBar());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/toAdd";
    }


}
