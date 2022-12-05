package com.pingan.Client;

import com.pingan.Object.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "service-pc",fallback = UserFeignClient.class)
@Component
public interface UserClient {
    @PostMapping("/user/getCode")
    public R getCode(@RequestBody Map<String, String> params);
}
