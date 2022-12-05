package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.Object.ProductPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductPriceMapper extends BaseMapper<ProductPrice> {
    List<ProductPrice> selectByProducId(String id);

}
