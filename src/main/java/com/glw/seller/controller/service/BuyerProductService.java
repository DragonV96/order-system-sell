package com.glw.seller.controller.service;

import com.glw.seller.model.ProductCategory;
import com.glw.seller.model.ProductInfo;
import com.glw.seller.model.RateDetail;
import com.glw.seller.model.vo.ProductInfoVO;
import com.glw.seller.model.vo.ProductVO;
import com.glw.seller.model.vo.RatingVO;
import com.glw.seller.service.ProductCategoryService;
import com.glw.seller.service.ProductInfoService;
import com.glw.seller.service.RateDetailService;
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

    @Autowired
    private RateDetailService rateDetailService;

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
                Long productId = productInfo.getProductId();
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductId(productId);
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVO.setDiscountPrice(productInfo.getDiscountPrice());
                productInfoVO.setProductPrice(productInfo.getProductPrice());
                productInfoVO.setProductDescription(productInfo.getProductDescription());
                productInfoVO.setSellCount(0);  // TODO  销量、评论
                productInfoVO.setRating(0);
                productInfoVO.setProductInfo(productInfo.getProductInfo());
                productInfoVO.setProductIcon(productInfo.getProductIcon());
                productInfoVO.setProductImage(productInfo.getProductImage());

                List<RatingVO> ratingVOList = new ArrayList<>();
                List<RateDetail> rateDetailList = rateDetailService.findAllByProductId(productId);
                for (RateDetail rateDetail : rateDetailList) {
                    RatingVO ratingVO = new RatingVO();
                    ratingVO.setUsername(rateDetail.getUsername());
                    ratingVO.setRateTime(rateDetail.getCreateTime().getTime());
                    ratingVO.setRateType(rateDetail.getRateType());
                    ratingVO.setText(rateDetail.getText());
                    ratingVO.setAvatar(rateDetail.getAvatar());

                    ratingVOList.add(ratingVO);
                }
                productInfoVO.setRatingList(ratingVOList);
                productInfoVOList.add(productInfoVO);
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productCategoryList.add(productCategory);
        }

        return productVOList;
    }
}
