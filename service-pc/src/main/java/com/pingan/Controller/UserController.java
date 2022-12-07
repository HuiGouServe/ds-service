package com.pingan.Controller;

import com.pingan.Mapper.UserLoginMapper;
import com.pingan.Object.R;
import com.pingan.Object.UserLogin;
import com.pingan.Utils.JwtUtils;
import com.pingan.Utils.Result;
import com.pingan.Utils.publicUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.pingan.Service.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Api(value = "测试接口", tags = "用户相关的接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //校验手机号
    public static boolean validateMobilePhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
        return pattern.matcher(phone).matches();
    }


    @ApiOperation(value = "手机注册")
    @PostMapping("/phoneRegister")
    public R phoneRegister(@RequestBody Map<String, String> params) {
        try {
            String phone = params.get("phone");
            if (!validateMobilePhone(phone)) {
                return new Result().fail("手机号有误");
            };
            boolean equals = params.get("code").equals(stringRedisTemplate.opsForValue().get(phone));
            if (!equals) {
                return new Result().fail("验证码已过期或不存在");
            }
            UserLogin userLogin = new UserLogin();
            userLogin.setPhone(phone);
            userLogin.setUserId(new publicUtils().generationId("use"));
            int i = userService.insertUserLogin(userLogin, "phoneRegister");
            if (i == 1) {
                return new Result().success("注册成功");
            } else {
                return new Result().fail("手机号已经存在");
            }
        } catch (Exception e) {
            return new Result().fail("服务器异常");
        }
    }


    @ApiOperation(value = "手机登录")
    @PostMapping("/phoneLogin")
    public R phoneLogin(@RequestBody Map<String, String> params) {
        String phone = params.get("phone");
        if (!validateMobilePhone(phone)) {
            return new Result().fail("手机号有误");
        }
        boolean equals = params.get("code").equals(stringRedisTemplate.opsForValue().get(phone));
        if (!equals) {
            return new Result().fail("验证码已过期或不存在");
        }
        UserLogin user = userService.selectUserLoginByPhone(phone);

        if (user != null) {
            String jwtToken = JwtUtils.getJwtToken(user.getUserId());
            stringRedisTemplate.opsForValue().set(user.getUserId(), jwtToken, 1800, TimeUnit.SECONDS);

            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("token", jwtToken);
            stringObjectMap.put("userInfo", user);
            return new Result().success(stringObjectMap);
        } else {
            return new Result().fail("您输入的手机号不存在");
        }
    }

    @ApiOperation(value = "账号注册")
    @GetMapping("/accountRegister")
    public R accountRegister(@RequestBody UserLogin userLogin) {
        int i = userService.insertUserLogin(userLogin, "accountRegister");
        if (i == 1) {
            return new Result().success("注册成功");
        } else {
            return new Result().fail("该手机号已经注册,请直接登录或确认是否被占用");
        }
    }


    @PostMapping("/getCode")
    public R getCode(@RequestBody Map<String, String> params) throws Exception {
        String phone = params.get("phone");
        if (!validateMobilePhone(phone)) {
            return new Result().fail("手机号有误");
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String NUMBERCHAR = "0123456789";
        for (int i = 0; i < 4; i++) {
            sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
        }
        String code = sb.toString();
        stringRedisTemplate.opsForValue().set(phone, code, 120, TimeUnit.SECONDS);
        return new Result().success(code);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/phoneLogout")
    public R phoneLogout(@RequestBody Map<String, String> params) {
        String phone = params.get("phone");
        UserLogin userLogin = userLoginMapper.selectUserLoginByphone(phone);
        try {
            stringRedisTemplate.delete(userLogin.getUserId());
        } catch (Exception e) {
            throw new Exception("key不存在");
        } finally {
            return new Result().success("登出成功");
        }
    }


//    @ApiOperation(value = "手机注册")
//    @PostMapping("/phoneRegister") //
//    private Object phoneRegister(@RequestBody Map<String, String> params) {
//        if (params.get("code").equals(stringRedisTemplate.opsForValue().get(params.get("phone")))) {
//            User user = new User();
//            user.setUserPhone(params.get("phone"));
//            Date date = new Date();
//            user.setUserRegisterTime(Long.toString(date.getTime()));
//            user.setUserId(Long.toString(date.getTime()).substring(0, 10) + (int) (1 + Math.random() * 100));
//            return userService.save(user);
//        } else {
//            return "验证码有误";
//        }
//    }

//    @PostMapping("/phoneLogin") //手机登陆
//    private Object phoneLogin(@RequestBody Map<String, String> params) {
//        if (params.get("code").equals(stringRedisTemplate.opsForValue().get(params.get("phone")))) {
//            User user = userMapper.selectByUserPhone(params.get("phone"));
//            if (user != null) {
//                JSONObject jsonObject = new JSONObject();
//                String token = TokenUtils.sign(user.getUserId());
//                Map<String, Object> userInfo = new HashMap<>();
//                userInfo.put("userId", user.getUserId());
//                userInfo.put("userPhone", user.getUserPhone());
//                userInfo.put("userNickname", user.getUserNickname());
//                userInfo.put("userIcon", user.getUserIcon());
//                userInfo.put("success", true);
//                userInfo.put("userAccount", user.getUserAccount());
//                jsonObject.put("token", token);
//                jsonObject.put("user", userInfo);
//                return jsonObject;
//            } else {
//                return "该账号未注册";
//            }
//        } else {
//            return "验证码错误";
//        }
//    }

}
