package com.pingan.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pingan.Mapper.IndetityMapper;
import com.pingan.Mapper.UserMapper;
import com.pingan.Object.Indentity;
import com.pingan.Object.User;
import com.pingan.Service.IndentityService;
import com.pingan.Service.UserService;
import com.pingan.Utils.JwtUtils;
import com.pingan.Utils.publicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
@Service
public class IndentityServiceImpl extends ServiceImpl<IndetityMapper, Indentity> implements IndentityService {

    @Autowired
    private IndetityMapper indetityMapper;


    @Override
    public String addOrUpdate(Indentity indentity) {
        if(indentity.getIndentityId()==null){
            indentity.setIndentityId( new publicUtils().generationId("ind"));
            indentity.setCreateTime(Long.toString(new Date().getTime()));
            indentity.setUpdateTime(Long.toString(new Date().getTime()));
            indentity.setIndentityStatus("1");
            indetityMapper.insert(indentity);
            return "新增成功";
        }else {
            indentity.setUpdateTime(Long.toString(new Date().getTime()));
            indetityMapper.updateById(indentity);
            return "修改成功";
        }
    }
    @Override
    public IPage<Indentity> selectByPage(int page, int pageSize,String indentityName,String indentityStatus,String startTime,String endTime) {
        QueryWrapper<Indentity> wrapper = new QueryWrapper<>();
        if (indentityName != "") {
            wrapper.like("indentity_name", indentityName);
        }
        if (indentityStatus != "") {
            wrapper.like("indentity_status", indentityStatus);
        }
        if (startTime != "" && endTime != "") {
            wrapper.between("create_time", startTime, endTime);
        }
        IPage<Indentity> indentityPage = new Page<>(page, pageSize);//参数一是当前页，参数二是每页个数
        return indetityMapper.selectPage(indentityPage, wrapper);
    }
}
