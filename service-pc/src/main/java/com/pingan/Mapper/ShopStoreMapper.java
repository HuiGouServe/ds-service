package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.Object.ShopStore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopStoreMapper extends BaseMapper<ShopStore> {
    ShopStore selectByUserId(String userId);

}
