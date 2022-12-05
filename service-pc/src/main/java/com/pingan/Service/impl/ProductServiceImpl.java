package com.pingan.Service.impl;

import com.pingan.Mapper.ProductDetailMapper;
import com.pingan.Mapper.ProductPriceMapper;
import com.pingan.Object.ProductDetail;
import com.pingan.Object.ProductPrice;
import com.pingan.Service.ProductService;
import com.pingan.Utils.publicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Override
    public ProductDetail findProductDetailById(String id) {
        List<ProductPrice> productPrices = productPriceMapper.selectByProducId(id);
        ProductDetail productDetail1 = productDetailMapper.selectById(id);
        productDetail1.setProductPrice(productPrices);
        return productDetail1;
    }

    @Override
    public int insertProductDetail(ProductDetail productDetail) {
        String productId = productDetail.getProductId();
        List<ProductPrice> productPriceList = productDetail.getProductPrice();
        if (productId == null) {   //新增
            String id = new publicUtils().generationId("pro");
            productDetail.setUpdateTime(Long.toString(new Date().getTime()));
            productDetail.setCreateTime(Long.toString(new Date().getTime()));
            productDetail.setProductId(id);
            productDetailMapper.insert(productDetail);
            for (ProductPrice i : productPriceList) {
                i.setProductId(id);
                productPriceMapper.insert(i);
            }
        } else {  //修改
            productDetail.setUpdateTime(Long.toString(new Date().getTime()));
            productDetailMapper.insert(productDetail);
            for (ProductPrice i : productPriceList) {
                productPriceMapper.insert(i);
            }
        }
        return 0;
    }

    @Override
    public int deleteProductDetail(String id) {
        return productDetailMapper.deleteById(id);
    }

    @Override
    public List<ProductDetail> selectProduct(Map<String, String> obj) {
        String name = obj.get("name");

//        productDetailMapper.selectPage()
        return null;
    }
}
