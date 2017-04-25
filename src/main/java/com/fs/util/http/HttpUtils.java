package com.fs.util.http;

/**
 * Created by fengsong on 2017/4/21.
 */
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author fengsong
 * @description:Http 请求
 * @time 2017-04-21 11:26
 **/
public class HttpUtils {

    private static final OkHttpClient client=new OkHttpClient();

    static {
        client.interceptors().add(new HttpLoggerInteceptor());
    }

    public static String doPost(){

        Request request=new Request.Builder().url("http://www.cnblogs.com/jiuyi/p/6105049.html").build();
        try {
            Response response= client.newCall(request).execute();


            System.out.println(response.code());
            System.out.println(JSON.toJSONString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }

    public static void main(String[] args) {

        doPost();
    }


}
