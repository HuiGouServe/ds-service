package com.pingan.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pingan.Client.UserClient;
import com.pingan.Object.R;
import com.pingan.Object.User;
import com.pingan.Service.UserService;
import com.pingan.Utils.Result;
import com.pingan.Utils.downLoad;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.pingan.Mapper.UserMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserClient userClient;

    private  final String md5Key="ABCDEF";



    @PostMapping("/login")
    public R phoneLogin(@RequestBody Map<String, String> params) {
        String userAccount = params.get("userAccount");
        String password = params.get("password");
        if (userAccount == "") {
            return new Result().fail("账号不能为空");
        }
        if (password == "") {
            return new Result().fail("密码不能为空");
        }
        User user = userMapper.selectUserByAccountAndPassword(userAccount, DigestUtils.md5Hex(password + md5Key));
        if (user == null) {
            return new Result().fail("账号密码输入有误或该账户不存在");
        } else {
            return new Result().success( userService.login(user));
        }
    }

    @PostMapping("/logout")
    public R logout(@RequestBody Map<String, String> params) {
        try {
            stringRedisTemplate.delete(params.get("userId"));
        } catch (Exception e) {
            throw new Exception("key不存在");
        } finally {
            return new Result().success("登出成功");
        }
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
        int i = userMapper.deleteById(userId);
        if (i == 1) {
            return new Result().success("删除成功");
        } else {
            return new Result().fail("数据有误,请重新输入");
        }
    }

    @PostMapping("/deletes")
    public R deletes( @RequestBody  Map<String, List> params) {
        List<String> ids=params.get("userIds");
        int i = userMapper.deleteBatchIds(ids);
        if (i >0) {
            return new Result().success("删除成功");
        } else {
            return new Result().fail("数据有误,请重新选择");
        }
    }


    @PostMapping("/add")
    public R add(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
        String userAccount = params.get("userAccount");
        String userName = params.get("userName");
        String userPhone = params.get("userPhone");
        String userRank = params.get("userRank");
        if(userId==null){ //添加
            Map<String, Object> map = new HashMap<>();
            map.put("user_account", userAccount);
            List<User> users = userMapper.selectByMap(map);
            if (users.size() > 0) {
                return new Result().fail("账号重复，请重新输入");
            }else {
               int insert= userService.add(userAccount, userName, userPhone, userRank,DigestUtils.md5Hex("123456" + md5Key));
                if (insert == 1) {
                    return new Result().success("新增成功");
                } else {
                    return new Result().fail("数据有误,请重新输入");
                }
            }
        }else { //修改
            User user = new User();
            user.setUserAccount(params.get("userAccount"));
            user.setUserId(params.get("userId"));
            user.setUserName(params.get("userName'"));
            user.setUserPhone(params.get("userPhone"));
            user.setUserRank(params.get("userRank'"));
            int insert = userMapper.updateById(user);
            if (insert == 1) {
                return new Result().success("修改成功");
            } else {
                return new Result().fail("数据有误,请重新输入");
            }
        }
    }

    @PostMapping("/getList")
    public R getList(@RequestBody Map<String, String> params) {
        int page = Integer.parseInt(params.get("page"));
        int pageSize = Integer.parseInt(params.get("pageSize"));
        String userName = params.get("userName");
        String userRank = params.get("userRank");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        IPage<User> userIPage = userService.selectByPage(page,pageSize,userName,userRank,startTime,endTime);
        if (userIPage != null) {
            return new Result().success(userIPage);
        } else {
            return new Result().fail("暂无数据");
        }
    }

    @PostMapping("/uptatePassword")
    public R uptatePassword(@RequestBody Map<String, String> params) {
        String password = params.get("password");
        String newPassword = params.get("newPassword");
        String userId = params.get("userId");
        String oldPassword = params.get("oldPassword");
        if(!password.equals(newPassword)) {
            return new Result().fail("密码不一致");
        }
        User U = userMapper.selectById(userId);
        if(DigestUtils.md5Hex(oldPassword + md5Key).equals(U.getPassword())){
            User user = new User();
            user.setUserId(userId);
            user.setPassword(DigestUtils.md5Hex(password + md5Key));
            userMapper.updateById(user);
            return new Result().success("修改成功");
        }else{
            return new Result().fail("原密码输入有误");
        }
    }

    @PostMapping("/uploadPortrait")
    public R uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("userId") String userId) throws FileNotFoundException {
        String portrait = new downLoad().uploadFile(file);
        User user = new User();
        user.setUserId(userId);
        user.setUserPortrait(portrait);
        if (portrait.equals("false")) {
            return new Result().fail("上传出错了");
        } else {
            userMapper.updateById(user);
            return new Result().success(portrait);
        }
    }
}

