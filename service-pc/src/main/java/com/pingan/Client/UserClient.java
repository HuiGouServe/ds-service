package com.pingan.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient("service-ma")
@Component
public interface UserClient {


}
