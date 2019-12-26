package com.glw.seller.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

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
    private BigDecimal productPrice;

    @JsonProperty("description")
    @ApiModelProperty(value = "描述")
    private String productDescription;

    @JsonProperty("icon")
    @ApiModelProperty(value = "小图")
    private String productIcon;

}
