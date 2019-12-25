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
 * @Description : 表名：order_master 订单表
*/
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "order_master")
public class OrderMaster {
    /**
     * 类目id
     */
    @Id
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 买家姓名
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @Column(name = "buyer_openid")
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认0新下单
     */
    @Column(name = "order_status")
    private Byte orderStatus;

    /**
     * 支付状态，默认0未支付
     */
    @Column(name = "pay_status")
    private Byte payStatus;

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