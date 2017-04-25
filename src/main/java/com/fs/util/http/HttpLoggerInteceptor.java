package com.fs.util.http;
/**
 * Created by fengsong on 2017/4/21.
 */

import com.fs.util.LogUtils;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-21 17:03
 **/
public class HttpLoggerInteceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();

        LogUtils.runDeug("HTTP测试接口");
        return null;
    }
}
