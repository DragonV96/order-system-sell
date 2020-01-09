package com.glw.seller.controller.service;

import com.glw.seller.model.ProductCategory;
import com.glw.seller.model.ProductInfo;
import com.glw.seller.model.vo.ProductInfoVO;
import com.glw.seller.model.vo.ProductVO;
import com.glw.seller.service.ProductCategoryService;
import com.glw.seller.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : glw
 * @date : 2020/1/9
 * @time : 18:22
 * @Description : 买家商品控制层业务实现
 */
@Service
public class BuyerProductService {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 获取商品列表
     * @return
     */
    public List<ProductVO> getList() {
        List<ProductVO> productVOList = new ArrayList<>();

        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            Integer categoryType = productCategory.getCategoryType();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(categoryType);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            List<ProductInfo> productInfoList = productInfoService.findAllByCategoryType(categoryType);
            for (ProductInfo productInfo : productInfoList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductId(productInfo.getProductId());
            }
        }

        return productVOList;
    }
}
