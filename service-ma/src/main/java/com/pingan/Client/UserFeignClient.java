package com.pingan.Client;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserFeignClient implements UserClient{
    @Override
    public R getList(Map<String, String> params) {
        return new Result().fail("出错了");
    }
}
