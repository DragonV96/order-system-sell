package com.glw.seller.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:19
 * @Description : 商品(包含类目)
 */
@Data
@ApiModel(value = "商品(包含类目)")
public class ProductVO {

    @JsonProperty("name")
    @ApiModelProperty(value = "类目名称")
    private String categoryName;

    @JsonProperty("type")
    @ApiModelProperty(value = "类目编号")
    private Integer categoryType;

    @JsonProperty("foods")
    @ApiModelProperty(value = "商品详情对象列表")
    private List<ProductInfoVO> productInfoVOList;
}
