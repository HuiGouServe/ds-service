package com.pingan.Object;

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
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "user_id", type = IdType.NONE)
    private String userId;

    @ApiModelProperty(value = "名称")
    private String userName;

    @ApiModelProperty(value = "头像")
    private String userPortrait;

    @ApiModelProperty(value = "权限")
    private String userRank;

    @ApiModelProperty(value = "手机")
    private String userPhone;

    @ApiModelProperty(value = "账户")
    private String userAccount;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value="创建时间")
    private long createTime;


}
