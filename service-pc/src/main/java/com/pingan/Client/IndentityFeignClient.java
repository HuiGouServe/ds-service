package com.pingan.Client;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IndentityFeignClient implements IndentityClient{

    @Override
    public R getAuthenticationStatus(Map<String, String> params) {
        return new Result().fail("出错了");
    }

    @Override
    public R addOrUpdate(Map<String, String> params) {
        return new Result().fail("出错了");
    }

    @Override
    public R revocation(Map<String, String> params) {
        return new Result().fail("出错了");
    }
}
