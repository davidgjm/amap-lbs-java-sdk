package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.domain.Poi;
import com.davidgjm.cloud.lbs.amap.domain.CitySuggestion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class KeywordSearchResponse extends WSResponse {

    private CitySuggestion suggestion;

    private List<Poi> pois = new ArrayList<>();
}
