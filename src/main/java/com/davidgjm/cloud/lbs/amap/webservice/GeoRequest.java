package com.davidgjm.cloud.lbs.amap.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@Data
public class GeoRequest extends WSRequest{
    @NotNull
    @NotBlank
    private String address;

    @NotBlank
    private String city;

    private Boolean batch;

    private String sig;

    @NotBlank
    private String output;

    @NotBlank
    private String callback;
}
