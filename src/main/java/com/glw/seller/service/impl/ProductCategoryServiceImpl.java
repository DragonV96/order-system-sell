package com.glw.seller.service.impl;

import com.glw.seller.dao.ProductCategoryDao;
import com.glw.seller.model.ProductCategory;
import com.glw.seller.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:21
 * @Description : 类目业务层实现
 */
@Slf4j
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findById(Integer categoryId) {
        ProductCategory productCategory = null;
        try {
            Optional<ProductCategory> optional = productCategoryDao.findById(categoryId);
            productCategory = optional.get();
        } catch (RuntimeException e) {
            log.error("[findById] - ProductCategory searched failed, the reason was : {}", e.getMessage());
        }
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategories = null;
        try {
            productCategories = productCategoryDao.findAll();
        } catch (RuntimeException e) {
            log.error("[findAll] - ProductCategory list searched failed, the reason was : {}", e.getMessage());
        }
        return productCategories;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> productCategories = null;
        try {
            productCategories = productCategoryDao.findByCategoryTypeIn(categoryTypeList);
        } catch (RuntimeException e) {
            log.error("[findByCategoryTypeIn] - ProductCategory list searched failed, the reason was : {}", e.getMessage());
        }
        return productCategories;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategory entity = null;
        try {
            entity = productCategoryDao.save(productCategory);
        } catch (Exception e) {
            log.error("[save] - ProductCategory list saved failed, the reason was : {}", e.getMessage());
        }
        return entity;
    }
}
