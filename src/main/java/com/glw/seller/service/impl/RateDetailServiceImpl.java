package com.glw.seller.service.impl;

import com.glw.seller.dao.RateDetailDao;
import com.glw.seller.model.RateDetail;
import com.glw.seller.service.RateDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 17:13
 * @Description : 商品评论业务层实现
 */
@Slf4j
@Service
public class RateDetailServiceImpl implements RateDetailService {

    @Autowired
    private RateDetailDao rateDetailDao;

    @Override
    public RateDetail findById(Long rateId) {
        RateDetail rateDetail = null;
        try {
            Optional<RateDetail> optional = rateDetailDao.findById(rateId);
            rateDetail = optional.get();
        } catch (RuntimeException e) {
            log.error("[findById] - RateDetail searched failed, the reason was : {}", e.getMessage());
        }
        return rateDetail;
    }

    @Override
    public List<RateDetail> findAllByProductId(Long productId) {
        List<RateDetail> rateDetailList = new ArrayList<>();
        try {
            rateDetailList = rateDetailDao.findAllByProductId(productId);
        } catch (RuntimeException e) {
            log.error("[findAllByProductId] - RateDetail searched failed, the reason was : {}", e.getMessage());
        }
        return rateDetailList;
    }

    @Override
    public RateDetail save(RateDetail rateDetail) {
        RateDetail entity = null;
        try {
            entity = rateDetailDao.save(rateDetail);
        } catch (Exception e) {
            log.error("[save] - RateDetail saved failed, the reason was : {}", e.getMessage());
        }
        return entity;
    }
}
