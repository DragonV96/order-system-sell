package com.glw.seller.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 表名：order_detail 订单详情表
*/
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "order_detail")
public class OrderDetail {
    /**
     * 订单详情id
     */
    @Id
    @Column(name = "detail_id")
    private Long detailId;

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
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 描述
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * 商品小图
     */
    @Column(name = "product_icon")
    private String productIcon;

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