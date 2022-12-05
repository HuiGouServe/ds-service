package com.pingan.Utils;

import com.alibaba.excel.util.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class downLoad {


    public String getPath() {
        String str = System.getProperty("user.dir");
        String[] strs = str.split("\\\\");
        return strs[0] + "/" + strs[1];
    }


    public String uploadFile(MultipartFile uploadFile) throws FileNotFoundException {
//        System.out.println(uploadFile + "111111111111111");
        String fileName = uploadFile.getOriginalFilename();
//        System.out.println(fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println(suffixName);
        fileName = UUID.randomUUID() + suffixName;

        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String filePath = "d:/file/" + format + "/";
        File file = new File(filePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            uploadFile.transferTo(new File(filePath + fileName));
            return format + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }


    public ResponseEntity<byte[]> downFile(HttpServletRequest request, @RequestBody String id) throws IOException {
        File file = new File(getPath()+id);
        String filename = getFilename(request, "word");
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //使用springmvc框架的ResponseEntity对象封装返回数据
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    /**
     * 根据浏览器的不同进行编码设置
     *
     * @param request  请求对象
     * @param filename 需要转码的文件名
     * @return 返回编码后的文件名
     * @throws IOException
     */
    public String getFilename(HttpServletRequest request, String filename) throws IOException {

        //IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        //获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为utf-8编码显示
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其他浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }
}
