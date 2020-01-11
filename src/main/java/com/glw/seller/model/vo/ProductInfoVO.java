package com.glw.seller.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:17
 * @Description : 商品详情
 */
@Data
@ApiModel(value = "商品详情")
public class ProductInfoVO {

    @ApiModelProperty(value = "商品id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "旧单价")
    private BigDecimal oldPrice;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "销量")
    private Integer sellCount;

    @ApiModelProperty(value = "评论数")
    private Integer rating;

    @ApiModelProperty(value = "商品信息介绍")
    private String info;

    @ApiModelProperty(value = "小图标")
    private String icon;

    @ApiModelProperty(value = "图片地址")
    private String image;

    @ApiModelProperty(value = "评价")
    private List<RatingVO> ratings;

}
