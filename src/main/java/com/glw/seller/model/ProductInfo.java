package com.glw.seller.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 表名：product_info 商品表
*/
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product_info")
public class ProductInfo {
    /**
     * 商品id
     */
    @Id
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
     * 折扣单价
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 库存
     */
    @Column(name = "product_stock")
    private Integer productStock;

    /**
     * 描述
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * 商品信息介绍
     */
    @Column(name = "product_info")
    private String productInfo;

    /**
     * 小图标
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 图片地址
     */
    @Column(name = "product_image")
    private String productImage;

    /**
     * 商品状态：0正常，1下架
     */
    @Column(name = "product_status")
    private Byte productStatus;

    /**
     * 类目编号
     */
    @Column(name = "category_type")
    private Integer categoryType;

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