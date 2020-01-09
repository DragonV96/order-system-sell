package com.glw.seller.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id")
    @ApiModelProperty(value = "商品id")
    private Long productId;

    @JsonProperty("name")
    @ApiModelProperty(value = "商品名称")
    private String productName;

    @JsonProperty("price")
    @ApiModelProperty(value = "单价")
    private BigDecimal discountPrice;

    @JsonProperty("oldPrice")
    @ApiModelProperty(value = "旧单价")
    private BigDecimal productPrice;

    @JsonProperty("description")
    @ApiModelProperty(value = "描述")
    private String productDescription;

    @JsonProperty("sellCount")
    @ApiModelProperty(value = "销量")
    private Integer sellCount;

    @JsonProperty("rating")
    @ApiModelProperty(value = "评论数")
    private Integer rating;

    @JsonProperty("info")
    @ApiModelProperty(value = "商品信息介绍")
    private String productInfo;

    @JsonProperty("icon")
    @ApiModelProperty(value = "小图标")
    private String productIcon;

    @JsonProperty("image")
    @ApiModelProperty(value = "图片地址")
    private String productImage;

    @JsonProperty("ratings")
    @ApiModelProperty(value = "评价")
    private List<RatingVO> ratingList;

}
