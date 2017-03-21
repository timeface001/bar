package com.fs.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;

/**
 * 将String进行base64编码解码，使用utf-8
 */
public class Base64Utils {

    private static final Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    /**
     * 对给定的字符串进行base64解码操作
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes("utf-8")), "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }

        return null;
    }

    /**
     * 对给定的字符串进行base64加密操作
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes("utf-8")), "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }

        return null;
    }

}