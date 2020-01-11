package com.glw.seller.common.utils.html;

import com.glw.seller.common.utils.StringUtils;

/**
 * @author : glw
 * @date : 2020/1/11
 * @time : 14:00
 * @Description : 转义和反转义工具类
 */
public class EscapeUtil {

    /** 匹配html各类标签（包括vue自定义标签） */
    public static final String HTML_SYMBOL = "(<[^<]*?>)|(<[\\s]*?/[^<]*?>)|(<[^<]*?/[\\s]*?>)";

    private static final int LENGTH = 64;

    private static final char[][] TEXT = new char[LENGTH][];

    static {
        for (int i = 0; i < LENGTH; i++) {
            TEXT[i] = new char[] { (char) i };
        }

        // 特殊HTML字符
        TEXT['\''] = "&#039;".toCharArray();    // 单引号
        TEXT['"'] = "&#34;".toCharArray();      // 单引号
        TEXT['&'] = "&#38;".toCharArray();      // &符
        TEXT['<'] = "&#60;".toCharArray();      // 小于号
        TEXT['>'] = "&#62;".toCharArray();      // 大于号
    }

    /**
     * 转义文本中的HTML字符为安全字符
     * @param text
     * @return
     */
    public static String escape(String text) {
        return encode(text);
    }

    /**
     * 还原文本中的被转义后的HTML字符
     * @param content
     * @return
     */
    public static String unescape(String content) {
        return decode(content);
    }

    /**
     * 清楚所有HTML标签，但是保留标签内的内容
     * @param content
     * @return
     */
    public static String clean(String content) {
        return content.replaceAll(HTML_SYMBOL, "");
    }

    private static String encode(String text) {
        int len;
        if ((text == null) || (len = text.length()) == 0) {
            return StringUtils.EMPTY;
        }
        StringBuilder builder = new StringBuilder(len + (len >> 2));
        char c;
        for (int i = 0; i < len; i++) {
            c = text.charAt(i);
            if (c < 64) {
                builder.append(TEXT[c]);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private static String decode(String content) {
        if (StringUtils.isEmpty(content)) {
            return content;
        }

        StringBuilder builder = new StringBuilder(content.length());
        int lastPos = 0, pos = 0;
        char c;
        while (lastPos < content.length()) {
            pos = content.indexOf("%", lastPos);
            if (pos == lastPos) {
                // 中文Unicode编码
                if (content.charAt(pos + 1) == 'u') {
                    c = (char) Integer.parseInt(content.substring(pos + 2, pos + 6), 16);
                    builder.append(c);
                    lastPos = pos + 6;
                } else {    // URL二次编码
                    c = (char) Integer.parseInt(content.substring(pos + 1, pos + 3), 16);
                    builder.append(c);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    builder.append(content.substring(lastPos));
                    lastPos = content.length();
                } else {
                    builder.append(content.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String html = "<script>alert(\"嘻嘻\");</script>";
        System.out.println(EscapeUtil.clean(html));
        System.out.println(EscapeUtil.escape(html));
        System.out.println(EscapeUtil.unescape(html));
    }
}
