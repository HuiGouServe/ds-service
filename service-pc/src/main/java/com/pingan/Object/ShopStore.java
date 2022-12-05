package com.pingan.Object;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kai
 * @since 2022-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ShopStore对象", description="")
public class ShopStore implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店铺id")
    @TableId(value = "shop_id", type = IdType.NONE)
    private String shopId;

    @ApiModelProperty(value = "店铺人员id")
    private String userId;

    @NotNull
    @ApiModelProperty(value = "店铺类型")
    private String shopType;

    @NotNull
    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改时间")
    private String updateTime;

    @ApiModelProperty(value="店铺状态：0关闭,1封停，2正常")
    private String shopStatus;
}
