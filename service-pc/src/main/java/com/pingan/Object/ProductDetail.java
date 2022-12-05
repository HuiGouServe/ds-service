package com.pingan.Object;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProductDetail对象", description = "")
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "product_id", type = IdType.NONE)
    @ApiModelProperty(value = "商品ID")
    private String productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品店铺")
    private String productShop;

    @ApiModelProperty(value = "累计评论")
    private Integer productCommentCount;

    @ApiModelProperty(value = "交易成功")
    private Integer productDealCount;

    @ApiModelProperty(value = "商品颜色")
    private String productColor;

    @ApiModelProperty(value = "抵金币")
    private Double productForGold;

    @ApiModelProperty(value = "商品重量")
    private String productWeight;

    @ApiModelProperty(value = "商品类型")
    private String productType;

    @ApiModelProperty(value = "商品库存")
    private Integer productRepertory;

    @ApiModelProperty(value = "收藏")
    private Integer productCollect;

    @ApiModelProperty(value = "运费")
    private Double productFreight;

    @ApiModelProperty(value = "月销")
    private Integer productMonthlySale;

    @ApiModelProperty(value = "商品介绍")
    private String productIntroduce;

    @ApiModelProperty(value = "富文本详情")
    private String productParticulars;

    @ApiModelProperty(value = "评分")
    private Double productEvaluate;

    @ApiModelProperty(value = "商品标签")
    private String productLabel;

    @ApiModelProperty(value = "图片链接")
    private String productImgs;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改时间")
    private String updateTime;

    @TableField(exist = false)
    private List<ProductPrice> productPrice;

}
