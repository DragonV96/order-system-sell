package com.glw.seller.model.vo;

import com.glw.seller.common.enums.ErrorCode;
import lombok.Data;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 18:21
 * @Description : 通用传输对象
 */
@Data
public class ResultData<T> {

    /** 数据状态码 */
    private int code;

    /** 状态码对应描述 */
    private String msg;

    /** 数据 */
    private T data;

    public ResultData() {
        this.code = 0;
        this.msg = "成功";
    }

    public ResultData(T data) {
        this.code = 0;
        this.msg = "成功";
        this.data = data;
    }

    public ResultData(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> success(T data) {
        return new ResultData<T>(data);
    }

    /**
     * 返回成功(无参数)
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> success() {
        return new ResultData<T>();
    }

    /**
     * 返回失败
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> error(ErrorCode errorCode) {
        return new ResultData<T>(errorCode);
    }
}
