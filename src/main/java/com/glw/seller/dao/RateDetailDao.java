package com.glw.seller.dao;

import com.glw.seller.model.RateDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 17:07
 * @Description : 商品评论DAO
 */
public interface RateDetailDao extends JpaRepository<RateDetail, Long> {

    /**
     * 根据商品id查询商品评论
     * @param productId
     * @return
     */
    List<RateDetail> findAllByProductId(Long productId);
}
