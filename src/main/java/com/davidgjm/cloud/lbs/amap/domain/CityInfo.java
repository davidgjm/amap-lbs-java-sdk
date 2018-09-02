package com.davidgjm.cloud.lbs.amap.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class CityInfo implements Serializable {
    private String name;

    @PositiveOrZero
    @JsonProperty("num")
    private int keywordOccurrences;

    private String citycode;

    private String adcode;
}
