package com.glw.seller.service;

import com.glw.seller.model.ProductCategory;

import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 22:10
 * @Description : 商品类目业务层
 */
public interface ProductCategoryService {

    /**
     * 根据id查询指定类目
     * @param categoryId
     * @return
     */
    ProductCategory findById(Integer categoryId);

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目id集合查询类目集合
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 插入或更新
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
