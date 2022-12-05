package com.pingan.Controller;


import com.pingan.Mapper.IndetityMapper;
import com.pingan.Object.Indentity;
import com.pingan.Object.R;
import com.pingan.Service.IndentityService;
import com.pingan.Utils.Result;
import com.pingan.Utils.downLoad;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kai
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/indentity")
public class IndentityController {

    @Autowired
    private IndetityMapper indetityMapper;

    @Autowired
    private IndentityService indentityService;

    @PostMapping("/getAuthenticationStatus")
    public R getAuthenticationStatus(@RequestBody Map<String, String> params) {
        return new Result().success(indetityMapper.SelectByUserId(params.get("userId")));
    }

    @PostMapping("/addOrUpdate")
    public R addOrUpdate(@RequestBody @Validated Indentity indentity) {
        Indentity user = indetityMapper.SelectByUserId(indentity.getUserId());
        if(user!=null){
            return new Result().fail("您已经认证过或在认证中，请勿从新申请");
        }
        return new Result().success(indentityService.addOrUpdate(indentity));
    }

    @PostMapping("/revocation")
    public R revocation(@RequestBody Map<String,String> params) {
        Indentity indentity = indetityMapper.selectById(params.get("indentityId"));
        if(indentity ==null){
            return new Result().fail("您还未申请店铺");
        }
        int num = indetityMapper.deleteById(params.get("indentityId"));
        if(num==1){
            return new Result().success("删除成功");
        }else {
            return new Result().fail("删除失败");
        }
    }





}

