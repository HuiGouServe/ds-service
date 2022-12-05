package com.pingan.Mapper;

import com.pingan.Object.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    User selectUserByAccountAndPassword(String userAccount,String password);

}
