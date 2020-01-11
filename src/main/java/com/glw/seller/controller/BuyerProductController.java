package com.glw.seller.controller;

import com.glw.seller.controller.service.BuyerProductService;
import com.glw.seller.model.vo.ProductVO;
import com.glw.seller.model.vo.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private BuyerProductService buyerProductService;

    @GetMapping("/list")
    @ApiOperation(value = "获取商品列表", notes = "获取商品列表")
    public ResultData<List<ProductVO>> list() {
        List<ProductVO> productVOList = buyerProductService.getList();
        return ResultData.success(productVOList);
    }

    @PostMapping("/fake/add")
    @ApiOperation(value = "添加商品模拟数据", notes = "添加商品模拟数据")
    public ResultData addFake(@RequestBody ProductVO productVO) {
        buyerProductService.addFake(productVO);
        return ResultData.success();
    }
}
