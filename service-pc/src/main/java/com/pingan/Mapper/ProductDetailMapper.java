package com.pingan.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.Object.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDetailMapper extends BaseMapper<ProductDetail> {
    ProductDetail selectAllByProductDetail(String id);
}
