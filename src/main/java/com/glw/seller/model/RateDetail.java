package com.glw.seller.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 18:15
 * @Description : 表名：rate_detail 评论表
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "rate_detail")
public class RateDetail {
    /**
     * 评价id
     */
    @Id
    @Column(name = "rate_id")
    private Long rateId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 评价类型
     */
    @Column(name = "rate_type")
    private Integer rateType;

    /**
     * 评价内容
     */
    @Column(name = "text")
    private String text;

    /**
     * 评价图片地址
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}
