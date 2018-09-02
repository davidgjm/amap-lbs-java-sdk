package com.davidgjm.cloud.lbs.amap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "amap.restapi.url")
@Data
public class AmapRestUrls {
    private String geocodeGeo;
    private String geocodeRegeo;
    private String searchKeyword;
    private String searchAround;
    private String searchPolygon;
    private String searchDetail;
}
