package com.glw.seller.controller.service;

import com.glw.seller.common.enums.ProductStatusEnum;
import com.glw.seller.common.snowflake.IdGenerator;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private IdGenerator idGenerator;

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
            productVO.setName(productCategory.getCategoryName());
            productVO.setType(categoryType);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            List<ProductInfo> productInfoList = productInfoService.findAllByCategoryType(categoryType);
            for (ProductInfo productInfo : productInfoList) {
                Long productId = productInfo.getProductId();
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setId(productId);
                productInfoVO.setName(productInfo.getProductName());
                productInfoVO.setPrice(productInfo.getDiscountPrice());
                productInfoVO.setOldPrice(productInfo.getProductPrice());
                productInfoVO.setDescription(productInfo.getProductDescription());
                productInfoVO.setSellCount(0);  // TODO  销量、评论
                productInfoVO.setRating(0);
                productInfoVO.setInfo(productInfo.getProductInfo());
                productInfoVO.setIcon(productInfo.getProductIcon());
                productInfoVO.setImage(productInfo.getProductImage());

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
                productInfoVO.setRatings(ratingVOList);
                productInfoVOList.add(productInfoVO);
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }

        return productVOList;
    }

    /**
     * 添加商品
     * @param productVO
     */
    @Transactional(rollbackFor = Exception.class)
    public void addFake(ProductVO productVO) {
        ProductCategory productCategory = new ProductCategory();
        Integer categoryType = productVO.getType();
        productCategory.setCategoryName(productVO.getName());
        productCategory.setCategoryType(categoryType);

        productCategoryService.save(productCategory);
        List<ProductInfoVO> productInfoVOList = productVO.getFoods();
        for (ProductInfoVO productInfoVO : productInfoVOList) {
            ProductInfo productInfo = new ProductInfo();
            long productId = idGenerator.nextId();
            productInfo.setProductId(productId);
            productInfo.setProductName(productInfoVO.getName());
            productInfo.setProductPrice(productInfoVO.getOldPrice());
            productInfo.setDiscountPrice(productInfoVO.getPrice());
            productInfo.setProductStock(9999);
            productInfo.setProductDescription(productInfoVO.getDescription());
            productInfo.setProductInfo(productInfoVO.getInfo());
            productInfo.setProductIcon(productInfoVO.getIcon());
            productInfo.setProductImage(productInfoVO.getImage());
            productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
            productInfo.setCategoryType(categoryType);

            productInfoService.save(productInfo);
            List<RatingVO> ratingList = productInfoVO.getRatings();
            for (RatingVO ratingVO : ratingList) {
                RateDetail rateDetail = new RateDetail();
                rateDetail.setRateId(idGenerator.nextId());
                rateDetail.setProductId(productId);
                rateDetail.setOrderId(idGenerator.nextId());
                rateDetail.setProductId(productId);
                rateDetail.setUsername(ratingVO.getUsername());
                rateDetail.setRateType(ratingVO.getRateType());
                rateDetail.setText(ratingVO.getText());
                rateDetail.setAvatar(ratingVO.getAvatar());

                rateDetailService.save(rateDetail);
            }
        }
    }
}
