package com.glw.seller.controller;

import com.glw.seller.model.vo.ProductVO;
import com.glw.seller.model.vo.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:20
 * @Description : 买家商品控制层
 */
@RestController
@RequestMapping("/buyer/product")
@Api(tags = "买家商品接口")
public class BuyerProductController {

    @GetMapping("/list")
    @ApiOperation(value = "获取商品列表", notes = "获取商品列表")
    public ResultData<ProductVO> list(ProductVO productVO) {
        return ResultData.success(productVO);
    }
}
