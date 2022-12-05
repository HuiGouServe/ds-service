package com.pingan.Controller;


import com.pingan.Object.ProductDetail;
import com.pingan.Object.R;
import com.pingan.Service.ProductService;
import com.pingan.Utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "测试接口", tags = "商品相关的接口")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "搜索")
    @PostMapping("/search") //根据id查询详情
    public R search(@RequestBody Map<String, String> obj) {
        String name = obj.get("name");
        productService.selectProduct(obj);


        return null;
    }

    @ApiOperation(value = "获取一个商品详情")
    @PostMapping("/getProductDetail") //根据id查询详情
    public R getProductDetail(@RequestBody Map<String, String> obj) {
        String id = obj.get("id");
        if (id.equals("\"\"") || id.equals(null)) {
            return new Result().fail("productId不能为空");
        }
        ProductDetail productDetail = productService.findProductDetailById(id);
        if (productDetail == null) {
            return new Result().fail("请求参数不存在");
        } else {
            return new Result().success(productDetail);
        }
    }

    @ApiOperation(value = "根据id删除商品详情")
    @PostMapping("/deleteProductDetail")
    public R deleteProductDetail(@RequestBody Map<String, String> obj) {
        String id = obj.get("id");
        if (id.equals("\"\"") || id.equals(null)) {
            return new Result().fail("productId不能为空");
        }
        return new Result().success(productService.deleteProductDetail(id));
    }

    @ApiOperation(value = "新增/修改一个商品详情")
    @PostMapping("/insertProductDetail") //插入商品详情
    public R insertProductDetail(@RequestBody ProductDetail productDetail) {
        if (productDetail.getProductName().equals("\"\"") || productDetail.getProductName().equals(null)) {
            return new Result().fail("商品名称不能为空");
        }
        if (productDetail.getProductForGold().equals("\"\"") || productDetail.getProductForGold().equals(null)) {
            return new Result().fail("抵金币不能为空");
        }
        if (productDetail.getProductRepertory().equals("\"\"") || productDetail.getProductRepertory().equals(null)) {
            return new Result().fail("商品库存不能为空");
        }
        if (productDetail.getProductFreight().equals("\"\"") || productDetail.getProductFreight().equals(null)) {
            return new Result().fail("运费不能为空");
        }
        if (productDetail.getProductParticulars().equals("\"\"") || productDetail.getProductParticulars().equals(null)) {
            return new Result().fail("富文本不能为空");
        }
        if (productDetail.getProductImgs().equals("\"\"") || productDetail.getProductImgs().equals(null)) {
            return new Result().fail("图片链接不能为空");
        }
        if (productDetail.getProductPrice().size() == 0) {
            return new Result().fail("请填写商品价格信息");
        } else {
            for (int i = 0; i < productDetail.getProductPrice().size(); i++) {
                if (productDetail.getProductPrice().get(i).getPrice().equals("\"\"")) {
                    return new Result().fail("商品价格不能为空");
                }
            }
        }
        return new Result().success(productService.insertProductDetail(productDetail));
    }
}

