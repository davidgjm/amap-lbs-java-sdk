package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.domain.ResultDepth;
import com.davidgjm.cloud.lbs.amap.domain.ResultType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class NearByRequest extends WSRequest {

    @NotNull
    @NotBlank
    private String location;

    private String keywords;

    private String types;

    private String city;

    @Positive
    @Size(max = 50000)
    private Integer radius;

    private String sortrule;

    @Positive
    private Integer offset;

    @Positive
    @Size(max = 100)
    private Integer page;

    private ResultDepth extensions;

    private String sig;

    private ResultType output;

    private String callback;
}
