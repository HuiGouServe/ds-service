package com.pingan.Controller;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import com.pingan.Utils.downLoad;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;


@RestController
@RequestMapping("/file")
public class UploadController {


    @PostMapping("/uploadFile")
    public R uploadFile(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        String s = new downLoad().uploadFile(file);
        if (s.equals("false")) {
            return new Result().fail("上传出错了");
        } else {
            return new Result().success(s);
        }
    }

}
