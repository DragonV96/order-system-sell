package com.glw.seller.common.utils;

import org.springframework.lang.Nullable;

/**
 * @author : glw
 * @date : 2020/1/10
 * @time : 20:37
 * @Description : 字符串处理工具类类
 */
public class StringUtils {

    public static final String EMPTY = "";

    /**
     * 判断字符串为空
     * @param str
     * @return
     */
    public static boolean isEmpty(@Nullable Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(@Nullable Object str) {
        return !isEmpty(str);
    }

    /**
     * 根据指定字符分割字符串
     * @param str
     * @param seperatorChars
     * @return
     */
    public static String[] split(String str, String seperatorChars) {
        return org.springframework.util.StringUtils.split(str, seperatorChars);
    }

}
