package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.config.AmapRestUrls;
import com.davidgjm.cloud.lbs.amap.config.AmapSettings;
import com.davidgjm.cloud.lbs.amap.webservice.GeoRequest;
import com.davidgjm.cloud.lbs.amap.webservice.GeoResponse;
import com.davidgjm.cloud.lbs.amap.webservice.WSRequest;
import com.davidgjm.cloud.lbs.amap.webservice.WSResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class AmapGeoCodeServiceImpl implements AmapGeoCodeService {
    private final AmapRestUrls restUrls;
    private final AmapWSApiService wsApiService;

    public AmapGeoCodeServiceImpl(AmapRestUrls restUrls, AmapWSApiService wsApiService) {
        this.restUrls = restUrls;
        this.wsApiService = wsApiService;
    }

    @Override
    public GeoResponse getGeoCodeByAddress(GeoRequest request) {
        return wsApiService.doGet(restUrls.getGeocodeGeo(), request, GeoResponse.class,null);
    }
}
