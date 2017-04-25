package com.fs.config.interceptor;
/**
 * Created by fengsong on 2017/3/21.
 */

import com.fs.config.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-03-21 11:35
 **/
@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "com.fs.bar.controller")
public class ControllerAdvice implements ResponseBodyAdvice<BaseResponse> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public BaseResponse beforeBodyWrite(BaseResponse baseResponse, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(baseResponse.getMsg()!=null&&baseResponse.getMsg().startsWith("msg")){
            String msg=messageSource.getMessage(baseResponse.getMsg(),null, LocaleContextHolder.getLocale());
            if(!org.springframework.util.StringUtils.isEmpty(msg)){
                baseResponse.setMsg(msg);
            }
        }

        return baseResponse;
    }

    @ExceptionHandler()
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                Exception e, HttpServletResponse response) throws Exception
    {

        response.sendRedirect("/error/500.html");

        return "";
    }

}
