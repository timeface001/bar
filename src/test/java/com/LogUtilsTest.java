package com;
/**
 * Created by fengsong on 2017/4/17.
 */

import com.fs.util.LogUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-17 11:10
 **/
@SpringBootTest
public class LogUtilsTest {



    @Test
    public void testLog() throws Exception {


        LogUtils.runDeug("stacj");

    }
}
