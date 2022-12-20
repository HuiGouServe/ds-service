package com.pingan.Object;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kai
 * @since 2022-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(index = 0,value="唯一ID")
    @ApiModelProperty(value = "唯一ID")
    @ColumnWidth(value = 30)
    @TableId(value = "user_id", type = IdType.NONE)
    private String userId;

    @ExcelProperty(index = 1,value="名称")
    @ColumnWidth(value =15)
    @ApiModelProperty(value = "名称")
    private String userName;

    @ColumnWidth(value = 50)
    @ExcelProperty(index = 2,value="头像")
    @ApiModelProperty(value = "头像")
    private String userPortrait;

    @ExcelProperty(index = 3,value="权限")
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "权限")
    private String userRank;

    @ExcelProperty(index = 4,value="手机")
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "手机")
    private String userPhone;

    @ExcelProperty(index = 5,value="账户")
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "账户")
    private String userAccount;

    @ColumnWidth(value = 30)
    @ExcelProperty(index = 6,value="密码")
    @ApiModelProperty(value = "密码")
    private String password;


    @ColumnWidth(value = 20)
    @ExcelProperty(index = 7,value="创建时间")
    @ApiModelProperty(value="创建时间")
    private long createTime;


}
