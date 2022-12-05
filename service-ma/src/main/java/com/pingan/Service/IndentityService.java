package com.pingan.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pingan.Object.Indentity;
import com.pingan.Object.User;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
public interface IndentityService extends IService<Indentity> {
  String addOrUpdate(Indentity indentity);


}
