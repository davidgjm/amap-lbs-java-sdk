package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.webservice.model.GeoObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GeoResponse extends WSResponse {
    @JsonProperty("geocodes")
    private List<GeoObject> geoObjects = new ArrayList<>();
}
