package com.pingan.Client;


import com.pingan.Object.R;
import com.pingan.Utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "service-ma",fallback = IndentityFeignClient.class)
@Component
public interface IndentityClient {


    @PostMapping("/indentity/getAuthenticationStatus")
    public R getAuthenticationStatus(@RequestBody Map<String, String> params);

    @PostMapping("/indentity/addOrUpdate")
    public R addOrUpdate(@RequestBody Map<String, String> params);

    @PostMapping("/indentity/revocation")
    public R revocation(@RequestBody Map<String,String> params);


}
