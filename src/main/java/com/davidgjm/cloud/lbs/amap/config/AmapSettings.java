package com.davidgjm.cloud.lbs.amap.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AmapSettings {

    @Value("${amap.apikey}")
    private String apikey;
}
