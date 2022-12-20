package com.pingan.Client;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import feign.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class UserFeignClient implements UserClient{


    @Override
    public R getClientList(Map<String, Object> params) {
        return new Result().fail("出错了");
    }

    @Override
    public Response downloadClientList(Map<String, List<String>> params) {
        return null;
    }

    @Override
    public void upClientExcel(MultipartFile file) {}


}
