package com.glw.seller.common.config;

import com.glw.seller.common.utils.StringUtils;
import com.glw.seller.common.xss.XssFilter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : glw
 * @date : 2020/1/10
 * @time : 21:12
 * @Description : XSS 过滤配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "xss")
public class XssConfig {

    private String enabled;

    private String excludes;

    private String urlPatterns;

    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.addUrlPatterns(StringUtils.split(urlPatterns, ","));
        filterRegistrationBean.setName("xssFilter");
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", excludes);
        initParameters.put("enabled", enabled);
        filterRegistrationBean.setInitParameters(initParameters);

        return filterRegistrationBean;
    }
}
