package com.fs.config.response;


import java.io.Serializable;

/**
 * 返回对象
 * Created by fengsong on 2017/3/9.
 */
public class BaseResponse<T> implements Serializable{
    private String code;
    private T data;
    private String msg;
    private boolean success;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponse successful(){
        this.code="000000";
        this.msg="操作成功";
        this.success=true;
        return this;
    }


    public BaseResponse successful(T data){
        this.code="000000";
        this.msg="操作成功";
        this.success=true;
        this.data=data;
        return this;
    }



    public BaseResponse failed(){
        this.code="-1";
        this.msg="操作成功";
        this.success=false;
        return this;
    }

    public BaseResponse failed(String i18nKey){
        this.code="-1";
        this.msg=i18nKey;
        this.success=false;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean exist) {
        this.success = exist;
    }

    public BaseResponse(String code, T data, String msg, boolean exist) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = exist;
    }

    public BaseResponse(){

    }

    public void clear(){
        this.code = null;
        this.data = null;
        this.msg = null;
        this.success = false;

    }

    public boolean isDataNull(){
        return this.data==null;
    }
}
