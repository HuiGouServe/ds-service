package com.pingan.handler;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {

        // 地址过滤
//        String uri = httpServletRequest.getRequestURI() ;
//        if (uri.contains("/login")){
//            return true ;
//        }

//        String token = httpServletRequest.getHeader("token");
//        if(!StringUtils.hasText(token)){
//            throw new Exception("token不能为空");  // new Result().fail("token不能为空");
//        }
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
////        System.out.println(claimsJws);
//        String id = (String) claimsJws.getBody().get("id");
//        String s = stringRedisTemplate.opsForValue().get(id);
////        System.out.println(id);
////        System.out.println(s);
//        if(!StringUtils.hasText(s)){
//            throw new Exception("token失效或不存在");
//        }else {
//            stringRedisTemplate.opsForValue().set(id, token, 1800, TimeUnit.SECONDS);
//        }
        return true;
    }
}