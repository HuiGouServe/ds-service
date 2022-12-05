package com.pingan.Object;


import java.math.BigDecimal;

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
 * @since 2022-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProductPrice对象", description = "")
public class ProductPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    @TableId(value = "product_id")
    private String productId;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "淘宝价格")
    private Double tbPrice;

    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "描述")
    private String content;

}
