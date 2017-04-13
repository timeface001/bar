package com.fs.bar.service;

import com.fs.bar.entity.Bar;
import com.fs.bar.entity.BarComputer;

/**
 * Created by fengsong on 2017/4/13.
 */
public interface BarService {

    boolean saveBar(Bar bar) ;

    boolean saveBarComputer(BarComputer barComputer) ;

    

}
