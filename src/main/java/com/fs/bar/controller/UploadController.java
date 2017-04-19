package com.fs.bar.controller;/**
 * Created by fengsong on 2017/4/14.
 */

import com.fs.config.response.BaseResponse;
import com.fs.config.response.ResponseUtils;
import com.fs.util.OSSKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-14 9:11
 **/
@Controller
public class UploadController {

    @RequestMapping("/uploadImg")
    public @ResponseBody BaseResponse<String> uploadImg(MultipartFile file)
    {
        if(file!=null){
            try {
                InputStream is=file.getInputStream();
                OSSKit.uploadImg(is,"/test");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            return ResponseUtils.generate(false);
        }
        return ResponseUtils.generate(true);
    }

}
