package com.fs.bar.controller;

import com.fs.bar.entity.Member;
import com.fs.bar.service.MemberService;
import com.fs.config.response.BaseResponse;
import com.fs.config.response.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by fengsong on 2017/3/9.
 */
@Controller
@RequestMapping("member")
public class MemberController {

    @Resource
    private MemberService memberService;


    @RequestMapping("/save")
    public @ResponseBody BaseResponse save(@Valid Member member){

        memberService.save(member);
        return ResponseUtils.generate().successful();
    }

    @GetMapping("/mobileExist")
    public @ResponseBody BaseResponse mobileExist(String mobile){



        return memberService.mobileExist(mobile);
    }

    @RequestMapping("home")
    public String home()
    {
        return "/member/index";
    }


}
