package com.pingan.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pingan.Mapper.UserDetailMapper;
import com.pingan.Mapper.UserLoginMapper;
import com.pingan.Mapper.UserMapper;
import com.pingan.Object.User;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pingan.Service.UserService;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private UserMapper userMapper;

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

    @Override
    public IPage<User> getAll(Map<String, String> params) {
        Integer page = Integer.parseInt(params.get("page"));
        Integer pageSize = Integer.parseInt(params.get("pageSize"));
        String userName = params.get("userName");
        String userAccount = params.get("userAccount");
        String phone = params.get("phone");
        String shopStatus = params.get("shopStatus");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");

        QueryWrapper<User> loginWrapper = new QueryWrapper<>();

        if (userName != "") {
            loginWrapper.like("user_name", userName);
        }
        if (userAccount != "") {
            loginWrapper.like("user_account", userAccount);
        }
        if (phone != "") {
            loginWrapper.like("phone", phone);
        }
        if (shopStatus != "") {
            loginWrapper.like("shop_status", shopStatus);
        }
        if (startTime != "" && endTime != "") {
            loginWrapper.between("registration_time", startTime, endTime);
        }
        Page<User> userPage = new Page<>(page, pageSize);
      return userMapper.findPage(userPage, loginWrapper);
    }


}
