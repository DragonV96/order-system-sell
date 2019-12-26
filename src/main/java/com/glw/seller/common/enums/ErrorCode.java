package com.glw.seller.common.enums;

import lombok.Getter;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:12
 * @Description : 错误码
 */
@Getter
public enum ErrorCode {

    ERROR_ORDER(10501, "订单错误");

    /** 错误码 */
    private int code;

    /** 错误描述 */
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
