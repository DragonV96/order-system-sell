package com.glw.seller.dao;

import com.glw.seller.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 商品类目DAO
*/
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据类目id集合查询类目集合
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}




