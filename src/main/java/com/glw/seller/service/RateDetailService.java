package com.glw.seller.service;

import com.glw.seller.model.RateDetail;

import java.util.List;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 18:19
 * @Description : 商品评论业务层
 */
public interface RateDetailService {

    /**
     * 根据评论id查询商品评论
     * @param rateId
     * @return
     */
    RateDetail findById(Long rateId);

    /**
     * 根据商品id查询商品评论
     * @param productId
     * @return
     */
    List<RateDetail> findAllByProductId(Long productId);

    /**
     * 插入或更新
     * @param rateDetail
     * @return
     */
    RateDetail save(RateDetail rateDetail);
}
