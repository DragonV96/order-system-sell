package com.glw.seller.service;

import com.glw.seller.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:10
 * @Description : 商品信息业务层
 */
public interface ProductInfoService {

    /**
     * 根据商品id查询商品
     * @param productId
     * @return
     */
    ProductInfo findById(Long productId);

    /**
     * 查询所有在售商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品列表
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 插入或更新
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);
}
