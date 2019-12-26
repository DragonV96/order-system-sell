package com.glw.seller.dao;

import com.glw.seller.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : 订单详情DAO
*/
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {

}




