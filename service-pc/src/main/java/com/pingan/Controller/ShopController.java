package com.pingan.Controller;

import com.pingan.Mapper.ShopStoreMapper;
import com.pingan.Object.R;
import com.pingan.Object.ShopStore;
import com.pingan.Object.UserLogin;
import com.pingan.Service.ShopService;
import com.pingan.Utils.Result;
import com.pingan.Utils.publicUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Api(value = "测试接口", tags = "商店接口")
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopStoreMapper shopStoreMapper;

    @ApiOperation(value = "开店申请")
    @PostMapping("/shopRegister")
    public R accountRegister(@RequestBody @Validated ShopStore shopStore) {
        ShopStore shop = shopStoreMapper.selectByUserId(shopStore.getUserId());
        if(shop!=null){
            return new Result().fail("新增失败，您当前已有店铺");
        }
        int insert = shopService.add(shopStore);
        if(insert==1){
            return new Result().success("新增成功");
        }else {
            return new Result().fail("新增失败");
        }

    }

}
