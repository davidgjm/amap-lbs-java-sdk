package com.davidgjm.cloud.lbs.amap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class Poi {
    private String id;

    private String name;

    private String type;

    private String typecode;

    @JsonProperty("biz_type")
    private String industryType;

    private String address;

    private String location;

    private String distance;

    @JsonProperty("tel")
    private String phoneNumber;

    private String pname;

    private String cityname;

    private String adname;

}
