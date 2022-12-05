package com.pingan.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pingan.Object.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
public interface UserService extends IService<User> {
  Map<String, Object> login(User user);
  int add(String userAccount,String userName,String userPhone,String userRank,String password);
  IPage<User> selectByPage(int page, int pageSize,String userName,String userRank,String startTime,String endTime);

}
