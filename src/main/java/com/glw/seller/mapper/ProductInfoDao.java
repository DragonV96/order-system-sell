package com.glw.seller.mapper;

import com.glw.seller.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 商品DAO
*/
public interface ProductInfoDao extends JpaRepository<ProductInfo, Long> {

}




