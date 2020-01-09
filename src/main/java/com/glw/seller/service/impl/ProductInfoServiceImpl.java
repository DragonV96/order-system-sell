package com.glw.seller.service.impl;

import com.glw.seller.common.enums.ProductStatusEnum;
import com.glw.seller.dao.ProductInfoDao;
import com.glw.seller.model.ProductInfo;
import com.glw.seller.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:18
 * @Description : 商品类目业务层实现
 */
@Slf4j
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findById(Long productId) {
        ProductInfo productInfo = null;
        try {
            Optional<ProductInfo> optional = productInfoDao.findById(productId);
            productInfo = optional.get();
        } catch (RuntimeException e) {
            log.error("[findById] - ProductInfo searched failed, the reason was : {}", e.getMessage());
        }
        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfos = null;
        try {
            productInfos = productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
        } catch (RuntimeException e) {
            log.error("[findUpAll] - ProductInfo searched failed, the reason was : {}", e.getMessage());
        }
        return productInfos;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> productInfoPage = null;
        try {
            productInfoPage = productInfoDao.findAll(pageable);
        } catch (Exception e) {
            log.error("[findAll] - ProductInfo searched failed, the reason was : {}", e.getMessage());
        }
        return productInfoPage;
    }

    @Override
    public List<ProductInfo> findAllByCategoryType(Integer categoryType) {
        List<ProductInfo> productInfoList = null;
        try {
            productInfoList = productInfoDao.findAllByCategoryType(categoryType);
        } catch (Exception e) {
            log.error("[findAllByCategoryType] - ProductInfo searched failed, the reason was : {}", e.getMessage());
        }
        return productInfoList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        ProductInfo entity = null;
        try {
            entity = productInfoDao.save(productInfo);
        } catch (Exception e) {
            log.error("[save] - ProductInfo saved failed, the reason was : {}", e.getMessage());
        }
        return entity;
    }
}
