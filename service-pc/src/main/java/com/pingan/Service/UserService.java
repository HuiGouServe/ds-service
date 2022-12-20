package com.pingan.Service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pingan.Object.User;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    UserDetail findUserDetailById(String id);

    int insertUserLogin(UserLogin userLogin, String string);

    UserLogin selectUserLoginByAccount(String account);

    UserLogin selectUserLoginByPhone(String phone);

    int delectUserLogin(String id);
    void upExcel(MultipartFile file);
    UserLogin selectUserLogin(String id);
    IPage<User> getAll(Map<String, String> params);
    void download(Map<String, List<String>> params, HttpServletResponse response) throws IOException;
}
