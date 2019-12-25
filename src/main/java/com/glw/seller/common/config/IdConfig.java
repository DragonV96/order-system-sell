package com.glw.seller.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : glw
 * @date : 2019/12/26
 * @time : 0:29
 * @Description : id生成器配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "id")
public class IdConfig {

    public int dataCenterId;

    public int machineId;

}
