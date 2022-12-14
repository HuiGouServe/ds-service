package com.pingan.handler;




import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns   // 拦截所有请求
                ("/user/phoneLogin",
                        "/user/getnum",
                        "/",
                        "/user/getCode",
                        "/user/phoneRegister",
//                        "/user/accountRegister",
//                        "/user/phoneVerify",
//                        "/user/accountLogin",
//                        "/user/getUserSig",
                        "/imgs/**",
                        "/product/getProductDetail"
                );//可以通过请求
    }

}