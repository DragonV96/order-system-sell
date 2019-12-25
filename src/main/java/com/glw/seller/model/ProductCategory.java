package com.glw.seller.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 表名：product_category 类目表
*/
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product_category")
public class ProductCategory {
    /**
     * 类目id
     */
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @Column(name = "category_name")
    private String categoryName;

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