package com.pingan.Service.impl;

import com.pingan.Mapper.UserDetailMapper;
import com.pingan.Mapper.UserLoginMapper;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pingan.Service.UserService;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public UserDetail findUserDetailById(String id) {
        return userDetailMapper.selectById(id);
    }

    @Override
    public int insertUserLogin(UserLogin userLogin, String string) {
        if (string == "phoneRegister") {
            UserLogin phone = userLoginMapper.selectUserLoginByphone(userLogin.getPhone());
            if (phone == null) {
                return userLoginMapper.insert(userLogin);
            } else {
                return 0;
            }
        } else {
            UserLogin account = userLoginMapper.selectUserLoginByaccount(userLogin.getUserAccount());
            if (account == null) {
                String password = userLogin.getPassword();
                try {
                    MessageDigest md5 = MessageDigest.getInstance("md5");
                    byte[] digest = md5.digest(password.getBytes("utf-8"));
                    userLogin.setPassword(digest.toString());

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return userLoginMapper.insert(userLogin);
            } else {
                return 0;
            }
        }
    }

    @Override
    public UserLogin selectUserLoginByAccount(String account) {
        return userLoginMapper.selectUserLoginByaccount(account);
    }

    @Override
    public UserLogin selectUserLoginByPhone(String phone) {
        return userLoginMapper.selectUserLoginByphone(phone);
    }

    @Override
    public int delectUserLogin(String id) {
        return userLoginMapper.deleteById(id);
    }

    @Override
    public UserLogin selectUserLogin(String id) {
        return selectUserLogin(id);
    }
}
