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

    /**
     * 数据中心标识（数据中心标识和机器标识的组合必须唯一）
     */
    public int dataCenterId;

    /**
     * 机器标识（数据中心标识和机器标识的组合必须唯一）
     */
    public int machineId;

}
