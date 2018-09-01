package com.davidgjm.cloud.lbs.amap.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GeoObject implements Serializable {

    @JsonProperty("formatted_address")
    private String formattedAddress;

    private String province;

    private String citycode;

    private String city;

    private String district;

    private String adcode;

    @NotNull
    @NotBlank
    private String location;

    private String level;
}
