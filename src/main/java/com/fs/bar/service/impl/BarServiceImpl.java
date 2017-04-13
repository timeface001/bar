package com.fs.bar.service.impl;/**
 * Created by fengsong on 2017/4/13.
 */

import com.fs.bar.entity.Bar;
import com.fs.bar.entity.BarComputer;
import com.fs.bar.service.BarService;
import org.springframework.stereotype.Service;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-13 14:15
 **/
@Service
public class BarServiceImpl implements BarService {
    @Override
    public boolean saveBar(Bar bar) {
        return false;
    }

    @Override
    public boolean saveBarComputer(BarComputer barComputer) {
        return false;
    }
}
