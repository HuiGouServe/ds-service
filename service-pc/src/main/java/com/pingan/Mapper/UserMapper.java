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

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    IPage<User> findPage(IPage<User> page, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);
    List<User> downByIds(String userIds);
    List<User> downAll();

}
