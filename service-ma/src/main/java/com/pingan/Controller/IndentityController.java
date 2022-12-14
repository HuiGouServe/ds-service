package com.pingan.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pingan.Mapper.IndetityMapper;
import com.pingan.Object.Indentity;
import com.pingan.Object.R;
import com.pingan.Object.User;
import com.pingan.Service.IndentityService;
import com.pingan.Utils.Result;
import com.pingan.Utils.downLoad;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
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

    @PostMapping("/getList")
    public R getList(@RequestBody Map<String, String> params) {
        int page = Integer.parseInt(params.get("page"));
        int pageSize = Integer.parseInt(params.get("pageSize"));
        String indentityName = params.get("indentityName");
        String indentityStatus = params.get("indentityStatus");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        IPage<Indentity> userIPage = indentityService.selectByPage(page,pageSize,indentityName,indentityStatus,startTime,endTime);
        if (userIPage != null) {
            return new Result().success(userIPage);
        } else {
            return new Result().fail("暂无数据");
        }
    }

    @PostMapping("/indentity")
    public R indentity(@RequestBody Indentity indentity) {
        String indentityStatus = indentity.getIndentityStatus();
        if(indentityStatus=="2"){
            indentity.setIndentityTime(Long.toString(new Date().getTime()));
        }
        int insert = indetityMapper.updateById(indentity);

        if (insert==1) {
            return new Result().success("修改成功");
        } else {
            return new Result().fail("修改失败");
        }
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String, String> params) {
        int i = indetityMapper.deleteById( params.get("indentityId"));
        if (i == 1) {
            return new Result().success("删除成功");
        } else {
            return new Result().fail("数据有误,请重新输入");
        }
    }

    @PostMapping("/deletes")
    public R deletes( @RequestBody  Map<String, List> params) {
        int i = indetityMapper.deleteBatchIds(params.get("indentityIds"));
        if (i > 0) {
            return new Result().success("删除成功");
        } else {
            return new Result().fail("数据有误,请重新选择");
        }
    }


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

