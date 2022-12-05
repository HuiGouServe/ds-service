package com.pingan.Controller;


import com.pingan.Client.IndentityClient;
import com.pingan.Object.R;
import com.pingan.Utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "测试接口", tags = "用户相关的接口")
@RestController
@RequestMapping("/indentity")
public class IndentController {

    @Autowired
    private IndentityClient indentityClient;

    @PostMapping("/getAuthenticationStatus")
    public R getAuthenticationStatus(@RequestBody Map<String, String> params) {
        return indentityClient.getAuthenticationStatus(params);
    }

    @PostMapping("/addOrUpdate")
    public R addOrUpdate(@RequestBody Map<String, String> params){
        return indentityClient.addOrUpdate(params);
    };

    @PostMapping("/revocation")
    public R revocation(@RequestBody Map<String,String> params){
        return indentityClient.revocation(params);
    }

}
