package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.Object.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper extends BaseMapper<UserLogin> {
    UserLogin selectUserLoginByphone(String phone);

    UserLogin selectUserLoginByaccount(String account);


}
