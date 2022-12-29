package com.course.server.util;

import com.course.server.exception.ValidatorException;
import org.springframework.util.StringUtils;

public class ValidatorUtil {
    /**
     * 空校验
     */
    public static void require(String str,String fileName)  {
        if(StringUtils.isEmpty(str)){
            throw new ValidatorException(fileName+"不能为空");
        }
    }
    /**
     * 长度校验
     */
    public static void length(String str,String fileName,int min,int max) {
        int length = 0;
        if(!StringUtils.isEmpty(str)){
            length = str.length();
        }
        if(length<min||length>max){
            throw new ValidatorException(fileName+"长度"+min+"~"+max+"位");
        }
    }
}
