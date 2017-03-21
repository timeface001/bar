package com.fs.config.response;

/**
 * Created by fengsong on 2017/3/9.
 */
public class ResponseUtils {

    private static BaseResponse baseResponse=new BaseResponse();


    public static BaseResponse generate(){
        baseResponse.clear();
        return baseResponse;
    }

    public static BaseResponse generate(boolean bol){
        baseResponse.clear();
        baseResponse.setSuccess(bol);
        return baseResponse;
    }


}
