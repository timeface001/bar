package com.fs.bar.service.impl;/**
 * Created by fengsong on 2017/4/13.
 */

import com.fs.bar.dao.BarMapper;
import com.fs.bar.entity.Bar;
import com.fs.bar.entity.BarComputer;
import com.fs.bar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-13 14:15
 **/
@Service
public class BarServiceImpl implements BarService {

    @Autowired
    private BarMapper barMapper;

    @Override
    public boolean saveBar(Bar bar) throws Exception{
        return barMapper.save(bar)>0;
    }

    @Override
    public boolean saveBarComputer(BarComputer barComputer) {
        return false;
    }
}
