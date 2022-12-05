package com.pingan.Service;

import com.pingan.Object.ProductDetail;
import com.pingan.Object.ProductPrice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDetail findProductDetailById(String id);

    int insertProductDetail(ProductDetail productDetail);

    int deleteProductDetail(String id);

    List<ProductDetail> selectProduct(Map<String, String> obj);
}
