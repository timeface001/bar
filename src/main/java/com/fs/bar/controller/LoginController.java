package com.fs.bar.controller;

import com.fs.bar.entity.Member;
import com.fs.bar.exchange.request.LoginRequest;
import com.fs.bar.service.MemberService;
import com.fs.config.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by fengsong on 2017/3/11.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MemberService memberService;

    @GetMapping("/toLogin")
    public String index(HttpServletRequest request) {


        Object obj=request.getSession(true).getAttribute("member");

        if(obj==null){
            return "login";
        }else{
            return "redirect:/member/home";
        }

    }


    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/login")
    public @ResponseBody BaseResponse login(@Valid LoginRequest request, HttpServletRequest servletRequest) {


        BaseResponse<Member> response=memberService.login(request);
        if(!response.isDataNull()){
           servletRequest.getSession(true).setAttribute("member",response.getData());
        }

        return response;

    }

}
