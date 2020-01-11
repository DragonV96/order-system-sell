package com.glw.seller.common.enums;

import lombok.Getter;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:13
 * @Description : 商品状态
 */
@Getter
public enum ProductStatusEnum {
    UP((byte)0, "上架"),
    DOWN((byte)1, "下架");

    private Byte code;
    private String desc;

    ProductStatusEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
