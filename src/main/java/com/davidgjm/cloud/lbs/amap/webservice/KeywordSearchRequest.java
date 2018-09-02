package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.domain.ResultDepth;
import com.davidgjm.cloud.lbs.amap.domain.ResultType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class KeywordSearchRequest extends WSRequest {

    @NotNull
    @NotBlank
    private String location;

    private String keywords;

    private String types;

    private String city;

    private Boolean citylimit;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Boolean children;

    @Positive
    private Integer offset;

    @Positive
    @Size(max = 100)
    private Integer page;

    private String building;

    private String floor;

    private ResultDepth extensions;

    private String sig;

    private ResultType output;

    private String callback;
}
