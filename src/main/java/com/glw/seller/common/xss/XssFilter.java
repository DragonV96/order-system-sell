package com.glw.seller.common.xss;

import com.glw.seller.common.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : glw
 * @date : 2020/1/10
 * @time : 21:15
 * @Description : XSS 过滤器
 */
public class XssFilter implements Filter {

    /** 排除的链接集合 */
    public List<String> excludes = new ArrayList<>();

    /** xss 过滤开关 */
    public boolean enabled = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludesParam = filterConfig.getInitParameter("excludes");
        String enabledParam = filterConfig.getInitParameter("enabled");
        if (StringUtils.isNotEmpty(excludesParam)) {
            String[] url = excludesParam.split(",");
            for (int i = 0; url != null && i < url.length; i++) {
                excludes.add(url[i]);
            }
        }
        if (StringUtils.isNotEmpty(enabledParam)) {
            enabled = Boolean.valueOf(enabledParam);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (doFilterForExcludes(request, response)) {
            filterChain.doFilter(request, response);
            return;
        }
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        filterChain.doFilter(xssHttpServletRequestWrapper, response);
    }

    private boolean doFilterForExcludes(HttpServletRequest request, HttpServletResponse response) {
        if (!enabled) {
            return true;
        }
        if (excludes == null || excludes.isEmpty()) {
            return false;
        }
        String url = request.getServletPath();
        for (String exclude : excludes) {
            Pattern pattern = Pattern.compile("^" + exclude);
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
