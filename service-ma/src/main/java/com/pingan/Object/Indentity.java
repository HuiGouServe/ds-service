package com.pingan.Object;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kai
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Indentity对象", description="")
public class Indentity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一id")
    @TableId(value = "indentity_id", type = IdType.NONE)
    private String indentityId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @NotNull
    @ApiModelProperty(value = "身份证姓名")
    private String indentityName;

    @ApiModelProperty(value = "身份证状态：0未认证，1待认证，2已认证，3认证未通过")
    private String indentityStatus;

    @NotNull
    @ApiModelProperty(value = "身份证号")
    private String indentityCode;

    @NotNull
    @ApiModelProperty(value = "身份证正面")
    private String indentityFront;

    @NotNull
    @ApiModelProperty(value = "身份证反面")
    private String indentityVerso;

    @ApiModelProperty(value = "认证失败说明")
    private String indentityExplain;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改时间")
    private String updateTime;


}
