package com.glw.seller.dao;

import com.glw.seller.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 商品DAO
*/
public interface ProductInfoDao extends JpaRepository<ProductInfo, Long> {

    /**
     * 根据商品状态码查询商品列表
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);


    /**
     * 根据商品类目查询商品列表
     * @param categoryType
     * @return
     */
    List<ProductInfo> findAllByCategoryType(Integer categoryType);
}




