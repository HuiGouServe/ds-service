package com.pingan.Service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.converters.longconverter.LongStringConverter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pingan.Listener.UserExcelListener;
import com.pingan.Mapper.UserDetailMapper;
import com.pingan.Mapper.UserLoginMapper;
import com.pingan.Mapper.UserMapper;
import com.pingan.Object.User;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;
import com.pingan.Utils.publicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pingan.Service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
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
    public void upExcel(MultipartFile file) {
        InputStream f = null;
        try {
            f = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserExcelListener userExcelListener = new UserExcelListener();
        EasyExcel.read(f, User.class, userExcelListener).sheet().doRead();
        List<User> data = userExcelListener.getData();
        UserLogin userLogin=new UserLogin();
        UserDetail userDetail=new UserDetail();
        List<UserLogin> users = userLoginMapper.selectList(null);
        for(User i :data) {
            Boolean bool = true;
            for (UserLogin j : users) {
                if (i.getUserAccount().equals(j.getUserAccount())) {
                    bool = false;
                }
            }
            if (bool) {
                i.setUserId(new publicUtils().generationId("use"));
                userLogin.setPhone(i.getPhone());
                userLogin.setIndentityStatus(i.getIndentityStatus());
                userLogin.setShopStatus(i.getShopStatus());
                userLogin.setRegistrationTime(Long.toString(new Date().getTime()));
                userLogin.setUserId(i.getUserId());
                userLogin.setPassword(i.getPassword());
                userLogin.setUserAccount(i.getUserAccount());
                userLogin.setEmail(i.getEmail());
                userLogin.setUserName(i.getUserName());
                userLoginMapper.insert(userLogin);
                userDetail.setLikes(i.getLikes());
                userDetail.setUserId(i.getUserId());
                userDetail.setAge(i.getAge());
                userDetail.setContactAddress(i.getContactAddress());
                userDetail.setIdentityCard(i.getIdentityCard());
                userDetail.setNativePlace(i.getNativePlace());
                userDetail.setSex(i.getSex());
                userDetail.setSignature(i.getSignature());
                userDetail.setTag(i.getTag());
                userDetailMapper.insert(userDetail);
            }
        }
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
      return userMapper.findPage(new Page<>(page, pageSize), loginWrapper);
    }

    @Override
    public void download(Map<String, List<String>> params, HttpServletResponse response) throws IOException {
        List<String> userIds = params.get("userIds");
        List<User> users= new ArrayList<User>();
        String str="";

        for (int i = 0; i < userIds.size(); i++) {
            str+= userIds.get(i)+",";
        }
        str ="\""+ str.substring(0,str.length()-1)+"\"";
        System.out.println(str+"33333333333333333333");
        users = userIds.size() == 0? userMapper.downAll():userMapper.downByIds(str);;
        new publicUtils().exportExcel(users,User.class,response);
    }


}
