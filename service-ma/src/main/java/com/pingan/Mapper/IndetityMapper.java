package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.Object.Indentity;
import com.pingan.Object.User;
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
public interface IndetityMapper extends BaseMapper<Indentity> {
    Indentity SelectByUserId(String userId);
}
