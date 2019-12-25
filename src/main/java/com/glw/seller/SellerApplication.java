package com.glw.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SellerApplication{

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }
}
