package com.pingan.Service;


import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;

public interface UserService {
    UserDetail findUserDetailById(String id);

    int insertUserLogin(UserLogin userLogin, String string);

    UserLogin selectUserLoginByAccount(String account);

    UserLogin selectUserLoginByPhone(String phone);

    int delectUserLogin(String id);

    UserLogin selectUserLogin(String id);
}
