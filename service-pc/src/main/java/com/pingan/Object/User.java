package com.pingan.Object;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author kai
 * @since 2022-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ColumnWidth(value = 20)
    @ExcelProperty("id")
    @TableId(value = "user_id", type = IdType.NONE)
    private String userId;

    @ColumnWidth(value = 15)
    @ExcelProperty("用户名称")
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ColumnWidth(value = 20)
    @ExcelProperty("用户账户")
    @ApiModelProperty(value = "用户账户")
    private String userAccount;

    @ColumnWidth(value = 30)
    @ExcelProperty("密码")
    @ApiModelProperty(value = "密码")
    private String password;

    @ColumnWidth(value = 15)
    @ExcelProperty("邮箱")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ColumnWidth(value = 15)
    @ExcelProperty("手机")
    @ApiModelProperty(value = "手机")
    private String phone;

    @ColumnWidth(value = 15)
    @ExcelProperty("注册时间")
    @ApiModelProperty(value = "注册时间")
    private String registrationTime;

    @ColumnWidth(value = 15)
    @ExcelProperty("开店情况")
    @ApiModelProperty(value = "0：无店铺，1：有店铺")
    private String shopStatus;

    @ColumnWidth(value = 15)
    @ExcelProperty("认证状态")
    @ApiModelProperty(value = "0：未认证，1：已认证")
    private String indentityStatus;

    @ColumnWidth(value = 10)
    @ExcelProperty("年龄")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ColumnWidth(value = 10)
    @ExcelProperty("性别")
    @ApiModelProperty(value = "性别")
    private String sex;

    @ColumnWidth(value = 30)
    @ExcelProperty("身份证")
    @ApiModelProperty(value = "身份证")
    private String identityCard;

    @ColumnWidth(value = 30)
    @ExcelProperty("籍贯")
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ColumnWidth(value = 20)
    @ExcelProperty("标签")
    @ApiModelProperty(value = "标签")
    private String tag;

    @ColumnWidth(value = 20)
    @ExcelProperty("爱好")
    @ApiModelProperty(value = "爱好")
    private String likes;

    @ColumnWidth(value = 30)
    @ExcelProperty("联系地址")
    @ApiModelProperty(value = "联系地址")
    private String contactAddress;

    @ColumnWidth(value = 20)
    @ExcelProperty("签名")
    @ApiModelProperty(value = "签名")
    private String signature;



}
