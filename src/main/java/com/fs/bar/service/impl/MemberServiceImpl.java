package com.fs.bar.service.impl;

import com.fs.bar.dao.MemberMapper;
import com.fs.bar.entity.Member;
import com.fs.bar.exchange.request.LoginRequest;
import com.fs.bar.service.MemberService;
import com.fs.config.response.BaseResponse;
import com.fs.config.response.ResponseUtils;
import com.fs.util.Base64Utils;
import com.fs.util.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengsong on 2017/3/9.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int save(Member member) {
        member.setPassword(Base64Utils.encodeData(member.getPassword()));
        return memberMapper.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse mobileExist(String mobile) {
        BaseResponse response = findMembeByMobile(mobile);
        if (response.getData() == null) {
            return new BaseResponse().successful();
        } else {
            return new BaseResponse().failed();
        }

    }

    @Override
    public BaseResponse findMembeByMobile(String mobile) {
        return new BaseResponse<Member>().successful(memberMapper.findOneByMap(GeneralUtils.generateMap("username", mobile)));

    }

    @Override
    public BaseResponse login(LoginRequest request) {
        Member member = memberMapper.findOneByMap(GeneralUtils.generateMap("username", request.getUsername(), "password", Base64Utils.encodeData(request.getPassword())));
        if (member != null) {
            return ResponseUtils.generate().successful(member);
        } else {

            return ResponseUtils.generate().failed("msg.login.failed");
        }

    }
}
