package com.glw.seller.common.config;

import com.glw.seller.SellerApplication;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : glw
 * @date : 2019/12/25
 * @time : 21:07
 * @Description : swagger api文档
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private String basePackage = SellerApplication.class.getPackage().getName();

    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("restful")
                .select()
                .apis(Predicates.and(RequestHandlerSelectors.basePackage(basePackage)))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("点餐系统商家后台接口 API文档")
                .description("")
                .termsOfServiceUrl("https://www.github.com/DragonV96")
                .contact(new Contact("glw", "", ""))
                .version("1.0.0")
                .build();
    }

}
