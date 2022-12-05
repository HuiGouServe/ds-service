package com.pingan.Mapper;

import com.pingan.Object.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
 public class UserMapperTest {
    @Autowired
    private  UserMapper userMapper;

    @Test
    public void selectById(){
        User root = userMapper.selectUserByAccountAndPassword("root", "123456");
        System.out.println(root);
    }

}