package com.pingan.Service.impl;

import com.pingan.Mapper.ShopStoreMapper;
import com.pingan.Mapper.UserDetailMapper;
import com.pingan.Mapper.UserLoginMapper;
import com.pingan.Object.ShopStore;
import com.pingan.Object.UserDetail;
import com.pingan.Object.UserLogin;
import com.pingan.Service.ShopService;
import com.pingan.Service.UserService;
import com.pingan.Utils.publicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopStoreMapper shopStoreMapper;


    @Override
    public int add(ShopStore shopStore) {
        shopStore.setCreateTime(Long.toString(new Date().getTime()));
        shopStore.setUpdateTime(Long.toString(new Date().getTime()));
        shopStore.setShopStatus("2");
        shopStore.setShopId(new publicUtils().generationId("sho"));
        return shopStoreMapper.insert(shopStore);
    }
}
