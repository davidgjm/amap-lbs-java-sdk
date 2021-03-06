package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.model.AmapResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class WSResponse implements AmapResponse {

    private Character status;

    @PositiveOrZero
    private int count;

    @NotNull
    @NotBlank
    private String info;

    private String infocode;
}
