package com.fs.bar.service;

import com.fs.bar.entity.Member;
import com.fs.bar.exchange.request.LoginRequest;
import com.fs.config.response.BaseResponse;

/**
 * Created by fengsong on 2017/3/9.
 */
public interface MemberService {

     int save(Member member);

     BaseResponse mobileExist(String mobile);

     BaseResponse findMembeByMobile(String mobile);

     BaseResponse login(LoginRequest request);



}
