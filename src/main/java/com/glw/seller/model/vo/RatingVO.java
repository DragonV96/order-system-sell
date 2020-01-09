package com.glw.seller.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 18:26
 * @Description : 商品评论
 */
@Data
@ApiModel(value = "商品评论")
public class RatingVO {

    @JsonProperty("username")
    @ApiModelProperty(value = "用户名")
    private String username;

    @JsonProperty("rateTime")
    @ApiModelProperty(value = "评价时间")
    private Long rateTime;

    @JsonProperty("rateType")
    @ApiModelProperty(value = "评价类型")
    private Integer rateType;

    @JsonProperty("text")
    @ApiModelProperty(value = "评价内容")
    private String text;

    @JsonProperty("avatar")
    @ApiModelProperty(value = "评价图片地址")
    private String avatar;
}
