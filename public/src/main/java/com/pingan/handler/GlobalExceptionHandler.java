package com.pingan.handler;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace(); //tokenExceptions
        String ex = e.toString().split(": ")[1];
        if ("token不能为空".equals(ex) || "token失效或不存在".equals(ex)) {
            return new Result().tokenExceptions(ex);
        } else {
            return new Result().globalExceptions("服务器异常");
        }
    }
}
