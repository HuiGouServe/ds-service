package com.pingan.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns   // 拦截所有请求
                ("/user/phoneLogin",
                        "/user/getnum",
                        "/",
                        "/eureka",
                        "/user/getCode",
                        "/user/phoneRegister",
//                        "/user/accountRegister",
//                        "/user/phoneVerify",
//                        "/user/accountLogin",
//                        "/user/getUserSig",
                        "/product/getProductDetail");//可以通过请
    }
}