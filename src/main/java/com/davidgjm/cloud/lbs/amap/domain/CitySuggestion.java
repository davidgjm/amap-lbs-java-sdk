package com.davidgjm.cloud.lbs.amap.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CitySuggestion {
    private String keywords;

    private List<CityInfo> cities = new ArrayList<>();

}
