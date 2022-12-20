package com.pingan.Controller;

import com.pingan.Object.R;
import com.pingan.Utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.pingan.Utils.downLoad;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/file")
public class UploadController {

    @PostMapping("/uploadFile")
    public R uploadFile1(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        String s = new downLoad().uploadFile(file);
        if (s.equals("false")) {
            return new Result().fail("上传出错了");
        } else {
            return new Result().success(s);
        }
    }

}
