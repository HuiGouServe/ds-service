package com.pingan.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pingan.Object.User;
import com.pingan.Mapper.UserMapper;
import com.pingan.Service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pingan.Utils.JwtUtils;
import com.pingan.Utils.publicUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, Object> login(User user) {
        String jwtToken = JwtUtils.getJwtToken(user.getUserId());
        stringRedisTemplate.opsForValue().set(user.getUserId(), jwtToken, 1800, TimeUnit.SECONDS);
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("token", jwtToken);
        stringObjectMap.put("userInfo", user);
        return stringObjectMap;
    }

    @Override
    public int add(String userAccount,String userName,String userPhone,String userRank,String password) {
        String userId = new publicUtils().generationId("use");
        Long createTime = new Date().getTime();
        User user = new User();
        user.setPassword(password);
        user.setUserAccount(userAccount);
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPhone(userPhone);
        user.setUserRank(userRank);
        user.setCreateTime(createTime);
        return userMapper.insert(user);
    }

    @Override
    public IPage<User> selectByPage(int page, int pageSize, String userName, String userRank, String startTime, String endTime) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (userName != "") {
            wrapper.like("user_name", userName);
        }
        if (userName != "") {
            wrapper.like("user_rank", userRank);
        }
        if (startTime != "" && endTime != "") {
            wrapper.between("create_time", startTime, endTime);
        }
        IPage<User> userPage = new Page<>(page, pageSize);//参数一是当前页，参数二是每页个数
        return userMapper.selectPage(userPage, wrapper);
    }



}
