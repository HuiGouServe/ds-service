package com.pingan.Service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pingan.Object.User;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDetail findUserDetailById(String id);

    int insertUserLogin(UserLogin userLogin, String string);

    UserLogin selectUserLoginByAccount(String account);

    UserLogin selectUserLoginByPhone(String phone);

    int delectUserLogin(String id);

    UserLogin selectUserLogin(String id);
    IPage<User> getAll(Map<String, String> params);
}
