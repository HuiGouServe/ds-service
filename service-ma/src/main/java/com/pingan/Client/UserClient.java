package com.pingan.Client;

import com.pingan.Object.R;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@FeignClient(name = "service-pc",fallback = UserFeignClient.class)
@Component
public interface UserClient {

    @PostMapping("/user/getClientList")
    public R getClientList(@RequestBody Map<String, Object> params);

    @PostMapping("/user/downloadClientList")
    feign.Response downloadClientList(@RequestBody Map<String, List<String>> params);

    @PostMapping(value = "/user/upExcel",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upClientExcel(@RequestPart("file") MultipartFile file);
}
