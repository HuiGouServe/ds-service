package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pingan.Object.User;
import com.pingan.Object.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper extends BaseMapper<UserLogin> {
    UserLogin selectUserLoginByphone(String phone);

    UserLogin selectUserLoginByaccount(String account);

}
