package com.pingan.Object;

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
 * @since 2022-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserDetail对象", description = "")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "user_id", type = IdType.NONE)
    private String userId;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "身份证 ")
    private String identityCard;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "爱好")
    private String like;

    @ApiModelProperty(value = "联系地址")
    private String contactAddress;

    @ApiModelProperty(value = "签名")
    private String signature;


}
